// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:45


package rs.ac.bg.etf.pp1.ast;

public class MinusExpr extends Expr1 {

    private PlusTerms PlusTerms;

    public MinusExpr (PlusTerms PlusTerms) {
        this.PlusTerms=PlusTerms;
        if(PlusTerms!=null) PlusTerms.setParent(this);
    }

    public PlusTerms getPlusTerms() {
        return PlusTerms;
    }

    public void setPlusTerms(PlusTerms PlusTerms) {
        this.PlusTerms=PlusTerms;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PlusTerms!=null) PlusTerms.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PlusTerms!=null) PlusTerms.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PlusTerms!=null) PlusTerms.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MinusExpr(\n");

        if(PlusTerms!=null)
            buffer.append(PlusTerms.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MinusExpr]");
        return buffer.toString();
    }
}
