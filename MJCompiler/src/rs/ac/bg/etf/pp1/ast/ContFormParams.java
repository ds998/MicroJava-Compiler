// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class ContFormParams extends ContFormPars {

    private ContFormPars ContFormPars;
    private FormPar FormPar;

    public ContFormParams (ContFormPars ContFormPars, FormPar FormPar) {
        this.ContFormPars=ContFormPars;
        if(ContFormPars!=null) ContFormPars.setParent(this);
        this.FormPar=FormPar;
        if(FormPar!=null) FormPar.setParent(this);
    }

    public ContFormPars getContFormPars() {
        return ContFormPars;
    }

    public void setContFormPars(ContFormPars ContFormPars) {
        this.ContFormPars=ContFormPars;
    }

    public FormPar getFormPar() {
        return FormPar;
    }

    public void setFormPar(FormPar FormPar) {
        this.FormPar=FormPar;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ContFormPars!=null) ContFormPars.accept(visitor);
        if(FormPar!=null) FormPar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ContFormPars!=null) ContFormPars.traverseTopDown(visitor);
        if(FormPar!=null) FormPar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ContFormPars!=null) ContFormPars.traverseBottomUp(visitor);
        if(FormPar!=null) FormPar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ContFormParams(\n");

        if(ContFormPars!=null)
            buffer.append(ContFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormPar!=null)
            buffer.append(FormPar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ContFormParams]");
        return buffer.toString();
    }
}
