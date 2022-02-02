// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class NoStmts extends StatementList {

    public NoStmts () {
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
        buffer.append("NoStmts(\n");

        buffer.append(tab);
        buffer.append(") [NoStmts]");
        return buffer.toString();
    }
}
