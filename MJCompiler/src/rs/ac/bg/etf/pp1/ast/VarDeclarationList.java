// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationList extends VarDeclList {

    private VarDeclList VarDeclList;
    private VarDeclVar2 VarDeclVar2;

    public VarDeclarationList (VarDeclList VarDeclList, VarDeclVar2 VarDeclVar2) {
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.VarDeclVar2=VarDeclVar2;
        if(VarDeclVar2!=null) VarDeclVar2.setParent(this);
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public VarDeclVar2 getVarDeclVar2() {
        return VarDeclVar2;
    }

    public void setVarDeclVar2(VarDeclVar2 VarDeclVar2) {
        this.VarDeclVar2=VarDeclVar2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(VarDeclVar2!=null) VarDeclVar2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(VarDeclVar2!=null) VarDeclVar2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(VarDeclVar2!=null) VarDeclVar2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationList(\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclVar2!=null)
            buffer.append(VarDeclVar2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationList]");
        return buffer.toString();
    }
}
