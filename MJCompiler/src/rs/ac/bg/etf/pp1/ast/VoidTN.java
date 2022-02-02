// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class VoidTN extends MethodTN {

    private String methName;

    public VoidTN (String methName) {
        this.methName=methName;
    }

    public String getMethName() {
        return methName;
    }

    public void setMethName(String methName) {
        this.methName=methName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VoidTN(\n");

        buffer.append(" "+tab+methName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VoidTN]");
        return buffer.toString();
    }
}
