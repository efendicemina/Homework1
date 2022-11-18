package ba.unsa.etf.rpr;


/**
 * class that is entry point for our program
 * @author Emina Efendic
 * @version 1.0
 */
public class App {
    /**
     * main method that parses input from console so that we can evaluate it
     * @param args String[]
     */
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        try {
            if (args.length >1) { //only one string allowed
                throw new RuntimeException();
            }
            for (String arg : args) {
                str.append(arg).append(" ");
            }
            ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
            System.out.println(expressionEvaluator.evaluate(String.valueOf(str)));
        }
        catch(RuntimeException e) {
            System.out.println("""
                            Input not correct.
                            Please note that for every operator you use you need the same number of brackets.
                            Numbers must be real number values.
                            No letters are allowed except for sqrt operator.""");
        }
    }
}