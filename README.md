# MicroJava-Compiler
A MicroJava project for a school subject. It works through four phases: the lexer (mjlexer.lex) recognizes code syntax; the parser(mjparser.cup) builds a Obj tree
as it parses through the code. The semantic analyzer (SemanticAnalyzer.java) visits the tree in postorder to check for errors. Finally, the code generator
(CodeGenerator.java) generates MicroJava code as it visits the tree in postorder. This is all compiled through the Compiler.java file.
