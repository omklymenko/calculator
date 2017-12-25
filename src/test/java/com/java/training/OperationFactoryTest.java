package com.java.training;

import com.java.training.interfaces.Operation;
import com.java.training.operations.OperationFactory;
import com.java.training.operations.Subtraction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.java.training.enums.ErrorMessage.NOT_SUPPORTED_OPERATION_ERROR;
import static com.java.training.enums.OperationType.SUBTRACT;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class OperationFactoryTest {

    @Autowired
    OperationFactory operationFactory;

    @Test
    public void testUnsupportedOperationMessage() {
        try {
            operationFactory.getOperation(null);
        } catch (IllegalArgumentException exception){
            Assert.assertEquals("Error message is not as expected", NOT_SUPPORTED_OPERATION_ERROR.getMessage(), exception.getMessage());
        }
    }

    @Test
    public void testValidOperation() {
        Operation expectedOperation = new Subtraction();
        Assert.assertEquals("Operation is not as expected", expectedOperation.getClass(), operationFactory.getOperation(SUBTRACT).getClass());
    }
}
