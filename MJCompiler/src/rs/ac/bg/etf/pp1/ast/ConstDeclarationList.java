// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclarationList extends ConstDeclList {

    private ConstDeclList ConstDeclList;
    private ConstDeclVar2 ConstDeclVar2;

    public ConstDeclarationList (ConstDeclList ConstDeclList, ConstDeclVar2 ConstDeclVar2) {
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
        this.ConstDeclVar2=ConstDeclVar2;
        if(ConstDeclVar2!=null) ConstDeclVar2.setParent(this);
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public ConstDeclVar2 getConstDeclVar2() {
        return ConstDeclVar2;
    }

    public void setConstDeclVar2(ConstDeclVar2 ConstDeclVar2) {
        this.ConstDeclVar2=ConstDeclVar2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
        if(ConstDeclVar2!=null) ConstDeclVar2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
        if(ConstDeclVar2!=null) ConstDeclVar2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        if(ConstDeclVar2!=null) ConstDeclVar2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclarationList(\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclVar2!=null)
            buffer.append(ConstDeclVar2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclarationList]");
        return buffer.toString();
    }
}
