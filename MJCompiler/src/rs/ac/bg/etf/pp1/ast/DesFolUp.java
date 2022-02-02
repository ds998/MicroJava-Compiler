// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:45


package rs.ac.bg.etf.pp1.ast;

public class DesFolUp extends DesignatorFollowUp {

    private DesignatorF DesignatorF;
    private DesignatorFollowUp DesignatorFollowUp;

    public DesFolUp (DesignatorF DesignatorF, DesignatorFollowUp DesignatorFollowUp) {
        this.DesignatorF=DesignatorF;
        if(DesignatorF!=null) DesignatorF.setParent(this);
        this.DesignatorFollowUp=DesignatorFollowUp;
        if(DesignatorFollowUp!=null) DesignatorFollowUp.setParent(this);
    }

    public DesignatorF getDesignatorF() {
        return DesignatorF;
    }

    public void setDesignatorF(DesignatorF DesignatorF) {
        this.DesignatorF=DesignatorF;
    }

    public DesignatorFollowUp getDesignatorFollowUp() {
        return DesignatorFollowUp;
    }

    public void setDesignatorFollowUp(DesignatorFollowUp DesignatorFollowUp) {
        this.DesignatorFollowUp=DesignatorFollowUp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorF!=null) DesignatorF.accept(visitor);
        if(DesignatorFollowUp!=null) DesignatorFollowUp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorF!=null) DesignatorF.traverseTopDown(visitor);
        if(DesignatorFollowUp!=null) DesignatorFollowUp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorF!=null) DesignatorF.traverseBottomUp(visitor);
        if(DesignatorFollowUp!=null) DesignatorFollowUp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesFolUp(\n");

        if(DesignatorF!=null)
            buffer.append(DesignatorF.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorFollowUp!=null)
            buffer.append(DesignatorFollowUp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesFolUp]");
        return buffer.toString();
    }
}
