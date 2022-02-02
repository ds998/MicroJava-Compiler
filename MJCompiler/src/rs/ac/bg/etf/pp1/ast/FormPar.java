// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class FormPar implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private String parName;
    private FormParOpt FormParOpt;

    public FormPar (Type Type, String parName, FormParOpt FormParOpt) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.parName=parName;
        this.FormParOpt=FormParOpt;
        if(FormParOpt!=null) FormParOpt.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getParName() {
        return parName;
    }

    public void setParName(String parName) {
        this.parName=parName;
    }

    public FormParOpt getFormParOpt() {
        return FormParOpt;
    }

    public void setFormParOpt(FormParOpt FormParOpt) {
        this.FormParOpt=FormParOpt;
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
        if(Type!=null) Type.accept(visitor);
        if(FormParOpt!=null) FormParOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FormParOpt!=null) FormParOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FormParOpt!=null) FormParOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormPar(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+parName);
        buffer.append("\n");

        if(FormParOpt!=null)
            buffer.append(FormParOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormPar]");
        return buffer.toString();
    }
}
