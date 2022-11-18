package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 *class for evaluating expressions using Dijkstra's algorithm and two stacks operators and values
 *@author Emina Efendic
 *@version 1.0
 */
public class ExpressionEvaluator {
    private final Stack<String> operators = new Stack<>();
    private final Stack<Double> values = new Stack<>();

    /**
     * checks if argument is a number
     * @param s String
     * @return boolean
     */
    public static boolean isDigit(String s){
        if(s == null || s.equals("")) return false;
        try{
            Double.parseDouble(s);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    /**
     * gives us evaluated expression
     * @param s String
     * @return value of given expression (double)
     */
    public Double evaluate(String s) {
        String[] str = s.split(" ");
        int left = 0, right = 0, operator=0;
        for(String x: str) {

            if (x.equals("(")) left = left + 1;
            if (x.equals(")")) right = right + 1;
            if(x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/") || x.equals("sqrt") ) operator=operator+1;
        }
        if (left != right || operator!=right)   throw new RuntimeException();
        for (String x : str) {
            if (!x.equals("(") && !x.equals("+") && !x.equals("-") && !x.equals("*") && !x.equals("/") && !x.equals("sqrt") && !x.equals(")") && !isDigit(x)) {
                throw new RuntimeException();
            }
            switch (x) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    operators.push(x);
                    break;
                case ")":
                    String o = operators.pop();
                    Double v = values.pop();
                    switch (o) {
                        case "+" -> v += values.pop();
                        case "-" -> v = values.pop() - v;
                        case "*" -> v *= values.pop();
                        case "/" -> v = values.pop() / v;
                        case "sqrt" -> v = Math.sqrt(v);
                    }
                    values.push(v);
                    break;
                default:
                    values.push(Double.parseDouble(x));
                    break;
            }
        }
        return values.pop();
    }
}
