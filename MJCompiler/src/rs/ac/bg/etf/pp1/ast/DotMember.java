// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:45


package rs.ac.bg.etf.pp1.ast;

public class DotMember extends DesignatorF {

    private DesFDot DesFDot;

    public DotMember (DesFDot DesFDot) {
        this.DesFDot=DesFDot;
        if(DesFDot!=null) DesFDot.setParent(this);
    }

    public DesFDot getDesFDot() {
        return DesFDot;
    }

    public void setDesFDot(DesFDot DesFDot) {
        this.DesFDot=DesFDot;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesFDot!=null) DesFDot.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesFDot!=null) DesFDot.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesFDot!=null) DesFDot.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DotMember(\n");

        if(DesFDot!=null)
            buffer.append(DesFDot.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DotMember]");
        return buffer.toString();
    }
}
