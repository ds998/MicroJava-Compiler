// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class PrintStmt extends Statement {

    private Expr Expr;
    private PossNumConst PossNumConst;

    public PrintStmt (Expr Expr, PossNumConst PossNumConst) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.PossNumConst=PossNumConst;
        if(PossNumConst!=null) PossNumConst.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public PossNumConst getPossNumConst() {
        return PossNumConst;
    }

    public void setPossNumConst(PossNumConst PossNumConst) {
        this.PossNumConst=PossNumConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(PossNumConst!=null) PossNumConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(PossNumConst!=null) PossNumConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(PossNumConst!=null) PossNumConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStmt(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PossNumConst!=null)
            buffer.append(PossNumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStmt]");
        return buffer.toString();
    }
}
