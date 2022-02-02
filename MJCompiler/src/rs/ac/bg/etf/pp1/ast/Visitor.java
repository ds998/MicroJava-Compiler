// generated with ast extension for cup
// version 0.8
// 26/7/2021 14:5:46


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(FormPars FormPars);
    public void visit(Factor Factor);
    public void visit(Statement Statement);
    public void visit(ClassExtOpt ClassExtOpt);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(Declarations Declarations);
    public void visit(MethodTN MethodTN);
    public void visit(CaseList CaseList);
    public void visit(IfCondition IfCondition);
    public void visit(Expr Expr);
    public void visit(VarDecl VarDecl);
    public void visit(RepeatVars RepeatVars);
    public void visit(DesignatorF DesignatorF);
    public void visit(LocalVarDeclList LocalVarDeclList);
    public void visit(AssignmentOperation AssignmentOperation);
    public void visit(RelOp RelOp);
    public void visit(MethodDecl1 MethodDecl1);
    public void visit(Declaration Declaration);
    public void visit(ClassRepeatVars ClassRepeatVars);
    public void visit(ContFormPars ContFormPars);
    public void visit(ProgMethods ProgMethods);
    public void visit(LocalVarDecl LocalVarDecl);
    public void visit(Condition Condition);
    public void visit(StatementList StatementList);
    public void visit(ConstDecl ConstDecl);
    public void visit(DesignatorFollowUp DesignatorFollowUp);
    public void visit(MulOp MulOp);
    public void visit(DesignatorOp DesignatorOp);
    public void visit(CondTerm CondTerm);
    public void visit(FormParOpt FormParOpt);
    public void visit(VarDeclVarIndOpt VarDeclVarIndOpt);
    public void visit(PossNumConst PossNumConst);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(ClassLocalVarDecl ClassLocalVarDecl);
    public void visit(AddOp AddOp);
    public void visit(Expr1 Expr1);
    public void visit(PlusTerms PlusTerms);
    public void visit(RetExprOpt RetExprOpt);
    public void visit(ActPars ActPars);
    public void visit(VarDeclList VarDeclList);
    public void visit(CondFact CondFact);
    public void visit(Term Term);
    public void visit(ConstVal ConstVal);
    public void visit(Mod Mod);
    public void visit(Div Div);
    public void visit(Mul Mul);
    public void visit(Minus Minus);
    public void visit(Plus Plus);
    public void visit(Le_e Le_e);
    public void visit(Le Le);
    public void visit(Gt_e Gt_e);
    public void visit(Gt Gt);
    public void visit(NEqual NEqual);
    public void visit(DEqual DEqual);
    public void visit(AssignOp AssignOp);
    public void visit(DesFDot DesFDot);
    public void visit(LRIndicator LRIndicator);
    public void visit(DesFArr DesFArr);
    public void visit(ArrMember ArrMember);
    public void visit(DotMember DotMember);
    public void visit(NoFolUp NoFolUp);
    public void visit(DesFolUp DesFolUp);
    public void visit(StartDesignator StartDesignator);
    public void visit(Designator Designator);
    public void visit(PDesignator PDesignator);
    public void visit(NPDesignator NPDesignator);
    public void visit(ExprFactor ExprFactor);
    public void visit(NewArrFactor NewArrFactor);
    public void visit(NewFactor NewFactor);
    public void visit(BoolFactor BoolFactor);
    public void visit(CharFactor CharFactor);
    public void visit(NumFactor NumFactor);
    public void visit(ParamDesignator ParamDesignator);
    public void visit(NoParamDesignator NoParamDesignator);
    public void visit(NoFuncDesignator NoFuncDesignator);
    public void visit(OneFactor OneFactor);
    public void visit(MulFactor MulFactor);
    public void visit(OneTerm OneTerm);
    public void visit(MultipleTerms MultipleTerms);
    public void visit(PlusExpr PlusExpr);
    public void visit(MinusExpr MinusExpr);
    public void visit(OneExpr OneExpr);
    public void visit(RelationExpr RelationExpr);
    public void visit(CondTermLeftAnd CondTermLeftAnd);
    public void visit(ConditionalFactor ConditionalFactor);
    public void visit(ConditionalFactors ConditionalFactors);
    public void visit(ConditionLeftOr ConditionLeftOr);
    public void visit(ConditionalTerm ConditionalTerm);
    public void visit(ConditionalTerms ConditionalTerms);
    public void visit(ActualParameter ActualParameter);
    public void visit(ActualParameters ActualParameters);
    public void visit(ErrorAssignmentOp ErrorAssignmentOp);
    public void visit(AssignmentOp AssignmentOp);
    public void visit(Decrement Decrement);
    public void visit(Increment Increment);
    public void visit(NoParams NoParams);
    public void visit(ActualParams ActualParams);
    public void visit(Assignment Assignment);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(NoNumConst NoNumConst);
    public void visit(PossibleNumConst PossibleNumConst);
    public void visit(NoExprOpt NoExprOpt);
    public void visit(ReturnExprOpt ReturnExprOpt);
    public void visit(ErrorCond ErrorCond);
    public void visit(SuccCond SuccCond);
    public void visit(SwitchS SwitchS);
    public void visit(CaseStart CaseStart);
    public void visit(Case Case);
    public void visit(NoCases NoCases);
    public void visit(Cases Cases);
    public void visit(OneExpression OneExpression);
    public void visit(DoS DoS);
    public void visit(ElseStmt ElseStmt);
    public void visit(WhileStmt WhileStmt);
    public void visit(IfElseStmt IfElseStmt);
    public void visit(IfStmt IfStmt);
    public void visit(MultipleStmts MultipleStmts);
    public void visit(PrintStmt PrintStmt);
    public void visit(ReadStmt ReadStmt);
    public void visit(ReturnStmt ReturnStmt);
    public void visit(ContinueStmt ContinueStmt);
    public void visit(BreakStmt BreakStmt);
    public void visit(SwitchStmt SwitchStmt);
    public void visit(DoStmt DoStmt);
    public void visit(Designation Designation);
    public void visit(NoStmts NoStmts);
    public void visit(StmtList StmtList);
    public void visit(Type Type);
    public void visit(NoFormalParOpt NoFormalParOpt);
    public void visit(FormalParOpt FormalParOpt);
    public void visit(FormPar FormPar);
    public void visit(SingleFormParam SingleFormParam);
    public void visit(ContFormParams ContFormParams);
    public void visit(ErrorFormPars ErrorFormPars);
    public void visit(NoFormParams NoFormParams);
    public void visit(FormParams FormParams);
    public void visit(VoidTN VoidTN);
    public void visit(RegTypeTN RegTypeTN);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoProgrammingMethods NoProgrammingMethods);
    public void visit(ProgrammingMethods ProgrammingMethods);
    public void visit(MethodDeclarationOne MethodDeclarationOne);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(NoMethodsBraced NoMethodsBraced);
    public void visit(MethodsBraced MethodsBraced);
    public void visit(LocalVarDeclaration LocalVarDeclaration);
    public void visit(LocalVarDeclarationList LocalVarDeclarationList);
    public void visit(LocalVarDeclarations LocalVarDeclarations);
    public void visit(NoClassOptionalVar NoClassOptionalVar);
    public void visit(RepeatingVars RepeatingVars);
    public void visit(ErrorClassLocalVarDeclarations ErrorClassLocalVarDeclarations);
    public void visit(ClassLocalVarDeclarations ClassLocalVarDeclarations);
    public void visit(NoClassVar NoClassVar);
    public void visit(ClassRepeatingVars ClassRepeatingVars);
    public void visit(ErrorClassExtension ErrorClassExtension);
    public void visit(NoClassExtension NoClassExtension);
    public void visit(ClassExtension ClassExtension);
    public void visit(ClassName ClassName);
    public void visit(ClassDecl ClassDecl);
    public void visit(NoVarDeclVarIndOption NoVarDeclVarIndOption);
    public void visit(VarDeclVarIndOption VarDeclVarIndOption);
    public void visit(VarDeclVar2 VarDeclVar2);
    public void visit(VarDeclVar VarDeclVar);
    public void visit(ErrorVarDeclList ErrorVarDeclList);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(VarDeclarationList VarDeclarationList);
    public void visit(ErrorVarDeclarations ErrorVarDeclarations);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(NumConst NumConst);
    public void visit(Bool Bool);
    public void visit(Char Char);
    public void visit(Num Num);
    public void visit(ConstDeclVar2 ConstDeclVar2);
    public void visit(ConstDeclVar ConstDeclVar);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(ConstDeclarationList ConstDeclarationList);
    public void visit(ConstDeclarations ConstDeclarations);
    public void visit(ClDecl ClDecl);
    public void visit(VDecl VDecl);
    public void visit(CDecl CDecl);
    public void visit(NoDeclaration NoDeclaration);
    public void visit(DeclarationList DeclarationList);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
