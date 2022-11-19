import ba.unsa.etf.rpr.ExpressionEvaluator;
import org.junit.jupiter.api.Test;

import static ba.unsa.etf.rpr.ExpressionEvaluator.isDigit;
import static org.junit.jupiter.api.Assertions.*;
/**
 * class that tests our program for evaluating expressions
 * @author Emina Efendic
 * @version 1.0
 */
public class ExpressionEvaluatorTest {
    /**
     * test addition and multiplication
     */
    @Test
    public void evaluateTest1(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertEquals(e.evaluate("( ( 1 + 3 ) * 4 )"),16);
    }

    /**
     * tests subtraction, division and sqrt operator
     */
    @Test
    public void evaluateTest2(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertEquals(e.evaluate("( ( 1 - 3 ) / ( sqrt 4 ) )"),-1);
    }

    /**
     * tests addition and division
     */
    @Test
    public void evaluateTest3(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertEquals(e.evaluate("( ( 1 + 3 ) / ( 4 * 1 ) )"),1);
    }

    /**
     * test a bit longer expression with a lot of brackets
     */
    @Test
    public void evaluateTest4(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertEquals(e.evaluate("( ( ( 1 + 3 ) * ( 4 - 1 ) ) + ( ( 4 + 5 ) + ( 1 * 0 ) ) )"),21);
    }

    /**
     * test if the function is throwing an exception and if it's the right exception
     */
    @Test
    public void evaluateTest5(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertThrows( RuntimeException.class, () -> e.evaluate("( ( 1 + 3 ) *  )"));
    }
    /**
     * test for all operators at once
     */
    @Test
    public void evaluateTest6(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertEquals(e.evaluate("( ( ( 1 + 3 ) * ( 4 - 1 ) ) / ( ( 4 + 5 ) + sqrt ( 1 ) ) ) "),1.2);
    }
    /**
     * test if the function is throwing an exception when we input letters
     */
    @Test
    public void evaluateTest7(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertThrows( RuntimeException.class, () -> e.evaluate("( ( 1 + 3 ) *ghhz  )"));
    }
    /**
     * test if the function is throwing an exception when we input just sqrt
     */
    @Test
    public void evaluateTest8(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertThrows( RuntimeException.class, () -> e.evaluate("sqrt"));
    }
    /**
     * test if the function is throwing an exception when we do not have enough brackets
     */
    @Test
    public void evaluateTest9(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertThrows( RuntimeException.class, () -> e.evaluate("( 1 + 2 + 3 + ( 6 ) )"));
    }
    /**
     * test if the function is throwing an exception when we do not have enough brackets
     */
    @Test
    public void evaluateTest10(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertThrows( RuntimeException.class, () -> e.evaluate("( 1 + 2 + 3 + 6 * 4 / 6 )"));
    }
    /**
     * test for isDigit method, number is given
     */
    @Test
    public void isDigitTest1(){
        assertTrue(isDigit("3"));
    }
    /**
     * test for isDigit method, letter is given
     */
    @Test
    public void isDigitTest2(){
        assertFalse(isDigit("e"));
    }
}
