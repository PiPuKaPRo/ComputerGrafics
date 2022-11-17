package com.company;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class FunctionParserWithParam {
    private static Expression exp;


    public static double retY(String e, double x) {
        exp = new ExpressionBuilder(e).variables("ax").build();
        return f(x);
    }

    public static double f(double x) {
        try {
            return exp.setVariable("ax", x).evaluate();
        } catch (Throwable cause) {
            if (cause instanceof ArithmeticException && "Division by zero!".equals(cause.getMessage())) {
                return Double.POSITIVE_INFINITY;
            }
            else
                return Double.NaN;
        }
    }
}
