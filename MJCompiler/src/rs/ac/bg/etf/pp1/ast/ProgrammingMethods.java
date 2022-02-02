// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class ProgrammingMethods extends ProgMethods {

    private ProgMethods ProgMethods;
    private MethodDecl MethodDecl;

    public ProgrammingMethods (ProgMethods ProgMethods, MethodDecl MethodDecl) {
        this.ProgMethods=ProgMethods;
        if(ProgMethods!=null) ProgMethods.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
    }

    public ProgMethods getProgMethods() {
        return ProgMethods;
    }

    public void setProgMethods(ProgMethods ProgMethods) {
        this.ProgMethods=ProgMethods;
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
        if(ProgMethods!=null) ProgMethods.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgMethods!=null) ProgMethods.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgMethods!=null) ProgMethods.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgrammingMethods(\n");

        if(ProgMethods!=null)
            buffer.append(ProgMethods.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgrammingMethods]");
        return buffer.toString();
    }
}
