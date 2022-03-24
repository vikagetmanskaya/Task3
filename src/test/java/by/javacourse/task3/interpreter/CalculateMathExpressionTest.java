package by.javacourse.task3.interpreter;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculateMathExpressionTest {
    private MathExpressionCalculator calculator;
    private static final String EXPRESSION = "(-3-5)*2+1";

    @BeforeClass
    public void setUp() {
        calculator = new MathExpressionCalculator();
    }

    @Test
    void calculatorExpressionTest() {
        String expected = "-15,0";
        Double expressionResult = calculator.calculate(EXPRESSION);
        String actual = String.format("%,.1f", expressionResult);
        Assert.assertEquals(actual, expected);

    }
}
