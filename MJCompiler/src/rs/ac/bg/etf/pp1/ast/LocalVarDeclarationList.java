// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class LocalVarDeclarationList extends LocalVarDeclList {

    private LocalVarDeclList LocalVarDeclList;
    private VarDeclVar2 VarDeclVar2;

    public LocalVarDeclarationList (LocalVarDeclList LocalVarDeclList, VarDeclVar2 VarDeclVar2) {
        this.LocalVarDeclList=LocalVarDeclList;
        if(LocalVarDeclList!=null) LocalVarDeclList.setParent(this);
        this.VarDeclVar2=VarDeclVar2;
        if(VarDeclVar2!=null) VarDeclVar2.setParent(this);
    }

    public LocalVarDeclList getLocalVarDeclList() {
        return LocalVarDeclList;
    }

    public void setLocalVarDeclList(LocalVarDeclList LocalVarDeclList) {
        this.LocalVarDeclList=LocalVarDeclList;
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
        if(LocalVarDeclList!=null) LocalVarDeclList.accept(visitor);
        if(VarDeclVar2!=null) VarDeclVar2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LocalVarDeclList!=null) LocalVarDeclList.traverseTopDown(visitor);
        if(VarDeclVar2!=null) VarDeclVar2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LocalVarDeclList!=null) LocalVarDeclList.traverseBottomUp(visitor);
        if(VarDeclVar2!=null) VarDeclVar2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LocalVarDeclarationList(\n");

        if(LocalVarDeclList!=null)
            buffer.append(LocalVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclVar2!=null)
            buffer.append(VarDeclVar2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LocalVarDeclarationList]");
        return buffer.toString();
    }
}
