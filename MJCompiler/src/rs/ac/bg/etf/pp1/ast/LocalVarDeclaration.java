// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class LocalVarDeclaration extends LocalVarDeclList {

    private VarDeclVar VarDeclVar;

    public LocalVarDeclaration (VarDeclVar VarDeclVar) {
        this.VarDeclVar=VarDeclVar;
        if(VarDeclVar!=null) VarDeclVar.setParent(this);
    }

    public VarDeclVar getVarDeclVar() {
        return VarDeclVar;
    }

    public void setVarDeclVar(VarDeclVar VarDeclVar) {
        this.VarDeclVar=VarDeclVar;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclVar!=null) VarDeclVar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclVar!=null) VarDeclVar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclVar!=null) VarDeclVar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LocalVarDeclaration(\n");

        if(VarDeclVar!=null)
            buffer.append(VarDeclVar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LocalVarDeclaration]");
        return buffer.toString();
    }
}
