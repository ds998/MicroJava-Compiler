// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class VarDeclVar2 implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private String varName;
    private VarDeclVarIndOpt VarDeclVarIndOpt;

    public VarDeclVar2 (String varName, VarDeclVarIndOpt VarDeclVarIndOpt) {
        this.varName=varName;
        this.VarDeclVarIndOpt=VarDeclVarIndOpt;
        if(VarDeclVarIndOpt!=null) VarDeclVarIndOpt.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public VarDeclVarIndOpt getVarDeclVarIndOpt() {
        return VarDeclVarIndOpt;
    }

    public void setVarDeclVarIndOpt(VarDeclVarIndOpt VarDeclVarIndOpt) {
        this.VarDeclVarIndOpt=VarDeclVarIndOpt;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclVarIndOpt!=null) VarDeclVarIndOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclVarIndOpt!=null) VarDeclVarIndOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclVarIndOpt!=null) VarDeclVarIndOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclVar2(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(VarDeclVarIndOpt!=null)
            buffer.append(VarDeclVarIndOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclVar2]");
        return buffer.toString();
    }
}
