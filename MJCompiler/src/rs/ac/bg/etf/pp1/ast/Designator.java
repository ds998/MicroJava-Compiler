// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:45


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private StartDesignator StartDesignator;
    private DesignatorFollowUp DesignatorFollowUp;

    public Designator (StartDesignator StartDesignator, DesignatorFollowUp DesignatorFollowUp) {
        this.StartDesignator=StartDesignator;
        if(StartDesignator!=null) StartDesignator.setParent(this);
        this.DesignatorFollowUp=DesignatorFollowUp;
        if(DesignatorFollowUp!=null) DesignatorFollowUp.setParent(this);
    }

    public StartDesignator getStartDesignator() {
        return StartDesignator;
    }

    public void setStartDesignator(StartDesignator StartDesignator) {
        this.StartDesignator=StartDesignator;
    }

    public DesignatorFollowUp getDesignatorFollowUp() {
        return DesignatorFollowUp;
    }

    public void setDesignatorFollowUp(DesignatorFollowUp DesignatorFollowUp) {
        this.DesignatorFollowUp=DesignatorFollowUp;
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
        if(StartDesignator!=null) StartDesignator.accept(visitor);
        if(DesignatorFollowUp!=null) DesignatorFollowUp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StartDesignator!=null) StartDesignator.traverseTopDown(visitor);
        if(DesignatorFollowUp!=null) DesignatorFollowUp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StartDesignator!=null) StartDesignator.traverseBottomUp(visitor);
        if(DesignatorFollowUp!=null) DesignatorFollowUp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        if(StartDesignator!=null)
            buffer.append(StartDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorFollowUp!=null)
            buffer.append(DesignatorFollowUp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}
