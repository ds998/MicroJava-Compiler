// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:44


package rs.ac.bg.etf.pp1.ast;

public class ClassLocalVarDeclarations extends ClassLocalVarDecl {

    private LocalVarDeclList LocalVarDeclList;

    public ClassLocalVarDeclarations (LocalVarDeclList LocalVarDeclList) {
        this.LocalVarDeclList=LocalVarDeclList;
        if(LocalVarDeclList!=null) LocalVarDeclList.setParent(this);
    }

    public LocalVarDeclList getLocalVarDeclList() {
        return LocalVarDeclList;
    }

    public void setLocalVarDeclList(LocalVarDeclList LocalVarDeclList) {
        this.LocalVarDeclList=LocalVarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LocalVarDeclList!=null) LocalVarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LocalVarDeclList!=null) LocalVarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LocalVarDeclList!=null) LocalVarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassLocalVarDeclarations(\n");

        if(LocalVarDeclList!=null)
            buffer.append(LocalVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassLocalVarDeclarations]");
        return buffer.toString();
    }
}
