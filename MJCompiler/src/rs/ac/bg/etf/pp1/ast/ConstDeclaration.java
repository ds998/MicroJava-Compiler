// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclaration extends ConstDeclList {

    private ConstDeclVar ConstDeclVar;

    public ConstDeclaration (ConstDeclVar ConstDeclVar) {
        this.ConstDeclVar=ConstDeclVar;
        if(ConstDeclVar!=null) ConstDeclVar.setParent(this);
    }

    public ConstDeclVar getConstDeclVar() {
        return ConstDeclVar;
    }

    public void setConstDeclVar(ConstDeclVar ConstDeclVar) {
        this.ConstDeclVar=ConstDeclVar;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclVar!=null) ConstDeclVar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclVar!=null) ConstDeclVar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclVar!=null) ConstDeclVar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclaration(\n");

        if(ConstDeclVar!=null)
            buffer.append(ConstDeclVar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclaration]");
        return buffer.toString();
    }
}
