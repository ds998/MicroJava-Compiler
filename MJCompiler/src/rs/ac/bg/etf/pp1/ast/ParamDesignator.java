// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:45


package rs.ac.bg.etf.pp1.ast;

public class ParamDesignator extends Factor {

    private PDesignator PDesignator;

    public ParamDesignator (PDesignator PDesignator) {
        this.PDesignator=PDesignator;
        if(PDesignator!=null) PDesignator.setParent(this);
    }

    public PDesignator getPDesignator() {
        return PDesignator;
    }

    public void setPDesignator(PDesignator PDesignator) {
        this.PDesignator=PDesignator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PDesignator!=null) PDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PDesignator!=null) PDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PDesignator!=null) PDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ParamDesignator(\n");

        if(PDesignator!=null)
            buffer.append(PDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ParamDesignator]");
        return buffer.toString();
    }
}
