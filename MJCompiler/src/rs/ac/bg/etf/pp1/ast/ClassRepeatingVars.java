// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class ClassRepeatingVars extends ClassRepeatVars {

    private ClassRepeatVars ClassRepeatVars;
    private ClassLocalVarDecl ClassLocalVarDecl;

    public ClassRepeatingVars (ClassRepeatVars ClassRepeatVars, ClassLocalVarDecl ClassLocalVarDecl) {
        this.ClassRepeatVars=ClassRepeatVars;
        if(ClassRepeatVars!=null) ClassRepeatVars.setParent(this);
        this.ClassLocalVarDecl=ClassLocalVarDecl;
        if(ClassLocalVarDecl!=null) ClassLocalVarDecl.setParent(this);
    }

    public ClassRepeatVars getClassRepeatVars() {
        return ClassRepeatVars;
    }

    public void setClassRepeatVars(ClassRepeatVars ClassRepeatVars) {
        this.ClassRepeatVars=ClassRepeatVars;
    }

    public ClassLocalVarDecl getClassLocalVarDecl() {
        return ClassLocalVarDecl;
    }

    public void setClassLocalVarDecl(ClassLocalVarDecl ClassLocalVarDecl) {
        this.ClassLocalVarDecl=ClassLocalVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassRepeatVars!=null) ClassRepeatVars.accept(visitor);
        if(ClassLocalVarDecl!=null) ClassLocalVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassRepeatVars!=null) ClassRepeatVars.traverseTopDown(visitor);
        if(ClassLocalVarDecl!=null) ClassLocalVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassRepeatVars!=null) ClassRepeatVars.traverseBottomUp(visitor);
        if(ClassLocalVarDecl!=null) ClassLocalVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassRepeatingVars(\n");

        if(ClassRepeatVars!=null)
            buffer.append(ClassRepeatVars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassLocalVarDecl!=null)
            buffer.append(ClassLocalVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassRepeatingVars]");
        return buffer.toString();
    }
}
