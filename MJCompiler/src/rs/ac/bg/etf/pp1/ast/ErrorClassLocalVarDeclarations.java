// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class ErrorClassLocalVarDeclarations extends ClassLocalVarDecl {

    public ErrorClassLocalVarDeclarations () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ErrorClassLocalVarDeclarations(\n");

        buffer.append(tab);
        buffer.append(") [ErrorClassLocalVarDeclarations]");
        return buffer.toString();
    }
}