// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class ClassName implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private String I1;
    private ClassExtOpt ClassExtOpt;

    public ClassName (String I1, ClassExtOpt ClassExtOpt) {
        this.I1=I1;
        this.ClassExtOpt=ClassExtOpt;
        if(ClassExtOpt!=null) ClassExtOpt.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ClassExtOpt getClassExtOpt() {
        return ClassExtOpt;
    }

    public void setClassExtOpt(ClassExtOpt ClassExtOpt) {
        this.ClassExtOpt=ClassExtOpt;
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
        if(ClassExtOpt!=null) ClassExtOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassExtOpt!=null) ClassExtOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassExtOpt!=null) ClassExtOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassName(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ClassExtOpt!=null)
            buffer.append(ClassExtOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassName]");
        return buffer.toString();
    }
}
