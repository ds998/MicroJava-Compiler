package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.test.CompilerError;
import rs.ac.bg.etf.pp1.test.CompilerError.CompilerErrorType;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
public class SemanticAnalyzer extends VisitorAdaptor {
	
	int printCallCount = 0;
	int readCallCount=0;
	int varDeclCount = 0;
	int varDeclArrayCount=0;
	int constCount=0;
	int returnFound=0;
	Obj currentMethod = null;
	int paramCount=0;
	boolean errorDetected = false;
	boolean mainName=false;
	boolean defMain=false;
	int nVars;
	private Struct currType=null;
	private ArrayList<Struct> currParamList=new ArrayList<>();
	private ArrayList<ArrayList<Struct>> currParamStack = new ArrayList<>();
	boolean switchTrue=false;
	boolean do_whileTrue=false;
	boolean caseTrue=false;
	private ArrayList<Integer> caseNum = new ArrayList<>();
	private Obj classDef=null;
	private Type ext = null;
	private ArrayList<String> extNames=new ArrayList<>();
	private ArrayList<Obj> classSym = new ArrayList<>();
	private Obj typeNode = null;
	
	
	private ArrayList<Obj> getLocalSymbols(Obj method) {
		if (currentMethod.equals(method)) {
			return new ArrayList<>(Tab.currentScope().getLocals().symbols());
		} else {
			return new ArrayList<>(method.getLocalSymbols());
		}
	}
	
	Logger log = Logger.getLogger(getClass());
	
	public SemanticAnalyzer() {
		Struct struct = new Struct(Struct.Int);
		Tab.insert(Obj.Type, "bool", struct);
		Obj ch = Tab.find("chr");
		ArrayList<Obj> ch_sym = new ArrayList<>(ch.getLocalSymbols());
		for(int i=0;i<ch_sym.size();i++) {
			ch_sym.get(i).setFpPos(i+1);
		}
		Obj or = Tab.find("ord");
		ArrayList<Obj> or_sym = new ArrayList<>(or.getLocalSymbols());
		for(int i=0;i<or_sym.size();i++) {
			or_sym.get(i).setFpPos(i+1);
		}
		Obj le = Tab.find("len");
		ArrayList<Obj> le_sym = new ArrayList<>(le.getLocalSymbols());
		for(int i=0;i<le_sym.size();i++) {
			le_sym.get(i).setFpPos(i+1);
		}
	}

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		CompilerError ce=new CompilerError(line,message,CompilerErrorType.SEMANTIC_ERROR);
		CompilerImpl.add_error(ce);
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
    
	public void visit(ProgName progName){
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	Tab.openScope();
    }
    
    public void visit(Program program){
    	nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    	
    	if(!defMain) {
    		report_error("Nije pronadjen main u programu!",program);
    	}
    	nVars = varDeclCount+varDeclArrayCount;
    }
    
    
    
    public void visit(Type type) {
    	typeNode = Tab.find(type.getTypeName());
    	if(typeNode==Tab.noObj) {
    		report_error("Nije pronadjen tip "+type.getTypeName()+" u tabeli simbola!",type);
    		type.struct = Tab.noType;
    	}
    	else {
    		if(Obj.Type==typeNode.getKind()) {
    			type.struct = typeNode.getType();
    		}
    		else {
    			report_error("Ime"+type.getTypeName()+" nije tip!",type);
        		type.struct = Tab.noType;
    		}
    	}
    	currType = type.struct;
    	
    }
    
    
    
    public void visit(ConstDeclVar constDeclVar) {
		if (Tab.currentScope().findSymbol(constDeclVar.getConstName()) != null) {
			report_error("Greska : Konstanta " + constDeclVar.getConstName()
					+ " je vec deklarisana!", constDeclVar);

		} else if (!currType.compatibleWith(constDeclVar.getConstVal().struct)) {
			report_error("Greska u definiciji konstante  "
					+ constDeclVar.getConstName() + "! Tipovi nisu kompatibilni!", constDeclVar);

		} else {
			int value = 0;
			if (constDeclVar.getConstVal() instanceof Num) {
				value = ((Num) constDeclVar.getConstVal()).getNumConst().getT();
			} else if (constDeclVar.getConstVal() instanceof Char) {
				value = ((Char) constDeclVar.getConstVal()).getCharConst().getT();
			} else if (constDeclVar.getConstVal() instanceof Bool) {
				value = ((Bool) constDeclVar.getConstVal()).getBoolConst().getT().equals("true") ? 1 : 0;
			}
			Obj con = Tab.insert(Obj.Con, constDeclVar.getConstName(), constDeclVar.getConstVal().struct);
			con.setAdr(value);
			constDeclVar.struct = con.getType();
			report_info("Deklarisana konstanta " + constDeclVar.getConstName() + " i ima vrednost " + value, constDeclVar);
		}
	}
    
    public void visit(ConstDeclVar2 constDeclVar2) {
		if (Tab.currentScope().findSymbol(constDeclVar2.getConstName()) != null) {
			report_error("Greska : Konstanta " + constDeclVar2.getConstName()
					+ " je vec deklarisana!", constDeclVar2);

		} else if (!currType.compatibleWith(constDeclVar2.getConstVal().struct)) {
			report_error("Greska u definiciji konstante  "
					+ constDeclVar2.getConstName() + "! Tipovi nisu kompatibilni!", constDeclVar2);

		} else {
			int value = 0;
			if (constDeclVar2.getConstVal() instanceof Num) {
				value = ((Num) constDeclVar2.getConstVal()).getNumConst().getT();
			} else if (constDeclVar2.getConstVal() instanceof Char) {
				value = ((Char) constDeclVar2.getConstVal()).getCharConst().getT();
			} else if (constDeclVar2.getConstVal() instanceof Bool) {
				value = ((Bool) constDeclVar2.getConstVal()).getBoolConst().getT().equals("true") ? 1 : 0;
			}
			Obj con = Tab.insert(Obj.Con, constDeclVar2.getConstName(), constDeclVar2.getConstVal().struct);
			con.setAdr(value);
			constDeclVar2.struct = con.getType();
			report_info("Deklarisana konstanta " + constDeclVar2.getConstName() + " i ima vrednost " + value, constDeclVar2);
		}
	}
    
    
    
    
    public void visit(Num n) {
    	n.struct = n.getNumConst().struct;
    }
    
    public void visit(Char c) {
    	c.struct = c.getCharConst().struct;
    }
    
    public void visit(Bool b) {
    	b.struct = b.getBoolConst().struct;
    }
    
    public void visit(NumConst numDecl) {
		numDecl.struct = Tab.intType;
	}

	public void visit(CharConst charDecl) {
		charDecl.struct = Tab.charType;
	}

	public void visit(BoolConst boolDecl) {
		boolDecl.struct = Tab.find("bool").getType();
	}
	
	public void visit(VarDeclVar varDeclVar) {
		if (Tab.currentScope().findSymbol(varDeclVar.getVarName()) != null) {
			report_error("Greska : Promenljiva " + varDeclVar.getVarName()
					+ " je vec deklarisana!", varDeclVar);

		} else {
			if (varDeclVar.getVarDeclVarIndOpt() instanceof NoVarDeclVarIndOption) {
				report_info("Deklarisana promenljiva " + varDeclVar.getVarName(), varDeclVar);
				if(classDef!=null) {
					Obj o = Tab.insert(Obj.Fld, varDeclVar.getVarName(), currType);
					boolean found = false;
					for(int i=0;i<classSym.size();i++) {
						if(classSym.get(i).getKind()==o.getKind() && classSym.get(i).getName().equals(o.getName())) {
							found = true;
							break;
						}
					}
					if(!found) {
						classSym.add(o);
					}
				}
				else {
					Obj o=Tab.insert(Obj.Var, varDeclVar.getVarName(), currType);
					boolean found = false;
					for(int i=0;i<classSym.size();i++) {
						if(classSym.get(i).getKind()==o.getKind() && classSym.get(i).getName().equals(o.getName())) {
							found = true;
							break;
						}
					}
					if(!found) {
						classSym.add(o);
					}
					
				}
				
				varDeclCount++;
			} else {
				report_info("Deklarisan niz " + varDeclVar.getVarName(), varDeclVar);
				Struct type = new Struct(Struct.Array, currType);
				if(classDef!=null) {
					Obj o = Tab.insert(Obj.Fld, varDeclVar.getVarName(), type);
					boolean found = false;
					for(int i=0;i<classSym.size();i++) {
						if(classSym.get(i).getKind()==o.getKind() && classSym.get(i).getName().equals(o.getName())) {
							found = true;
							break;
						}
					}
					if(!found) {
						classSym.add(o);
					}
				}
				else {
					Tab.insert(Obj.Var, varDeclVar.getVarName(), type);
				}
				varDeclArrayCount++;
			}

		}
	}
	
	
	public void visit(VarDeclVar2 varDeclVar) {
		if (Tab.currentScope().findSymbol(varDeclVar.getVarName()) != null) {
			report_error("Greska : Promenljiva " + varDeclVar.getVarName()
					+ " je vec deklarisana!", varDeclVar);

		} else {
			if (varDeclVar.getVarDeclVarIndOpt() instanceof NoVarDeclVarIndOption) {
				report_info("Deklarisana promenljiva " + varDeclVar.getVarName(), varDeclVar);
				if(classDef!=null) {
					Obj o = Tab.insert(Obj.Fld, varDeclVar.getVarName(), currType);
					boolean found = false;
					for(int i=0;i<classSym.size();i++) {
						if(classSym.get(i).getKind()==o.getKind() && classSym.get(i).getName().equals(o.getName())) {
							found = true;
							break;
						}
					}
					if(!found) {
						classSym.add(o);
					}
				}
				else {
					Tab.insert(Obj.Var, varDeclVar.getVarName(), currType);
				}
				varDeclCount++;
			} else {
				report_info("Deklarisan niz " + varDeclVar.getVarName(), varDeclVar);
				Struct type = new Struct(Struct.Array, currType);
				if(classDef!=null) {
					Obj o = Tab.insert(Obj.Fld, varDeclVar.getVarName(), type);
					boolean found = false;
					for(int i=0;i<classSym.size();i++) {
						if(classSym.get(i).getKind()==o.getKind() && classSym.get(i).getName().equals(o.getName())) {
							found = true;
							break;
						}
					}
					if(!found) {
						classSym.add(o);
					}
				}
				else {
					Tab.insert(Obj.Var, varDeclVar.getVarName(), type);
				}
				varDeclArrayCount++;
			}

		}
	}
	
	
	
	
	public void visit(RegTypeTN methTN) {
		String x="";
		currentMethod=Tab.insert(Obj.Meth,(methTN).getMethName(),(methTN).getType().struct);
		x=(methTN).getMethName();
		methTN.obj=currentMethod;
		ArrayList<Obj> curr = new ArrayList<>(Tab.currentScope.getLocals().symbols());
		Tab.openScope();
		report_info("Obradjuje se funkcija " + x, methTN);
		if(classDef!=null) {
			for(int i=0;i<curr.size();i++) {
				boolean found = false;
				for(int j=0;j<classSym.size();j++) {
					if(classSym.get(j).getKind() == curr.get(i).getKind() && classSym.get(j).getName().equals(curr.get(i).getName())) {
						found=true;
						break;
					}
				}
				if(!found) {
					classSym.add(currentMethod);
				}
			}
			Tab.insert(Obj.Var, "this", classDef.getType());
			
			
			
		}
	}
	
	public void visit(VoidTN methTN) {
		String x="";
		currentMethod = Tab.insert(Obj.Meth, (methTN).getMethName(), Tab.noType);
		x = (methTN).getMethName();
		methTN.obj=currentMethod;
		ArrayList<Obj> curr = new ArrayList<>(Tab.currentScope.getLocals().symbols());
		Tab.openScope();
		report_info("Obradjuje se funkcija " + x, methTN);
		if(x.equals("main") && defMain==false) {
			if(classDef==null) {
				mainName=true;
			}
		}
		if(classDef!=null) {
			for(int i=0;i<curr.size();i++) {
				boolean found = false;
				for(int j=0;j<classSym.size();j++) {
					if(classSym.get(j).getKind() == curr.get(i).getKind() && classSym.get(j).getName().equals(curr.get(i).getName())) {
						found=true;
						break;
					}
				}
				if(!found) {
					classSym.add(currentMethod);
				}
			}
			Tab.insert(Obj.Var, "this", classDef.getType());
		}
	}
	
	public void visit(MethodDecl methodDecl) {
		if (returnFound == 0 && currentMethod.getType() != Tab.noType) {
			report_error("Semanticka greska : funkcija " + currentMethod.getName()
					+ " nema return iskaz!", methodDecl);
		}
		else if(returnFound==1 && currentMethod.getType()==Tab.noType) {
			report_error("Semanticka greska : funkcija " + currentMethod.getName()
			+ " ima return povratnog tipa a void funkcija je!", methodDecl);
		}
		else if(returnFound==2 && currentMethod.getType()!=Tab.noType) {
			report_error("Semanticka greska : funkcija " + currentMethod.getName()
			+ " nema return povratnog tipa a nije void funkcija!", methodDecl);
		}
	
        
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		
		ArrayList<Obj> current_sym = new ArrayList<>(currentMethod.getLocalSymbols());
		if(mainName) {
			boolean found=false;
			for(int i=0;i<current_sym.size();i++) {
				if(current_sym.get(i).getFpPos()>0) {
					found=true;
					break;
				}
			}
			if(!found) {
				defMain=true;
			}
			
			mainName=false;
		}
		
		if(ext!=null) {
			Obj oo = Tab.find(ext.getTypeName());
			ArrayList<Obj> loc_sym = new ArrayList<>(oo.getLocalSymbols());
			ArrayList<Obj> loc_vars =new ArrayList<> (currentMethod.getLocalSymbols());
			for(int i=0;i<loc_sym.size();i++) {
				if(loc_sym.get(i).getName().equals(currentMethod.getName())) {
					ArrayList<Obj> oo_vars = new ArrayList<>(loc_sym.get(i).getLocalSymbols());
					int x=0;
					int y=0;
					int currParam=1;
					boolean correct=true;
					while(x<oo_vars.size()) {
						if(oo_vars.get(x).getFpPos()!=currParam) {
							x++;
							continue;
						}
						
						y=0;
						while(y<loc_vars.size()) {
							if(loc_vars.get(y).getFpPos()!=currParam) {
								y++;
								continue;
							}
							else break;
						}
						if(y==loc_vars.size()) {
							correct=false;
							report_error("Semanticka greska : funkcija " + currentMethod.getName()
							+ " ne slazu se brojevi argumenata u produzenoj funkciji!", methodDecl);
							break;
						}
						else {
							if(!(oo_vars.get(x).getType().compatibleWith(loc_vars.get(y).getType()))) {
								correct=false;
								report_error("Semanticka greska : funkcija " + currentMethod.getName()
								+ " ne slazu se tipovi argumenata u produzenoj funkciji!", methodDecl);
								break;
							}
							else {
								currParam++;
							}
						}
					}
					if(correct) {
						extNames.add(currentMethod.getName());
					}
				}
			}
		}

		returnFound = 0;
		paramCount = 0;
		currentMethod = null;
	}
	
	
	public void visit(FormPar formPar) {
		if(Tab.currentScope().findSymbol(formPar.getParName())!=null) {
			report_error("Greska : parametar " +formPar.getParName()+" vec deklarisan!",formPar);
		}else {
			report_info("Deklarisan parametar "+formPar.getParName(),formPar);
			if(formPar.getFormParOpt() instanceof FormalParOpt) {
				Struct type = new Struct(Struct.Array,formPar.getType().struct);
				Obj parNode = Tab.insert(Obj.Var, formPar.getParName(), type);
				parNode.setFpPos(++paramCount);
			}
			else {
				Obj parNode = Tab.insert(Obj.Var, formPar.getParName(), formPar.getType().struct);
				parNode.setFpPos(++paramCount);
			}
		}
		
	}
	
	
	public void visit(Designator designator) {
		String d = designator.getStartDesignator().getI1();
		boolean error=false;
		boolean ext_meth=false;
		if(ext!=null) {
			Obj extClass = Tab.find(ext.getTypeName());
			ArrayList<Obj> poss_ext_meth= new ArrayList<>(extClass.getLocalSymbols());
			for(int i=0;i<poss_ext_meth.size();i++) {
				if(poss_ext_meth.get(i).getKind()==Obj.Meth && poss_ext_meth.get(i).getName().equals(d)) {
					ext_meth=true;
					break;
				}
			}
		}
		if(Tab.find(d)==null && !ext_meth) {
			report_error("Greska : naveden objekat koji ne postoji!",designator);
			error=true;
			
			
		}
		else {
			Obj o = Tab.find(d);
			if(ext_meth) {
				Obj extClass = Tab.find(ext.getTypeName());
				ArrayList<Obj> poss_ext_meth= new ArrayList<>(extClass.getLocalSymbols());
				for(int i=0;i<poss_ext_meth.size();i++) {
					if(poss_ext_meth.get(i).getKind()==Obj.Meth && poss_ext_meth.get(i).getName().equals(d)) {
						o = poss_ext_meth.get(i);
						break;
					}
				}
				
			}
			designator.getStartDesignator().obj=o;
			boolean first=true;
			DesignatorFollowUp dfu = designator.getDesignatorFollowUp();
			while(!(dfu instanceof NoFolUp)) {
				DesFolUp desfup = (DesFolUp) dfu;
				DesignatorFollowUp dfu2 = desfup.getDesignatorFollowUp();
				DesignatorF df = desfup.getDesignatorF();
				if(df instanceof DotMember) {
					DesFDot dfd = ((DotMember) df).getDesFDot();
					String dfn = dfd.getD();
					if(first) {
						first=false;
						if(o.getKind()==Obj.Var && o.getType().getKind()==Struct.Class) {
							
							ArrayList<Obj> locSym = new ArrayList<>(o.getType().getMembers());
							if(o.getName().equals("this")) {
								locSym = classSym;
							}
							boolean found=false;
							int x=-1;
							for(int i=0;i<locSym.size();i++) {
								if(locSym.get(i).getName().equals(dfn)) {
									found=true;
									x=i;
								}
							}
							if(!found) {
								report_error("Greska : naveden objekat koji ne postoji!",designator);
								error=true;
								break;
							}
							else {
								dfd.object=(Integer)x;
								o = locSym.get(x);
								dfu=dfu2;
							}
							
							
						}
						else {
							report_error("Greska : naveden objekat koji ne postoji!",designator);
							error=true;
							break;
						}
					}
					else {
						if(o.getKind()==Obj.Fld) {
							ArrayList<Obj> locSym = new ArrayList<>( o.getLocalSymbols());
							if(o.getType().getKind()==Struct.Class) {
								locSym = new ArrayList<>(o.getType().getMembers());
							}
							boolean found=false;
							int x=-1;
							for(int i=0;i<locSym.size();i++) {
								if(locSym.get(i).getName().equals(dfn)) {
									found=true;
									x=i;
								}
							}
							if(!found) {
								report_error("Greska : naveden objekat koji ne postoji!",designator);
								error=true;
								break;
							}
							else {
								dfd.object=(Integer)x;
								o = locSym.get(x);
								dfu = dfu2;
								
							}
							
							
							
						}
						else if(o.getKind()==Obj.Elem) {
							ArrayList<Obj> locSym = new ArrayList<>(o.getType().getMembers());
							boolean found=false;
							int x=-1;
							for(int i=0;i<locSym.size();i++) {
								if(locSym.get(i).getName().equals(dfn)) {
									found=true;
									x=i;
								}
							}
							if(!found) {
								report_error("Greska : naveden objekat koji ne postoji!",designator);
								error=true;
								break;
							}
							else {
								dfd.object=(Integer)x;
								o = locSym.get(x);
								dfu=dfu2;
							}
							
						}
						else {
							report_error("Greska : naveden objekat koji ne postoji!",designator);
							error=true;
							break;
						}
					}
					
					
				}
				else {
					if(first) {
						first=false;
						if(o.getKind()==Obj.Var && o.getType().getKind()==Struct.Array) {
							DesFArr dfa = ((ArrMember) df).getDesFArr();
							Expr e = dfa.getExpr();
							if(e.struct.getKind()!= Struct.Int) {
								report_error("Greska : naveden operator za indeks koji nije tipa int!",designator);
								error = true;
								break;
							}
							else {
								dfu=dfu2;
								Struct t=o.getType().getElemType();
								dfa.struct=t;
								o = new Obj(Obj.Elem,"",t);
							}
							
							
						}
						else {
							report_error("Greska : naveden operator za indeks za objekat koji nije niz!",designator);
							error = true;
							break;
						}
					}
					else {
						if(o.getKind()==Obj.Fld && o.getType().getKind()==Struct.Array) {
							DesFArr dfa = ((ArrMember) df).getDesFArr();
							Expr e = dfa.getExpr();
							if(e.struct.getKind()!= Struct.Int) {
								report_error("Greska : naveden operator za indeks koji nije tipa int!",designator);
								error=true;
								break;
							}
							else {
								dfu=dfu2;
								dfa.struct=o.getType().getElemType();
								o = new Obj(Obj.Elem,"elem",o.getType().getElemType());
							}
							
							
						}
						else {
							report_error("Greska : naveden operator za indeks za objekat koji nije niz!",designator);
							error=true;
							break;
						}
					}
						
				}
			}
			
			if(!error) {
				if(o!=null) {
					designator.obj=o;
				}
				else {
					designator.obj=Tab.noObj;
				}
				
				SyntaxNode sn = designator.getParent();
				if(sn instanceof PDesignator) {
					if(currParamList.size()>0) {
						currParamStack.add(currParamList);
					}
					currParamList=new ArrayList<Struct>();
				}
				else if(sn instanceof DesignatorStatement) {
					DesignatorStatement ds = (DesignatorStatement) sn;
					if(ds.getDesignatorOp() instanceof ActualParams) {
						if(currParamList.size()>0) {
							currParamStack.add(currParamList);
						}
						currParamList=new ArrayList<Struct>();
					}
				}
			}
			
		}
		
	}
	
	
	
	public void visit(OneFactor of) {
		of.struct  = (of).getFactor().struct;
	}
	
	public void visit(MulFactor mf) {
		
		Term term2 = mf.getTerm();
		Factor fact = mf.getFactor();
		if(fact.struct.getKind()==Struct.Int && term2.struct.getKind()==Struct.Int) {
			mf.struct = fact.struct;
		}
		else if(term2.struct.getKind()==Struct.Array && term2.struct.getElemType().getKind()==Struct.Int && fact.struct.getKind()==Struct.Array && fact.struct.getElemType().getKind()==Struct.Int && mf.getMulOp().getClass()==Mul.class) {
			mf.struct=fact.struct.getElemType();
		}
		else if(term2.struct.getKind()==Struct.Array && term2.struct.getElemType().getKind()==Struct.Int && fact.struct.getKind()==Struct.Int  && mf.getMulOp().getClass()==Mul.class) {
			mf.struct=fact.struct;
		}
		else if(term2.struct.getKind()==Struct.Int && fact.struct.getKind()==Struct.Array && fact.struct.getElemType().getKind()==Struct.Int && mf.getMulOp().getClass()==Mul.class) {
			mf.struct=term2.struct;
		}
		else {
			report_error("Greska : koriscen ne-int tip u izrazu!",mf);
			
		}
	}
	
	
	
	public void visit(OneTerm ot) {
		ot.struct = ot.getTerm().struct;
	}
	
	public void visit(MultipleTerms mt) {
		
		PlusTerms pl2 = mt.getPlusTerms();
		Term t = mt.getTerm();
		if(pl2.struct.getKind()==Struct.Int && t.struct.getKind()==Struct.Int) {
			mt.struct = t.struct;
		}
		else {
			report_error("Greska : koriscen ne-int tip u izrazu!",mt);
		}
	}
	
	
	
	public void visit(MinusExpr me) {
		if(me.getPlusTerms().struct.getKind()!=Struct.Int) {
			report_error("Greska : koriscen ne-int tip u izrazu!",me);
		}
		me.struct = me.getPlusTerms().struct;
	}
	
	public void visit(PlusExpr pe) {
		pe.struct = pe.getPlusTerms().struct;
	}
	
	
	public void visit(OneExpression oe) {
		oe.struct = oe.getExpr1().struct;
	}
	
	
	
	
	public void visit(NoFuncDesignator nfd) {
		nfd.struct = nfd.getDesignator().obj.getType();
	}
	
	public void visit(NoParamDesignator npd) {
		npd.struct = npd.getNPDesignator().struct;
	}
	
	public void visit(ParamDesignator pd) {
		pd.struct = pd.getPDesignator().struct;
	}
	
	public void visit(NumFactor nf) {
		nf.struct = nf.getNumConst().struct;
	}
	
	public void visit(CharFactor cf) {
		cf.struct = cf.getCharConst().struct;
	}
	
	public void visit(BoolFactor bf) {
		bf.struct = bf.getBoolConst().struct;
	}
	
	public void visit(NewFactor nf) {
		Type t = nf.getType();
		Obj o = Tab.find(t.getTypeName());
		if(o.getType().getKind()!=Struct.Class) {
			report_error("Greska : ne postoji ovakav korisnicki tip!",nf);
		}
		else {
			nf.struct = t.struct;
		}
	}
	
	public void visit(NewArrFactor naf) {
		Expr e = naf.getExpr();
		Type t = naf.getType();
		if(e.struct.getKind()!=Struct.Int) {
			report_error("Greska : ne moze da se koristi ne-int izraz u new[] operatoru!",naf);
		}
		else{
			naf.struct = new Struct(Struct.Array,t.struct);
		}
	}
	
	public void visit(ExprFactor ef) {
		Expr e = ef.getExpr();
		ef.struct= e.struct;
	}
	
	
	
	
	public void visit(RelationExpr re) {
		Expr first = re.getExpr();
		Expr second = re.getExpr1();
		RelOp ro = re.getRelOp();
		if(!first.struct.compatibleWith(second.struct)) {
			report_error("Greska : izrazi sa strana relacije nisu istog tipa!",re);
		}
		else {
			if(first.struct.getKind()==Struct.Array || first.struct.getKind()==Struct.Class) {
				if(!((ro instanceof NEqual) || (ro instanceof DEqual))) {
					report_error("Greska : ne moze da se koristi ova relacija za ovakve tipove!",re);
				}
			}
		}
	}
	
	
	public void visit(ActualParameter ap) {
		currParamList.add(ap.getExpr().struct);
	}
	
	public void visit(ActualParameters ap) {
		currParamList.add(ap.getExpr().struct);
	}
	
	public void visit(NPDesignator npdesignator) {
		Designator desig = npdesignator.getDesignator();
		Obj o = desig.obj;
		if(o.getKind()!=Obj.Meth) {
			report_error("Greska : identifikator nije funkcija!",npdesignator);
			npdesignator.struct = Tab.noType;
		}
		else if(o.getKind()==Obj.Meth && o.getType()==Tab.noType) {
			report_error("Greska : ne moze da se koristi funkcija tipa void u izrazima!",npdesignator);
			npdesignator.struct = Tab.noType;
		}
		else {
			ArrayList<Obj> local_sym = getLocalSymbols(o);
			boolean x = false;
			for(int i=0;i<local_sym.size();i++) {
				if(local_sym.get(i).getFpPos()>0) {
					x=true;
					break;
				}
			}
			
			if(x) {
				report_error("Greska : pogresan broj parametara u pozivu!",npdesignator);
			}
			else {
				npdesignator.struct = o.getType();
			}
		}
	}
	
	public void visit(PDesignator pdesignator) {
		Designator desig = pdesignator.getDesignator();
		Obj o = desig.obj;
		if(o.getKind()!=Obj.Meth) {
			report_error("Greska : identifikator nije funkcija!",pdesignator);
			pdesignator.struct = Tab.noType;
		}
		else if(o.getKind()==Obj.Meth && o.getType()==Tab.noType) {
			report_error("Greska : ne moze da se koristi funkcija tipa void u izrazima!",pdesignator);
			pdesignator.struct = Tab.noType;
		}
		else {
			int currParam=1;
			ArrayList<Obj> loc_sym = getLocalSymbols(o);
			while(currParamList.size()>0) {
				Struct expr = currParamList.get(0);
				boolean found=false;
				int x = -1;
				for(int i = 0; i<loc_sym.size();i++) {
					if(loc_sym.get(i).getFpPos()==currParam) {
						currParam++;
						found=true;
						x=i;
						break;
					}
				}
				if(!found) {
					report_error("Greska : pogresan broj parametara u pozivu!",pdesignator);
				}
				else {
					if(!loc_sym.get(x).getType().compatibleWith(expr)) {
						report_error("Greska : pogresan tip parametra u pozivu!",pdesignator);
					}
					else {
						currParamList.remove(0);
						
					}
				}
				
			}
			
			if(currParamList.size()==0) {
				boolean more_args=false;
				for(int i = 0; i<loc_sym.size();i++) {
					if(loc_sym.get(i).getFpPos()==currParam) {
						currParam++;
						more_args=true;
						break;
					}
				}
				if(more_args) {
					report_error("Greska : pogresan broj parametara u pozivu!",pdesignator);
					pdesignator.struct = Tab.noType;
				}
				else pdesignator.struct = o.getType();
			}
			else {
				pdesignator.struct = Tab.noType;
			}
			
			while (currParamList.size() > 0)
				currParamList.remove(0);
			
			if (currParamStack.size() > 0)
				currParamList = currParamStack.remove(currParamStack.size() - 1);
		}
	}
	
	
	
	public void visit(Assignment as) {
		AssignmentOp ao = (AssignmentOp)as.getAssignmentOperation();
		Expr e = ao.getExpr();
		as.struct = e.struct;
	}
	
	public void visit(NoParams np) {
		Designator desig = ((DesignatorStatement)np.getParent()).getDesignator();
		Obj o = desig.obj;
		if(o.getKind()!=Obj.Meth) {
			report_error("Greska : identifikator nije funkcija!",np);
			np.struct = Tab.noType;
		}
		else {
			ArrayList<Obj> local_sym = getLocalSymbols(o);
			boolean x = false;
			for(int i=0;i<local_sym.size();i++) {
				if(local_sym.get(i).getFpPos()>0) {
					x=true;
					break;
				}
			}
			
			if(x) {
				report_error("Greska : pogresan broj parametara u pozivu!",np);
			}
			else {
				np.struct = o.getType();
			}
		}
	}
	
	public void visit(ActualParams ap) {
		Designator desig = ((DesignatorStatement)ap.getParent()).getDesignator();
		Obj o = desig.obj;
		if(o.getKind()!=Obj.Meth) {
			report_error("Greska : identifikator nije funkcija!",ap);
			
		}
		else {
			int currParam=1;
			ArrayList<Obj> loc_sym = getLocalSymbols(o);
			while(currParamList.size()>0) {
				Struct expr = currParamList.get(0);
				boolean found=false;
				int x = -1;
				for(int i = 0; i<loc_sym.size();i++) {
					if(loc_sym.get(i).getFpPos()==currParam) {
						currParam++;
						found=true;
						x=i;
						break;
					}
				}
				if(!found) {
					report_error("Greska : pogresan broj parametara u pozivu!",ap);
				}
				else {
					if(!loc_sym.get(x).getType().compatibleWith(expr)) {
						report_error("Greska: pogresan tip parametra u pozivu!",ap);
					}
					else {
						currParamList.remove(0);
						
					}
				}
				
			}
			
			if(currParamList.size()==0) {
				boolean more_args=false;
				for(int i = 0; i<loc_sym.size();i++) {
					if(loc_sym.get(i).getFpPos()==currParam) {
						currParam++;
						more_args=true;
						break;
					}
				}
				if(more_args) {
					report_error("Greska : pogresan broj parametara u pozivu!",ap);
					ap.struct = Tab.noType;
				}
				else ap.struct = o.getType();
			}
			else {
				ap.struct = Tab.noType;
			}
			
			while (currParamList.size() > 0)
				currParamList.remove(0);
			
			if (currParamStack.size() > 0)
				currParamList = currParamStack.remove(currParamStack.size() - 1);
		}
	}
	
	public void visit(DesignatorStatement ds) {
		DesignatorOp desop = ds.getDesignatorOp();
		Designator desig = ds.getDesignator();
		
		if(desop instanceof Assignment) {
			boolean mop = !(desig.obj.getType().getKind()==0);
			boolean dop = !(desop.struct.getKind()==0);
			if(!(desig.obj.getKind()!=Obj.Var) && !checkDodela(desig.obj.getType(),mop,desop.struct,dop)) {
				report_error("Greska : nekompatibilni tipovi pri dodeli!",ds);
			}
		}
		else if(desop instanceof Increment || desop instanceof Decrement) {
			if((desig.obj.getType().getKind()!=Struct.Int) || (desig.obj.getKind()!=Obj.Var && desig.obj.getKind()!=Obj.Fld)) {
				report_error("Greska : nekompatibilni tipovi pri dodeli!",ds);
			}
		}
	}
	
	private boolean checkDodela(Struct dst,boolean dest,Struct src,boolean source) {
		if(dest && source) {
			if(dst.getKind() ==src.getKind()) {
				if(dst.getKind()==Struct.Array && dst.getElemType().getKind()!=src.getElemType().getKind()) {
					return false;
				}
				else if(dst.getKind()==Struct.Class) {
					if(src.getElemType()!=null) {
						if(!src.getElemType().compatibleWith(dst)) {
							return false;
						}
					}
					
				}
				return true;
			}
		}
		else if(dest) {
			if(src.assignableTo(dst)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void visit(BreakStmt bs) {
		if(do_whileTrue && switchTrue) {
		    if(!caseTrue) {
		    	report_error("Greska : break van case opsega!",bs);
		    }
		}
		else if(switchTrue) {
			if(!caseTrue) {
		    	report_error("Greska : break van case opsega!",bs);
		    }
		}
		else if(!do_whileTrue) {
			report_error("Greska : break van do_while opsega!",bs);
		}
	}
	
	public void visit(ContinueStmt cs) {
		if(!do_whileTrue) {
			report_error("Greska : continue van do_while opsega!",cs);
		}
	}
	
	public void visit(DoS dos) {
		do_whileTrue=true;
	}
	
	public void visit(DoStmt dos) {
		do_whileTrue=false;
	}
	
	public void visit(SwitchS sws) {
		switchTrue=true;
		caseNum = new ArrayList<>();
	}
	
	public void visit(SwitchStmt sws) {
		switchTrue = false;
	}
	
	public void visit(Case c) {
		caseTrue=false;
		int x = c.getCaseStart().getNumConst().getT();
		boolean found=false;
		for(int i=0;i<caseNum.size();i++) {
			if(caseNum.get(i).equals(x)) {
				found=true;
			}
		}
		if(found) {
			report_error("Greska : ista promenljiva u vise case slucajeva!",c);
		}
		else {
			caseNum.add(x);
		}
	}
	
	public void visit(CaseStart cs) {
		caseTrue=true;
	}
	
	public void visit(ReturnStmt rs) {
		RetExprOpt reo = rs.getRetExprOpt();
		if(currentMethod==null) {
			report_error("Greska : return iskaz van f-je!",rs);
		}
		else {
			if(reo instanceof ReturnExprOpt) {
				returnFound=1;
				ReturnExprOpt reteo = (ReturnExprOpt) reo;
				Expr e = reteo.getExpr();
				if(!currentMethod.getType().compatibleWith(e.struct)) {
					report_error("Greska : pogresan povratni tip u f-ji!",rs);
				}
				
			}
			else {
				returnFound=2;
				
				if(!(currentMethod.getType()!=Tab.noType)) {
					report_error("Greska : funkcija ne vraca nista!",rs);
				}
			}
		}
		
	}
	
	public void visit(ReadStmt rs) {
		Designator desig = rs.getDesignator();
		if(!(desig.obj.getKind()==Obj.Var || desig.obj.getKind()==Obj.Fld || desig.obj.getKind()==Obj.Elem)) {
			
		
			report_error("Greska : read funkcija za argumente prima samo promenljive,klasna polja, i elemente niza!",rs);
			
		}
		else {
			
			Struct intArg = Tab.find("int").getType();
			Struct charArg = Tab.find("char").getType();
			Struct boolArg = Tab.find("bool").getType();
			
			Struct struct = desig.obj.getType();
			
			if (!struct.compatibleWith(intArg) && !struct.compatibleWith(charArg) && !struct.compatibleWith(boolArg)) {
				report_error("Greska : Argument funkcije read nije tipa int, char ili bool!", rs);
			} else
				readCallCount++;
		}
	}
	
	public void visit(PrintStmt ps) {
		Expr e = ps.getExpr();
		
		Struct intArg = Tab.find("int").getType();
		Struct charArg = Tab.find("char").getType();
		Struct boolArg = Tab.find("bool").getType();
		
		Struct struct = e.struct;
		
		if (!struct.compatibleWith(intArg) && !struct.compatibleWith(charArg) && !struct.compatibleWith(boolArg)) {
			report_error("Greska : Argument funkcije print nije tipa int, char ili bool!", ps);
		} else
			printCallCount++;
	}
	
	
	public void visit(ClassName cs) {
		String name = cs.getI1();
		ClassExtOpt ceo = cs.getClassExtOpt();
		if(Tab.currentScope().findSymbol(name)!=null) {
			report_error("Greska : Klasa sa istim imenom vec deklarisana!", cs);
		}
		else {
			Struct s =null;
			boolean c = false;
			if(ceo instanceof ClassExtension) {
				c = true;
				ClassExtension ce = (ClassExtension) ceo;
				String exs = ce.getType().getTypeName();
				if(Tab.currentScope().findSymbol(exs)==Tab.noObj) {
					report_error("Greska : Produzeni tip ne postoji!", cs);
				}
				Obj o = Tab.find(exs);
				if(o.getType().getKind()!=Struct.Class) {
					report_error("Greska na liniji : Argument funkcije read nije tipa int, char ili bool!", cs);
				}
				s = new Struct(Struct.Class,o.getType());
			}
			else {
				s = new Struct(Struct.Class);
			}
			classDef = Tab.insert(Obj.Type, name, s);
			Tab.openScope();
			Tab.insert(Obj.Var, "this", classDef.getType());
			if(c) {
				ClassExtension ce = (ClassExtension) ceo;
				String exs = ce.getType().getTypeName();
				Obj o = Tab.find(exs);
				ext = ce.getType();
				ArrayList<Obj> loc_sym = new ArrayList<>(o.getLocalSymbols());
				for(int i=0;i<loc_sym.size();i++) {
					if(loc_sym.get(i).getKind()==Obj.Fld) {
						Tab.insert(Obj.Fld,loc_sym.get(i).getName(),loc_sym.get(i).getType());
					}
					classSym.add(loc_sym.get(i));
				}
			}
		}
		
		
	}
	
	public void visit(ClassDecl cd) {
		if(ext!=null) {
			String e = ext.getTypeName();
			Obj oo= Tab.find(e);
			
			ArrayList<Obj> loc_sym = new ArrayList<>(oo.getLocalSymbols());
			for(int i=0;i<loc_sym.size();i++) {
				if(loc_sym.get(i).getKind()==Obj.Meth) {
					if(!(extNames.contains(loc_sym.get(i).getName()))) {
						Obj currClassMeth=Tab.insert(Obj.Meth,loc_sym.get(i).getName(),loc_sym.get(i).getType());
						currClassMeth.setFpPos(loc_sym.get(i).getFpPos());
						Tab.openScope();
						ArrayList<Obj> local_meth_sym = new ArrayList<>(loc_sym.get(i).getLocalSymbols());
						Tab.insert(Obj.Var, "this", classDef.getType());
						for(int j=1;j<local_meth_sym.size();j++) {
							Obj ix =Tab.insert(local_meth_sym.get(j).getKind(), local_meth_sym.get(j).getName(), local_meth_sym.get(j).getType());
							ix.setFpPos(local_meth_sym.get(j).getFpPos());
						}
						Tab.chainLocalSymbols(currClassMeth);
						Tab.closeScope();
					}
				}
			}
		}
		
		Tab.chainLocalSymbols(classDef.getType());
		Tab.chainLocalSymbols(classDef);
		
		Tab.closeScope();
		ext=null;
		classDef=null;
		classSym = new ArrayList<>();
	}
	
	public boolean passed() {
		return !errorDetected;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
