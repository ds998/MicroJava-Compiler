// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class DoStmt extends Statement {

    private DoS DoS;
    private Statement Statement;
    private WhileStmt WhileStmt;
    private Condition Condition;

    public DoStmt (DoS DoS, Statement Statement, WhileStmt WhileStmt, Condition Condition) {
        this.DoS=DoS;
        if(DoS!=null) DoS.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.WhileStmt=WhileStmt;
        if(WhileStmt!=null) WhileStmt.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
    }

    public DoS getDoS() {
        return DoS;
    }

    public void setDoS(DoS DoS) {
        this.DoS=DoS;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public WhileStmt getWhileStmt() {
        return WhileStmt;
    }

    public void setWhileStmt(WhileStmt WhileStmt) {
        this.WhileStmt=WhileStmt;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DoS!=null) DoS.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(WhileStmt!=null) WhileStmt.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DoS!=null) DoS.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(WhileStmt!=null) WhileStmt.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DoS!=null) DoS.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(WhileStmt!=null) WhileStmt.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DoStmt(\n");

        if(DoS!=null)
            buffer.append(DoS.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(WhileStmt!=null)
            buffer.append(WhileStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DoStmt]");
        return buffer.toString();
    }
}
