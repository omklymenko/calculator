package com.java.training;

import com.java.training.calculators.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.java.training.enums.OperationType.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class BasicCalculatorTest {

    @Autowired
    Calculator calculator;

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
}
