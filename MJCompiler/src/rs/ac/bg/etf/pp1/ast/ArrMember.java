// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:45


package rs.ac.bg.etf.pp1.ast;

public class ArrMember extends DesignatorF {

    private DesFArr DesFArr;

    public ArrMember (DesFArr DesFArr) {
        this.DesFArr=DesFArr;
        if(DesFArr!=null) DesFArr.setParent(this);
    }

    public DesFArr getDesFArr() {
        return DesFArr;
    }

    public void setDesFArr(DesFArr DesFArr) {
        this.DesFArr=DesFArr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesFArr!=null) DesFArr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesFArr!=null) DesFArr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesFArr!=null) DesFArr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrMember(\n");

        if(DesFArr!=null)
            buffer.append(DesFArr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrMember]");
        return buffer.toString();
    }
}
