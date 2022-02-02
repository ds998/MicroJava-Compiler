// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ProgName ProgName;
    private Declarations Declarations;
    private ProgMethods ProgMethods;

    public Program (ProgName ProgName, Declarations Declarations, ProgMethods ProgMethods) {
        this.ProgName=ProgName;
        if(ProgName!=null) ProgName.setParent(this);
        this.Declarations=Declarations;
        if(Declarations!=null) Declarations.setParent(this);
        this.ProgMethods=ProgMethods;
        if(ProgMethods!=null) ProgMethods.setParent(this);
    }

    public ProgName getProgName() {
        return ProgName;
    }

    public void setProgName(ProgName ProgName) {
        this.ProgName=ProgName;
    }

    public Declarations getDeclarations() {
        return Declarations;
    }

    public void setDeclarations(Declarations Declarations) {
        this.Declarations=Declarations;
    }

    public ProgMethods getProgMethods() {
        return ProgMethods;
    }

    public void setProgMethods(ProgMethods ProgMethods) {
        this.ProgMethods=ProgMethods;
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
        if(ProgName!=null) ProgName.accept(visitor);
        if(Declarations!=null) Declarations.accept(visitor);
        if(ProgMethods!=null) ProgMethods.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgName!=null) ProgName.traverseTopDown(visitor);
        if(Declarations!=null) Declarations.traverseTopDown(visitor);
        if(ProgMethods!=null) ProgMethods.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgName!=null) ProgName.traverseBottomUp(visitor);
        if(Declarations!=null) Declarations.traverseBottomUp(visitor);
        if(ProgMethods!=null) ProgMethods.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgName!=null)
            buffer.append(ProgName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Declarations!=null)
            buffer.append(Declarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ProgMethods!=null)
            buffer.append(ProgMethods.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
