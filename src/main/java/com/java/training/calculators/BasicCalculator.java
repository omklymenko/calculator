package com.java.training.calculators;

import com.java.training.enums.OperationType;
import com.java.training.interfaces.Calculator;
import com.java.training.interfaces.Operation;
import com.java.training.models.Expression;
import com.java.training.operations.OperationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.java.training.enums.ErrorMessage.NOT_A_NUMBER_ERROR;

@Component
public class BasicCalculator implements Calculator {

    @Autowired
    private OperationFactory operationFactory;

    public Integer calculate(OperationType operationType, Integer firstInteger, Integer secondInteger) {
        if(firstInteger != null && secondInteger != null) {
            Operation operation = operationFactory.getOperation(operationType);
            return operation.operate(firstInteger, secondInteger);
        } else {
            throw new IllegalArgumentException(NOT_A_NUMBER_ERROR.getMessage());
        }
    }

    public Integer calculate(Expression expression) {
        return calculate(expression.getOperationType(), expression.getFirstInput(), expression.getSecondInput());
    }
}
