// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class ReturnStmt extends Statement {

    private RetExprOpt RetExprOpt;

    public ReturnStmt (RetExprOpt RetExprOpt) {
        this.RetExprOpt=RetExprOpt;
        if(RetExprOpt!=null) RetExprOpt.setParent(this);
    }

    public RetExprOpt getRetExprOpt() {
        return RetExprOpt;
    }

    public void setRetExprOpt(RetExprOpt RetExprOpt) {
        this.RetExprOpt=RetExprOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RetExprOpt!=null) RetExprOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RetExprOpt!=null) RetExprOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RetExprOpt!=null) RetExprOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnStmt(\n");

        if(RetExprOpt!=null)
            buffer.append(RetExprOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnStmt]");
        return buffer.toString();
    }
}
