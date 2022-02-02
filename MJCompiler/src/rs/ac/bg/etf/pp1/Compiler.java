package rs.ac.bg.etf.pp1;

import java.util.List;

import rs.ac.bg.etf.pp1.test.CompilerError;

public class Compiler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "test/ispravan_A.mj";
		String output = "test/program.obj";
		
		if(args.length==2) {
			input=args[0];
			output=args[1];
		}
		
		rs.ac.bg.etf.pp1.test.Compiler compiler=new CompilerImpl();
		List<CompilerError> error_list=compiler.compile(input,output);
		
		if(error_list!=null) {
			for(int i=0;i<error_list.size();i++) {
				System.out.println(error_list.get(i));
			}
		}

	}

}
