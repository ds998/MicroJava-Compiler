// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclarations extends MethodDecl1 {

    private MethodDecl1 MethodDecl1;
    private MethodDecl MethodDecl;

    public MethodDeclarations (MethodDecl1 MethodDecl1, MethodDecl MethodDecl) {
        this.MethodDecl1=MethodDecl1;
        if(MethodDecl1!=null) MethodDecl1.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
    }

    public MethodDecl1 getMethodDecl1() {
        return MethodDecl1;
    }

    public void setMethodDecl1(MethodDecl1 MethodDecl1) {
        this.MethodDecl1=MethodDecl1;
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDecl1!=null) MethodDecl1.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDecl1!=null) MethodDecl1.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDecl1!=null) MethodDecl1.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclarations(\n");

        if(MethodDecl1!=null)
            buffer.append(MethodDecl1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclarations]");
        return buffer.toString();
    }
}
