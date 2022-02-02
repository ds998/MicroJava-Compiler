package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.ast.ActualParams;
import rs.ac.bg.etf.pp1.ast.ArrMember;
import rs.ac.bg.etf.pp1.ast.Assignment;
import rs.ac.bg.etf.pp1.ast.BoolFactor;
import rs.ac.bg.etf.pp1.ast.BreakStmt;
import rs.ac.bg.etf.pp1.ast.Case;
import rs.ac.bg.etf.pp1.ast.CaseStart;
import rs.ac.bg.etf.pp1.ast.CharFactor;
import rs.ac.bg.etf.pp1.ast.CondFact;
import rs.ac.bg.etf.pp1.ast.CondTerm;
import rs.ac.bg.etf.pp1.ast.CondTermLeftAnd;
import rs.ac.bg.etf.pp1.ast.ConditionLeftOr;
import rs.ac.bg.etf.pp1.ast.ConditionalFactors;
import rs.ac.bg.etf.pp1.ast.ConditionalTerm;
import rs.ac.bg.etf.pp1.ast.ConditionalTerms;
import rs.ac.bg.etf.pp1.ast.ConstDeclVar;
import rs.ac.bg.etf.pp1.ast.ConstDeclVar2;
import rs.ac.bg.etf.pp1.ast.ContinueStmt;
import rs.ac.bg.etf.pp1.ast.DEqual;
import rs.ac.bg.etf.pp1.ast.DesFArr;
import rs.ac.bg.etf.pp1.ast.DesFDot;
import rs.ac.bg.etf.pp1.ast.DesFolUp;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.DesignatorF;
import rs.ac.bg.etf.pp1.ast.DesignatorFollowUp;
import rs.ac.bg.etf.pp1.ast.DesignatorStatement;
import rs.ac.bg.etf.pp1.ast.Div;
import rs.ac.bg.etf.pp1.ast.DoS;
import rs.ac.bg.etf.pp1.ast.DoStmt;
import rs.ac.bg.etf.pp1.ast.ElseStmt;
import rs.ac.bg.etf.pp1.ast.Expr1;
import rs.ac.bg.etf.pp1.ast.ExprFactor;
import rs.ac.bg.etf.pp1.ast.Gt;
import rs.ac.bg.etf.pp1.ast.Gt_e;
import rs.ac.bg.etf.pp1.ast.IfCondition;
import rs.ac.bg.etf.pp1.ast.IfElseStmt;
import rs.ac.bg.etf.pp1.ast.IfStmt;
import rs.ac.bg.etf.pp1.ast.Increment;
import rs.ac.bg.etf.pp1.ast.LRIndicator;
import rs.ac.bg.etf.pp1.ast.Le;
import rs.ac.bg.etf.pp1.ast.Le_e;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodTN;
import rs.ac.bg.etf.pp1.ast.Minus;
import rs.ac.bg.etf.pp1.ast.MinusExpr;
import rs.ac.bg.etf.pp1.ast.Mul;
import rs.ac.bg.etf.pp1.ast.MulFactor;
import rs.ac.bg.etf.pp1.ast.MultipleTerms;
import rs.ac.bg.etf.pp1.ast.NEqual;
import rs.ac.bg.etf.pp1.ast.NPDesignator;
import rs.ac.bg.etf.pp1.ast.NewArrFactor;
import rs.ac.bg.etf.pp1.ast.NewFactor;
import rs.ac.bg.etf.pp1.ast.NoFolUp;
import rs.ac.bg.etf.pp1.ast.NoFuncDesignator;
import rs.ac.bg.etf.pp1.ast.NoNumConst;
import rs.ac.bg.etf.pp1.ast.NoParamDesignator;
import rs.ac.bg.etf.pp1.ast.NoParams;
import rs.ac.bg.etf.pp1.ast.NumConst;
import rs.ac.bg.etf.pp1.ast.NumFactor;
import rs.ac.bg.etf.pp1.ast.PDesignator;
import rs.ac.bg.etf.pp1.ast.ParamDesignator;
import rs.ac.bg.etf.pp1.ast.Plus;
import rs.ac.bg.etf.pp1.ast.PossNumConst;
import rs.ac.bg.etf.pp1.ast.PossibleNumConst;
import rs.ac.bg.etf.pp1.ast.PrintStmt;
import rs.ac.bg.etf.pp1.ast.ProgName;
import rs.ac.bg.etf.pp1.ast.ReadStmt;
import rs.ac.bg.etf.pp1.ast.RegTypeTN;
import rs.ac.bg.etf.pp1.ast.RelOp;
import rs.ac.bg.etf.pp1.ast.RelationExpr;
import rs.ac.bg.etf.pp1.ast.ReturnStmt;
import rs.ac.bg.etf.pp1.ast.StartDesignator;
import rs.ac.bg.etf.pp1.ast.SuccCond;
import rs.ac.bg.etf.pp1.ast.SwitchS;
import rs.ac.bg.etf.pp1.ast.SwitchStmt;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.ac.bg.etf.pp1.ast.VoidTN;
import rs.ac.bg.etf.pp1.ast.WhileStmt;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	private int mainPc;
	private int field_val=0;
	public int getMainPc(){
		return mainPc;
	}
	
	public void visit(ProgName progName) {
		
		Obj obj = Tab.find("chr");
		obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load_n);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		
		obj = Tab.find("ord");
		obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load_n);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		obj= Tab.find("len");
		obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load_n);
		Code.put(Code.arraylength);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		
		
		
		
	}
	
	public void visit(ReadStmt readStmt) {
		if(readStmt.getDesignator().obj.getType()!=Tab.charType) {
			Code.put(Code.read);
		}
		else {
			Code.put(Code.bread);
		}
		if (readStmt.getDesignator().obj.getKind() != Obj.Elem)
            Code.store(readStmt.getDesignator().obj);
        else if (readStmt.getDesignator().obj.getType() != Tab.intType)
            Code.put(Code.astore);
        else
            Code.put(Code.bastore);
	}
	
	public void visit(PrintStmt printStmt) {
		if(printStmt.getPossNumConst() instanceof NoNumConst) {
			Code.loadConst(5);
		}
		else {
			PossibleNumConst pnc=(PossibleNumConst)(printStmt.getPossNumConst());
			Code.loadConst(pnc.getNumConst().getT());
		}
		if(printStmt.getExpr().struct!=Tab.charType) {
			Code.put(Code.print);
		}
		else {
			Code.put(Code.bprint);
		}
		
	}
	
	public void visit(MinusExpr me) {
		Code.put(Code.neg);
	}
	
	public void visit(NumFactor number) {

			Obj con=Tab.insert(Obj.Con, "$", number.struct);
			con.setLevel(0);
			con.setAdr(number.getNumConst().getT());
			
			Code.load(con);
		
		
		
	}
	public void visit(CharFactor cf) {
			Obj con=Tab.insert(Obj.Con, "$", cf.struct);
			con.setLevel(0);
			con.setAdr(cf.getCharConst().getT());
			
			Code.load(con);
		
		
	}
	
	
	public void visit(BoolFactor bf) {
		
			Obj con=Tab.insert(Obj.Con, "$", bf.struct);
			con.setLevel(0);
			con.setAdr(bf.getBoolConst().getT().equals("true")?1:0);
			Code.load(con);
		
		
	}
	
	public void visit(NewFactor nf) {
		Code.put(Code.new_);
		Code.put2(nf.getType().struct.getNumberOfFields()*4);
	
	}
	
	public void visit(NewArrFactor naf) {
		Code.put(Code.newarray);
		if(naf.getType().struct==Tab.charType) {
			Code.put(0);
		}
		else Code.put(1);
	}
	
	public void visit(MulFactor mf) {
	
			if(mf.getMulOp().getClass()==Mul.class) {
	        	if(mf.getTerm().struct.getKind()==Struct.Int && mf.getFactor().struct.getKind()==Struct.Int)Code.put(Code.mul);
	        	else if(mf.getTerm().struct.getKind()==Struct.Array && mf.getFactor().struct.getKind()==Struct.Array) {
	        		
	        		
	        		Struct t=new Struct(Struct.Array,Tab.intType);
	        		
	        		
	        		
	        		Obj arr1=new Obj(Obj.Var, "123arr1", t,105,1);
	        		Obj arr2=new Obj(Obj.Var, "123arr2", t,106,1);
	        		Obj count_obj=new Obj(Obj.Var, "123arrcnt", Tab.intType,107,1);
	        		Obj result_obj=new Obj(Obj.Var,"123arrresult",Tab.intType,108,1);
	        		Code.store(arr2);
	        		Code.store(arr1);
	        		Code.loadConst(0);
	        		Code.store(result_obj);
	        		Code.load(arr1);
	        		Code.put(Code.arraylength);
	        		Code.store(count_obj);
	        		int loop_adr=Code.pc;
	        		Code.load(result_obj);
	        		Code.load(arr1);
	        		Code.load(count_obj);
	        		Code.loadConst(1);
	        		Code.put(Code.sub);
	        		Code.put(Code.aload);
	        		Code.load(arr2);
	        		Code.load(count_obj);
	        		Code.loadConst(1);
	        		Code.put(Code.sub);
	        		Code.put(Code.aload);
	        		Code.put(Code.mul);
	        		Code.put(Code.add);
	        		Code.store(result_obj);
	        		Code.load(count_obj);
	        		Code.loadConst(1);
	        		Code.put(Code.sub);
	        		Code.store(count_obj);
	        		Code.load(count_obj);
	        		Code.loadConst(0);
	        		Code.put(Code.jcc+Code.ne);
	        		Code.put2(loop_adr-Code.pc+1);
	        		Code.load(result_obj);
	        		
	        	}
	        	else if((mf.getTerm().struct.getKind()==Struct.Int && mf.getFactor().struct.getKind()==Struct.Array) || (mf.getTerm().struct.getKind()==Struct.Array && mf.getFactor().struct.getKind()==Struct.Int)) {
					Struct t=new Struct(Struct.Array,Tab.intType);
					Obj arr=new Obj(Obj.Var, "123arr", t,109,1);
					Obj arr_mul=new Obj(Obj.Var, "123arrcnt", Tab.intType,110,1);
					Obj count_obj=new Obj(Obj.Var, "123arrcnt", Tab.intType,111,1);
	        		Obj result_obj=new Obj(Obj.Var,"123arrresult",Tab.intType,112,1);
	        		if(mf.getTerm().struct.getKind()==Struct.Int) {
	        			Code.store(arr);
	        			Code.store(arr_mul);
	        		}
	        		else {
	        			Code.store(arr_mul);
	        			Code.store(arr);
	        		}
	        		Code.loadConst(0);
	        		Code.store(result_obj);
	        		Code.load(arr);
	        		Code.put(Code.arraylength);
	        		Code.store(count_obj);
	        		int loop_adr=Code.pc;
	        		Code.load(result_obj);
	        		Code.load(arr);
	        		Code.load(count_obj);
	        		Code.loadConst(1);
	        		Code.put(Code.sub);
	        		Code.put(Code.aload);
	        		Code.load(arr_mul);
	        		Code.put(Code.mul);
	        		Code.put(Code.add);
	        		Code.store(result_obj);
	        		Code.load(count_obj);
	        		Code.loadConst(1);
	        		Code.put(Code.sub);
	        		Code.store(count_obj);
	        		Code.load(count_obj);
	        		Code.loadConst(0);
	        		Code.put(Code.jcc+Code.ne);
	        		Code.put2(loop_adr-Code.pc+1);
	        		Code.load(result_obj);
				}

			}
			else if(mf.getMulOp().getClass()==Div.class) {
	        	Code.put(Code.div);

			}
			else {
	        	Code.put(Code.rem);
			}
		
		
	}
	
	public void visit(MultipleTerms mt) {
		
			if(mt.getAddOp().getClass()==Plus.class) {
				Code.put(Code.add);
			}
			else if(mt.getAddOp().getClass()==Minus.class) {
				Code.put(Code.sub);
			}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public void visit(RegTypeTN rtTN) {
		rtTN.obj.setAdr(Code.pc);
		if(rtTN.obj.getName().equals("main")) {
			mainPc=Code.pc;
		}
		
		// Collect arguments and local variables
		SyntaxNode methodNode = rtTN.getParent();
	
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);
		
		// Generate the entry
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(fpCnt.getCount()+varCnt.getCount());
		
	}
	
	public void visit(VoidTN voidTN) {
		voidTN.obj.setAdr(Code.pc);
		if(voidTN.obj.getName().equals("main")) {
			mainPc=Code.pc;
		}
		
		// Collect arguments and local variables
		SyntaxNode methodNode = voidTN.getParent();
	
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);
		
		// Generate the entry
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(fpCnt.getCount() + varCnt.getCount());
	}
	
	public void visit(MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(NoFuncDesignator nfd) {
		if(nfd.getDesignator().getDesignatorFollowUp().getClass()==DesFolUp.class) {
			if(nfd.getDesignator().obj.getKind()==Obj.Elem) {
				Code.load(nfd.getDesignator().obj);
			}
			else {
				Code.put(Code.getfield);
				Code.put2(field_val);
			}
		}
	}
	
	public void visit(DesignatorStatement ds) {
		if(ds.getDesignatorOp().getClass()==Assignment.class) {
			if(ds.getDesignator().getDesignatorFollowUp().getClass()!=DesFolUp.class)Code.store(ds.getDesignator().obj);
			else {
				if(ds.getDesignator().obj.getKind()==Obj.Elem) {
					Code.store(ds.getDesignator().obj);
				}
				else {
					Code.put(Code.putfield);
					Code.put2(field_val);
				}
			}
			
		}
		else if(ds.getDesignatorOp().getClass()==ActualParams.class || ds.getDesignatorOp().getClass()==NoParams.class) {
			if(belongsToClass(ds.getDesignator().obj)) {
				classMeth(ds.getDesignator());
			}
			else {
				Code.put(Code.call);
				Code.put2(ds.getDesignator().obj.getAdr()-Code.pc+1);
			}
			if(ds.getDesignator().obj.getType()!=Tab.noType) {
				Code.put(Code.pop);
			}
		}
		else{
			if(ds.getDesignator().obj.getKind()==Obj.Elem) {
				Code.put(Code.dup2);
			}
			if (ds.getDesignator().obj.getKind() != Obj.Elem)
	            Code.load(ds.getDesignator().obj);
	        else if (ds.getDesignator().obj.getType() == Tab.intType)
	            Code.put(Code.aload);
	        else
	            Code.put(Code.baload);
	        Code.loadConst(1);
	        if(ds.getDesignatorOp().getClass()==Increment.class) {
	        	Code.put(Code.add);
	        }
	        else {
	        	Code.put(Code.sub);
	        }
	        if (ds.getDesignator().obj.getKind() != Obj.Elem)
	            Code.store(ds.getDesignator().obj);
	        else if (ds.getDesignator().obj.getType() == Tab.intType)
	            Code.put(Code.astore);
	        else
	            Code.put(Code.bastore);
		}
	}
	
	public void visit(StartDesignator sd) {
		Code.load(sd.obj);
	}
	
	public void visit(DesFArr dfarr) {
		DesFolUp dfu = (DesFolUp)dfarr.getParent().getParent();
		if(dfu.getDesignatorFollowUp().getClass()==NoFolUp.class) return;
		if(dfarr.struct.equals(Tab.charType))Code.put(Code.baload);
		else Code.put(Code.aload);
	}
	
	public void visit(DesFDot dfd) {
		DesFolUp dfu = (DesFolUp)dfd.getParent().getParent();
		if(dfu.getDesignatorFollowUp().getClass()==NoFolUp.class) {
			field_val=(int)dfd.object;
			return;
		}
		Code.put(Code.getfield);
		Code.put2((int)dfd.object);
	}
	
	
	
	/*
	public void visit(Designator ds) {
		
		SyntaxNode parent=ds.getParent();
		if(DesignatorStatement.class != parent.getClass() && NPDesignator.class!=parent.getClass() && PDesignator.class!=parent.getClass()) {
			if(ds.obj.getKind()==Obj.Elem) {
				Code.load(ds.getStartDesignator().obj);
				Code.put(Code.dup_x1);
				Code.put(Code.pop);
				if(ds.obj.getType()==Tab.charType) Code.put(Code.baload);
				else Code.put(Code.aload);
			}else Code.load(ds.obj);
		}
		else {
			if(DesignatorStatement.class==parent.getClass() && ds.obj.getKind()==Obj.Elem) {
				Code.load(ds.getStartDesignator().obj);
				Code.put(Code.dup_x1);
				Code.put(Code.pop);
			}
		}
		
	}*/
	
	public void visit(ReturnStmt rs) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	
	
	private boolean belongsToClass(Obj obj) {
		ArrayList<Obj> loc_sym=new ArrayList<>(obj.getLocalSymbols());
		if(!loc_sym.isEmpty() && loc_sym.get(0).getName().equals("this") && loc_sym.get(0).getType().getKind()==Struct.Class) return true;
		return false;
	}
	
	private void classMeth(Designator des) {
		des.traverseBottomUp(this);
		Code.put(Code.getfield);
		Code.put2(0);
		Code.put(Code.invokevirtual);
		for(int i= 0 ; i < des.obj.getName().length();i++ ) {
			Code.put4(des.obj.getName().charAt(i));
		}
		Code.put4(-1);
		
	}
	
	
	
	public void visit(NPDesignator npd) {
		if(belongsToClass(npd.getDesignator().obj)) {
			classMeth(npd.getDesignator());
		}
		else {
			Code.put(Code.call);
			Code.put2(npd.getDesignator().obj.getAdr()-Code.pc+1);
		}
	}
	
	public void visit(PDesignator pd) {
		if(belongsToClass(pd.getDesignator().obj)) {
			classMeth(pd.getDesignator());
		}
		else {
			Code.put(Code.call);
			Code.put2(pd.getDesignator().obj.getAdr()-Code.pc+1);
		}
	}
	
	
	
	
	public void visit(RelationExpr rel_expr) {
		int op=-1;
		RelOp relation_op=rel_expr.getRelOp();
		
		if(relation_op.getClass()==DEqual.class) op=Code.eq;
		else if(relation_op.getClass()==NEqual.class) op=Code.ne;
		else if(relation_op.getClass()==Gt.class) op=Code.gt;
		else if(relation_op.getClass()==Gt_e.class) op=Code.ge;
		else if(relation_op.getClass()==Le.class) op=Code.lt;
		else if(relation_op.getClass()==Le_e.class) op=Code.le;
		
		int current=Code.pc+1;
		Code.putFalseJump(Code.inverse[op], 0);
		Code.loadConst(0);
		int second=Code.pc+1;
		Code.putJump(0);
		Code.fixup(current);
		Code.loadConst(1);
		Code.fixup(second);
		
		
		
	}
	
	private Map<ConditionLeftOr,Integer> or_map=new HashMap<>();
	
	
	public void visit(ConditionLeftOr clo) {
		Code.loadConst(0);
		Code.put(Code.add);
		Code.loadConst(0);
		Code.put(Code.jcc+Code.gt);
		or_map.put(clo,Code.pc);
		Code.put2(0);
	}
	
	
	
	
	public void visit(ConditionalTerms cts) {
		 Code.loadConst(0);
		 int currPc = Code.pc+1;
		 Code.putFalseJump(Code.inverse[Code.le], 0);  
		 Code.loadConst(1);
		 int secPc= Code.pc +1;
		 Code.putJump(0);
		 Code.fixup(currPc); 
		 Code.loadConst(0);
		 Code.fixup(secPc); 
		 Code.fixup(or_map.get(cts.getConditionLeftOr()));
	
	}
	
	
    private Map<CondTermLeftAnd,Integer> and_map=new HashMap<>();
    
	
	public void visit(CondTermLeftAnd clfa) {
		Code.loadConst(0);
		Code.put(Code.jcc+Code.eq);
		and_map.put(clfa, Code.pc);
		Code.put2(0);
	}
	
	
	
	
	public void visit(ConditionalFactors cfs) {
		 Code.loadConst(0);
		 int currPc = Code.pc+1;
		 Code.putFalseJump(Code.inverse[Code.le], 0);  
		 Code.loadConst(1);
		 int secPc= Code.pc +1;
		 Code.putJump(0);
		 Code.fixup(currPc);
		 Code.fixup(and_map.get(cfs.getCondTermLeftAnd()));
		 Code.loadConst(0);
		 Code.fixup(secPc); 
		 
	
	}
	
	
	
	public void visit(ElseStmt elseStmt) {
		Code.put(Code.jmp);
		if(elseStmt.obj==null) elseStmt.obj=new Obj(Obj.NO_VALUE, "else", Tab.noType);
		elseStmt.obj.setAdr(Code.pc);
		Code.put2(0);
	    IfElseStmt ifElseSt = (IfElseStmt)(elseStmt.getParent());
	    IfCondition ifCond = (IfCondition)(ifElseSt.getIfCondition());
	    Code.fixup(ifCond.obj.getAdr());
	}
	
	
	
	public void visit(SuccCond sc) {
		sc.obj= new Obj(Obj.Con,"", Tab.intType);
		Code.loadConst(1);
		sc.obj.setAdr(Code.pc+1);
		Code.putFalseJump(Code.inverse[Code.ne], 0); 
	}
	
	
	public void visit(IfStmt ifStatement) {
		Code.fixup(ifStatement.getIfCondition().obj.getAdr());
	}
	
	
	public void visit(IfElseStmt ifElseStatement) {
	  Code.fixup(ifElseStatement.getElseStmt().obj.getAdr());
	}
	
	private Map<DoS,Integer> do_while_map=new HashMap<>();
	private ArrayList<ArrayList<Integer>> do_while_continue_stacks=new ArrayList<>();
	private ArrayList<ArrayList<Integer>> dw_switch_break_stacks=new ArrayList<>();
	private ArrayList<ArrayList<Integer>> case_clauses=new ArrayList<>();
	private ArrayList<ArrayList<Integer>> case_over_clauses=new ArrayList<>();
	
	public void visit(DoS dos) {
		dw_switch_break_stacks.add(new ArrayList<Integer>());
		do_while_map.put(dos, Code.pc);
		do_while_continue_stacks.add(new ArrayList<Integer>());
	}
	
	public void visit(ContinueStmt con_stmt) {
		do_while_continue_stacks.get(do_while_continue_stacks.size()-1).add(Code.pc+1);
		Code.putJump(0);
	}
	
	public void visit(WhileStmt wh_stmt) {
		ArrayList<Integer> list=do_while_continue_stacks.get(do_while_continue_stacks.size()-1);
		for(int i=0;i<list.size();i++) {
			Code.fixup(list.get(i));
		}
		do_while_continue_stacks.remove(do_while_continue_stacks.size()-1);
	}
	
	public void visit(DoStmt do_stmt) {
		Code.loadConst(1);
		Code.put(Code.jcc+Code.eq);
		Code.put2(do_while_map.get(do_stmt.getDoS())-Code.pc+1);
		ArrayList<Integer> b_list=dw_switch_break_stacks.remove(dw_switch_break_stacks.size()-1);
		for(int i=0;i<b_list.size();i++) {
			Code.fixup(b_list.get(i));
		}
	}
	
	public void visit(BreakStmt b_stmt) {
		dw_switch_break_stacks.get(dw_switch_break_stacks.size()-1).add(Code.pc+1);
	    Code.putJump(0);
	}
	
	public void visit(SwitchS sws) {
		dw_switch_break_stacks.add(new ArrayList<Integer>());
		case_clauses.add(new ArrayList<Integer>());
		case_over_clauses.add(new ArrayList<Integer>());
	}
	
	public void visit(CaseStart cs) {
		if(case_clauses.get(case_clauses.size()-1).size()>0) Code.fixup(case_clauses.get(case_clauses.size()-1).remove(0));
		Code.put(Code.dup);
		Code.loadConst(cs.getNumConst().getT());
		
		Code.put(Code.jcc+Code.ne);
		case_clauses.get(case_clauses.size()-1).add(Code.pc);
		Code.put2(0);
		if(case_over_clauses.get(case_over_clauses.size()-1).size()>0) Code.fixup(case_over_clauses.get(case_over_clauses.size()-1).remove(0));
		
		
	}
	
	public void visit(Case c) {
		case_over_clauses.get(case_over_clauses.size()-1).add(Code.pc+1);
		Code.putJump(0);
	}
	
	public void visit(SwitchStmt sw_stmt) {
		
		if(case_clauses.get(case_clauses.size()-1).size()>0) Code.fixup(case_clauses.get(case_clauses.size()-1).remove(0));
		case_clauses.remove(case_clauses.size()-1);
		if(case_over_clauses.get(case_over_clauses.size()-1).size()>0) Code.fixup(case_over_clauses.get(case_over_clauses.size()-1).remove(0));
		case_over_clauses.remove(case_over_clauses.size()-1);
		ArrayList<Integer> b_list=dw_switch_break_stacks.remove(dw_switch_break_stacks.size()-1);
		for(int i=0;i<b_list.size();i++) {
			Code.fixup(b_list.get(i));
		}
		Code.put(Code.pop);
	}
	
	
	
	
	
	
	
	
	

}
