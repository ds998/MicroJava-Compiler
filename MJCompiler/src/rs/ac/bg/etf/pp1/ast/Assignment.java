// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:45


package rs.ac.bg.etf.pp1.ast;

public class Assignment extends DesignatorOp {

    private AssignmentOperation AssignmentOperation;

    public Assignment (AssignmentOperation AssignmentOperation) {
        this.AssignmentOperation=AssignmentOperation;
        if(AssignmentOperation!=null) AssignmentOperation.setParent(this);
    }

    public AssignmentOperation getAssignmentOperation() {
        return AssignmentOperation;
    }

    public void setAssignmentOperation(AssignmentOperation AssignmentOperation) {
        this.AssignmentOperation=AssignmentOperation;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AssignmentOperation!=null) AssignmentOperation.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignmentOperation!=null) AssignmentOperation.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignmentOperation!=null) AssignmentOperation.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Assignment(\n");

        if(AssignmentOperation!=null)
            buffer.append(AssignmentOperation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Assignment]");
        return buffer.toString();
    }
}
