package com.java.training;

import com.java.training.exceptions.DivideByZeroException;
import com.java.training.interfaces.Calculator;
import com.java.training.models.MathExpression;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.java.training.enums.ErrorMessage.DIVIDE_BY_ZERO_ERROR;
import static com.java.training.enums.ErrorMessage.NOT_A_NUMBER_ERROR;
import static com.java.training.enums.OperationType.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class BasicCalculatorTest {

    @Autowired
    Calculator calculator;

    @Autowired
    ExpressionLoader expressionLoader;

    @Test
    public void testMultiplication(){
        Integer expectedResult = 10;
        Assert.assertEquals("The result of multiplication is not as expected", expectedResult,
                calculator.calculate(MULTIPLY, 2, 5));
    }

    @Test
    public void testMultiplyPositiveNegativeNumbers(){
        Integer expectedResult = -10;
        Assert.assertEquals("The result of multiplication is not as expected", expectedResult,
                calculator.calculate(MULTIPLY, -2, 5));
    }

    @Test
    public void testMultiplyNegativeNumbers(){
        Integer expectedResult = 10;
        Assert.assertEquals("The result of multiplication is not as expected", expectedResult,
                calculator.calculate(MULTIPLY, -2, -5));
    }

    @Test
    public void testAddition(){
        Integer expectedResult = 7;
        Assert.assertEquals("The result of addition is not as expected", expectedResult,
                calculator.calculate(ADD, 2, 5));
    }

    @Test
    public void testDivision(){
        Integer expectedResult = 2;
        Assert.assertEquals("The result of division is not as expected", expectedResult,
                calculator.calculate(DIVIDE, 12, 5));
    }

    @Test
    public void testDivideNegativeNumbers(){
        Integer expectedResult = 2;
        Assert.assertEquals("The result of division is not as expected", expectedResult,
                calculator.calculate(DIVIDE, -12, -5));
    }

    @Test
    public void testSubtraction(){
        Integer expectedResult = 7;
        Assert.assertEquals("The result of subtraction is not as expected", expectedResult,
                calculator.calculate(SUBTRACT, 12, 5));
    }

    @Test(expected = DivideByZeroException.class)
    public void testDivideByZero(){
        Integer firstParam = 12;
        Integer secondParam = 0;
        calculator.calculate(DIVIDE, firstParam, secondParam);
    }

    @Test
    public void testDivideByZeroMessage(){
        Integer firstParam = 12;
        Integer secondParam = 0;
        try {
            calculator.calculate(DIVIDE, secondParam, secondParam);
        } catch (DivideByZeroException exception){
            Assert.assertEquals("Error message is not as expected", DIVIDE_BY_ZERO_ERROR.getMessage(), exception.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotNumberArgument(){
        Integer firstParam = 12;
        Integer secondParam = null;
        calculator.calculate(ADD, firstParam, secondParam);
    }

    @Test
    public void testNotNumberArgumentMessage(){
        Integer firstParam = null;
        Integer secondParam = 10;
        try {
            calculator.calculate(MULTIPLY, firstParam, secondParam);
        } catch (IllegalArgumentException exception){
            Assert.assertEquals("Error message is not as expected", NOT_A_NUMBER_ERROR.getMessage(), exception.getMessage());
        }
    }

    @Test
    public void testCalculateExpressionsFromFile(){
        List<MathExpression> mathExpressions = expressionLoader.loadExpressions("src/main/resources/testfile2.txt");
        Integer[] expectedResult = {45, 167, 24, -9, 11, 3, 5, 3, 16};
        for(int i = 0; i < mathExpressions.size(); i++){
            System.out.println(mathExpressions.get(i).getFirstParam());
            Assert.assertEquals("Result of calculation is not as expected", expectedResult[i], calculator.calculate(mathExpressions.get(i)));
        }
    }

}
