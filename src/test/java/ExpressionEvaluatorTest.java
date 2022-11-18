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
    public void EvaluateTest1(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertEquals(e.evaluate("( ( 1 + 3 ) * 4 )"),16);
    }

    /**
     * tests subtraction, division and sqrt operator
     */
    @Test
    public void EvaluateTest2(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertEquals(e.evaluate("( ( 1 - 3 ) / ( sqrt 4 ) )"),-1);
    }

    /**
     * tests addition and division
     */
    @Test
    public void EvaluateTest3(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertEquals(e.evaluate("( ( 1 + 3 ) / ( 4 * 1 ) )"),1);
    }

    /**
     * test a bit longer expression with a lot of brackets
     */
    @Test
    public void EvaluateTest4(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertEquals(e.evaluate("( ( ( 1 + 3 ) * ( 4 - 1 ) ) + ( ( 4 + 5 ) + ( 1 * 0 ) ) )"),21);
    }

    /**
     * test if the function is throwing an exception and if it's the right exception
     */
    @Test
    public void EvaluateTest5(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertThrows( RuntimeException.class, () -> e.evaluate("( ( 1 + 3 ) *  )"));
    }
    /**
     * test for all operators at once
     */
    @Test
    public void EvaluateTest6(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertEquals(e.evaluate("( ( ( 1 + 3 ) * ( 4 - 1 ) ) / ( ( 4 + 5 ) + sqrt ( 1 ) ) ) "),1.2);
    }
    /**
     * test if the function is throwing an exception when we input letters
     */
    @Test
    public void EvaluateTest7(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertThrows( RuntimeException.class, () -> e.evaluate("( ( 1 + 3 ) *ghhz  )"));
    }
    /**
     * test if the function is throwing an exception when we input just sqrt
     */
    @Test
    public void EvaluateTest8(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertThrows( RuntimeException.class, () -> e.evaluate("sqrt"));
    }
    /**
     * test if the function is throwing an exception when we do not have enough brackets
     */
    @Test
    public void EvaluateTest9(){
        ExpressionEvaluator e= new ExpressionEvaluator();
        assertThrows( RuntimeException.class, () -> e.evaluate("( 1 + 2 + 3 + ( 6 ) )"));
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
