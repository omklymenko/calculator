package com.java.training;

import com.java.training.interfaces.Operation;
import com.java.training.operations.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.java.training.enums.ErrorMessage.NOT_SUPPORTED_OPERATION_ERROR;
import static com.java.training.enums.OperationType.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class OperationFactoryTest {

    @Autowired
    OperationFactory operationFactory;

    @Test
    public void testAdditionOperation() {
        Operation expectedOperation = new Addition();
        Assert.assertEquals("Operation is not as expected", expectedOperation.getClass(), operationFactory.getOperation(ADD).getClass());
    }

    @Test
    public void testSubtractionOperation() {
        Operation expectedOperation = new Subtraction();
        Assert.assertEquals("Operation is not as expected", expectedOperation.getClass(), operationFactory.getOperation(SUBTRACT).getClass());
    }

    @Test
    public void testMultiplicationOperation() {
        Operation expectedOperation = new Multiplication();
        Assert.assertEquals("Operation is not as expected", expectedOperation.getClass(), operationFactory.getOperation(MULTIPLY).getClass());
    }

    @Test
    public void testDivisionOperation() {
        Operation expectedOperation = new Division();
        Assert.assertEquals("Operation is not as expected", expectedOperation.getClass(), operationFactory.getOperation(DIVIDE).getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnsupportedOperation(){
        operationFactory.getOperation(null);
    }

    @Test
    public void testUnsupportedOperationMessage(){
        try {
            operationFactory.getOperation(null);
        } catch (IllegalArgumentException exception){
            Assert.assertEquals("Error message is not as expected", NOT_SUPPORTED_OPERATION_ERROR.getMessage(), exception.getMessage());
        }
    }
}
