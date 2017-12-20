package com.java.training;

import com.java.training.calculators.Calculator;
import com.java.training.exceptions.DivideByZeroException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.java.training.enums.ErrorMessage.DIVIDE_BY_ZERO_ERROR;
import static com.java.training.enums.OperationType.DIVIDE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class BasicCalculatorExceptionTest {

    @Autowired
    Calculator calculator;

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
            calculator.calculate(DIVIDE, firstParam, secondParam);
        } catch (RuntimeException exception){
            Assert.assertEquals("Error message is not as expected", DIVIDE_BY_ZERO_ERROR.getMessage(), exception.getMessage());
        }
    }

}
