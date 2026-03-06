package com.craftinginterpreters.lox;

public class RPNPrinter implements Expr.Visitor<String>{
    String print(Expr expr){
        return expr.accept(this);
    }

    @Override
    public String visitBinaryExpr(Expr.Binary expr){
        return expr.left.accept(this) + " " + expr.right.accept(this) + " " + expr.operator.lexeme;
    }

    @Override
    public String visitGroupingExpr(Expr.Grouping expr){
        return expr.expression.accept(this);
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr){
        return expr.value.toString();
    }

    @Override
    public String visitUnaryExpr(Expr.Unary expr){
        return expr.right.accept(this) + " " + expr.operator.lexeme;
    }

    //stuff below needs to be overridden but doesn't need to be focused on for the RPNPrinter, thus just returns
    //*************************************************************************************//
    @Override
    public String visitAssignExpr(Expr.Assign expr) {
        return "";
    }

    @Override
    public String visitCallExpr(Expr.Call expr) {
        return "";
    }

    @Override
    public String visitGetExpr(Expr.Get expr) {
        return "";
    }

    @Override
    public String visitLogicalExpr(Expr.Logical expr) {
        return "";
    }

    @Override
    public String visitSetExpr(Expr.Set expr) {
        return "";
    }

    @Override
    public String visitSuperExpr(Expr.Super expr) {
        return "";
    }

    @Override
    public String visitThisExpr(Expr.This expr) {
        return "";
    }

    @Override
    public String visitVariableExpr(Expr.Variable expr) {
        return "";
    }

    public static void main(String[] args) {
        Expr expr = new Expr.Binary(
                new Expr.Literal(5),
                new Token(TokenType.MINUS, "-", null, 1),
                new Expr.Literal(2)
        );

        Expr fExpr = new Expr.Binary(
                expr,
                new Token(TokenType.STAR, "*", null, 1),
                new Expr.Literal(3)
        );

        RPNPrinter printer = new RPNPrinter();
        System.out.println(printer.print(fExpr));
    }

}
