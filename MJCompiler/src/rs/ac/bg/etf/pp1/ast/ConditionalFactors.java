// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:45


package rs.ac.bg.etf.pp1.ast;

public class ConditionalFactors extends CondTerm {

    private CondTermLeftAnd CondTermLeftAnd;
    private CondFact CondFact;

    public ConditionalFactors (CondTermLeftAnd CondTermLeftAnd, CondFact CondFact) {
        this.CondTermLeftAnd=CondTermLeftAnd;
        if(CondTermLeftAnd!=null) CondTermLeftAnd.setParent(this);
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
    }

    public CondTermLeftAnd getCondTermLeftAnd() {
        return CondTermLeftAnd;
    }

    public void setCondTermLeftAnd(CondTermLeftAnd CondTermLeftAnd) {
        this.CondTermLeftAnd=CondTermLeftAnd;
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTermLeftAnd!=null) CondTermLeftAnd.accept(visitor);
        if(CondFact!=null) CondFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTermLeftAnd!=null) CondTermLeftAnd.traverseTopDown(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTermLeftAnd!=null) CondTermLeftAnd.traverseBottomUp(visitor);
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionalFactors(\n");

        if(CondTermLeftAnd!=null)
            buffer.append(CondTermLeftAnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionalFactors]");
        return buffer.toString();
    }
}
