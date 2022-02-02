// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:45


package rs.ac.bg.etf.pp1.ast;

public class ConditionalTerms extends Condition {

    private ConditionLeftOr ConditionLeftOr;
    private CondTerm CondTerm;

    public ConditionalTerms (ConditionLeftOr ConditionLeftOr, CondTerm CondTerm) {
        this.ConditionLeftOr=ConditionLeftOr;
        if(ConditionLeftOr!=null) ConditionLeftOr.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public ConditionLeftOr getConditionLeftOr() {
        return ConditionLeftOr;
    }

    public void setConditionLeftOr(ConditionLeftOr ConditionLeftOr) {
        this.ConditionLeftOr=ConditionLeftOr;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionLeftOr!=null) ConditionLeftOr.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionLeftOr!=null) ConditionLeftOr.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionLeftOr!=null) ConditionLeftOr.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionalTerms(\n");

        if(ConditionLeftOr!=null)
            buffer.append(ConditionLeftOr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionalTerms]");
        return buffer.toString();
    }
}
