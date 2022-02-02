package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.FormPar;
import rs.ac.bg.etf.pp1.ast.VarDeclVar;
import rs.ac.bg.etf.pp1.ast.VarDeclVar2;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {

	protected int count;
	
	public int getCount(){
		return count;
	}
	
	public static class FormParamCounter extends CounterVisitor{
	
		public void visit(FormPar formParamDecl){
			count++;
		}
	}
	
	public static class VarCounter extends CounterVisitor{
		
		public void visit(VarDeclVar varDecl){
			count++;
		}
		
		public void visit(VarDeclVar2 varDecl2) {
			count++;
		}
	}
}
