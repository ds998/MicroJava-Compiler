// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class SwitchStmt extends Statement {

    private SwitchS SwitchS;
    private CaseList CaseList;

    public SwitchStmt (SwitchS SwitchS, CaseList CaseList) {
        this.SwitchS=SwitchS;
        if(SwitchS!=null) SwitchS.setParent(this);
        this.CaseList=CaseList;
        if(CaseList!=null) CaseList.setParent(this);
    }

    public SwitchS getSwitchS() {
        return SwitchS;
    }

    public void setSwitchS(SwitchS SwitchS) {
        this.SwitchS=SwitchS;
    }

    public CaseList getCaseList() {
        return CaseList;
    }

    public void setCaseList(CaseList CaseList) {
        this.CaseList=CaseList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SwitchS!=null) SwitchS.accept(visitor);
        if(CaseList!=null) CaseList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SwitchS!=null) SwitchS.traverseTopDown(visitor);
        if(CaseList!=null) CaseList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SwitchS!=null) SwitchS.traverseBottomUp(visitor);
        if(CaseList!=null) CaseList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SwitchStmt(\n");

        if(SwitchS!=null)
            buffer.append(SwitchS.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CaseList!=null)
            buffer.append(CaseList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SwitchStmt]");
        return buffer.toString();
    }
}
