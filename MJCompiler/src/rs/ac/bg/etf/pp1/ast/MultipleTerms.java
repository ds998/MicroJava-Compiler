// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:45


package rs.ac.bg.etf.pp1.ast;

public class MultipleTerms extends PlusTerms {

    private PlusTerms PlusTerms;
    private AddOp AddOp;
    private Term Term;

    public MultipleTerms (PlusTerms PlusTerms, AddOp AddOp, Term Term) {
        this.PlusTerms=PlusTerms;
        if(PlusTerms!=null) PlusTerms.setParent(this);
        this.AddOp=AddOp;
        if(AddOp!=null) AddOp.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public PlusTerms getPlusTerms() {
        return PlusTerms;
    }

    public void setPlusTerms(PlusTerms PlusTerms) {
        this.PlusTerms=PlusTerms;
    }

    public AddOp getAddOp() {
        return AddOp;
    }

    public void setAddOp(AddOp AddOp) {
        this.AddOp=AddOp;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PlusTerms!=null) PlusTerms.accept(visitor);
        if(AddOp!=null) AddOp.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PlusTerms!=null) PlusTerms.traverseTopDown(visitor);
        if(AddOp!=null) AddOp.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PlusTerms!=null) PlusTerms.traverseBottomUp(visitor);
        if(AddOp!=null) AddOp.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleTerms(\n");

        if(PlusTerms!=null)
            buffer.append(PlusTerms.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddOp!=null)
            buffer.append(AddOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleTerms]");
        return buffer.toString();
    }
}
