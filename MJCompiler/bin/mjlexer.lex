
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.test.CompilerError;
import rs.ac.bg.etf.pp1.test.CompilerError.CompilerErrorType;

%%

%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"program"   { return new_symbol(sym.PROG, yytext());}
"return"    { return new_symbol(sym.RETURN, yytext());}
"void"      { return new_symbol(sym.VOID, yytext()); }
"break"     {return new_symbol(sym.BREAK,yytext());}
"class" 	{ return new_symbol(sym.CLASS, yytext()); }
"enum" 	    { return new_symbol(sym.ENUM, yytext()); }
"else" 		{ return new_symbol(sym.ELSE, yytext()); }
"const" 	{ return new_symbol(sym.CONST, yytext()); }
"if" 		{ return new_symbol(sym.IF, yytext()); }
"switch" 	{ return new_symbol(sym.SWITCH, yytext()); }
"do" 		{ return new_symbol(sym.DO, yytext()); }
"while" 	{ return new_symbol(sym.WHILE, yytext()); }
"new" 		{ return new_symbol(sym.NEW, yytext()); }
"extends" 	{ return new_symbol(sym.EXTENDS, yytext()); }
"continue" 	{ return new_symbol(sym.CONTINUE, yytext()); }
"case"    	{ return new_symbol(sym.CASE, yytext()); }
"print"     { return new_symbol(sym.PRINT,yytext()); }
"read"      { return new_symbol(sym.READ, yytext()); }
"+" 		{ return new_symbol(sym.PLUS, yytext()); }
"-" 	    { return new_symbol(sym.MINUS, yytext()); }
"*" 	    { return new_symbol(sym.MUL, yytext()); }
"/" 		{ return new_symbol(sym.DIV, yytext()); }
"%" 		{ return new_symbol(sym.MOD, yytext()); }
"==" 		{ return new_symbol(sym.DOUBLE_EQUAL, yytext()); }
"!=" 		{ return new_symbol(sym.NOT_EQUAL, yytext()); }
">" 		{ return new_symbol(sym.GT, yytext()); }
">=" 		{ return new_symbol(sym.GT_EQUAL, yytext()); }
"<" 		{ return new_symbol(sym.LE, yytext()); }
"<=" 		{ return new_symbol(sym.LE_EQUAL, yytext()); }
"&&" 		{ return new_symbol(sym.AND, yytext()); }
"||" 		{ return new_symbol(sym.OR, yytext()); }
"=" 		{ return new_symbol(sym.EQUAL, yytext()); }
"++" 		{ return new_symbol(sym.PLUS_PLUS, yytext()); }
"--" 		{ return new_symbol(sym.MINUS_MINUS, yytext()); }
";" 		{ return new_symbol(sym.SEMI, yytext()); }
"," 		{ return new_symbol(sym.COMMA, yytext()); }
"."			{ return new_symbol(sym.DOT, yytext()); }
"(" 	    { return new_symbol(sym.LPAREN, yytext()); }
")" 	    { return new_symbol(sym.RPAREN, yytext()); }
"[" 		{ return new_symbol(sym.LRECT, yytext()); }
"]" 		{ return new_symbol(sym.RRECT, yytext()); }
"{" 		{ return new_symbol(sym.LBRACE, yytext()); }
"}" 		{ return new_symbol(sym.RBRACE, yytext()); }
"yield" 	{ return new_symbol(sym.YIELD, yytext()); }
"default"   { return new_symbol(sym.DEFAULT, yytext()); }
":" 		{ return new_symbol(sym.DOUBLE_COLON, yytext()); }


"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

[0-9]+  { return new_symbol(sym.NUMBER, new Integer (yytext())); }
"'"(.)"'"    { return new_symbol(sym.CHAR, new Character(yytext().charAt(1)));}
("true"|"false") { return new_symbol(sym.BOOL, new String(yytext()));}
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{return new_symbol (sym.IDENT, yytext()); }

. { CompilerImpl.add_error(new CompilerError((yyline+1),"Greska ("+yytext()+")",CompilerErrorType.LEXICAL_ERROR)); }










