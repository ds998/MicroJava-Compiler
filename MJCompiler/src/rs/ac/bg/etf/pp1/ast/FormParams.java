// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class FormParams extends FormPars {

    private ContFormPars ContFormPars;

    public FormParams (ContFormPars ContFormPars) {
        this.ContFormPars=ContFormPars;
        if(ContFormPars!=null) ContFormPars.setParent(this);
    }

    public ContFormPars getContFormPars() {
        return ContFormPars;
    }

    public void setContFormPars(ContFormPars ContFormPars) {
        this.ContFormPars=ContFormPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ContFormPars!=null) ContFormPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ContFormPars!=null) ContFormPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ContFormPars!=null) ContFormPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParams(\n");

        if(ContFormPars!=null)
            buffer.append(ContFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParams]");
        return buffer.toString();
    }
}
