// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class RepeatingVars extends RepeatVars {

    private RepeatVars RepeatVars;
    private LocalVarDecl LocalVarDecl;

    public RepeatingVars (RepeatVars RepeatVars, LocalVarDecl LocalVarDecl) {
        this.RepeatVars=RepeatVars;
        if(RepeatVars!=null) RepeatVars.setParent(this);
        this.LocalVarDecl=LocalVarDecl;
        if(LocalVarDecl!=null) LocalVarDecl.setParent(this);
    }

    public RepeatVars getRepeatVars() {
        return RepeatVars;
    }

    public void setRepeatVars(RepeatVars RepeatVars) {
        this.RepeatVars=RepeatVars;
    }

    public LocalVarDecl getLocalVarDecl() {
        return LocalVarDecl;
    }

    public void setLocalVarDecl(LocalVarDecl LocalVarDecl) {
        this.LocalVarDecl=LocalVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RepeatVars!=null) RepeatVars.accept(visitor);
        if(LocalVarDecl!=null) LocalVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RepeatVars!=null) RepeatVars.traverseTopDown(visitor);
        if(LocalVarDecl!=null) LocalVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RepeatVars!=null) RepeatVars.traverseBottomUp(visitor);
        if(LocalVarDecl!=null) LocalVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RepeatingVars(\n");

        if(RepeatVars!=null)
            buffer.append(RepeatVars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LocalVarDecl!=null)
            buffer.append(LocalVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RepeatingVars]");
        return buffer.toString();
    }
}
