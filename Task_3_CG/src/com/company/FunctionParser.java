package com.company;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class FunctionParser {
    private static Expression exp;


    public static double retY(String e, double x) {
        exp = new ExpressionBuilder(e).variables("x").build();
        return f(x);
    }

    public static double f(double x) {
        try {
            return exp.setVariable("x", x).evaluate();
        } catch (Throwable cause) {
            if (cause instanceof ArithmeticException && "Division by zero!".equals(cause.getMessage())) {
                return Double.POSITIVE_INFINITY;
            }
            else
                return Double.NaN;
        }
    }
}
