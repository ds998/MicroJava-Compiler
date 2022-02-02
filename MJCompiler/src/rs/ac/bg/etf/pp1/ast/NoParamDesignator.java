// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:45


package rs.ac.bg.etf.pp1.ast;

public class NoParamDesignator extends Factor {

    private NPDesignator NPDesignator;

    public NoParamDesignator (NPDesignator NPDesignator) {
        this.NPDesignator=NPDesignator;
        if(NPDesignator!=null) NPDesignator.setParent(this);
    }

    public NPDesignator getNPDesignator() {
        return NPDesignator;
    }

    public void setNPDesignator(NPDesignator NPDesignator) {
        this.NPDesignator=NPDesignator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NPDesignator!=null) NPDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NPDesignator!=null) NPDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NPDesignator!=null) NPDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoParamDesignator(\n");

        if(NPDesignator!=null)
            buffer.append(NPDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NoParamDesignator]");
        return buffer.toString();
    }
}
