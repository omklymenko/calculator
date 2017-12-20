package com.java.training.calculators;

import com.java.training.enums.OperationType;
import com.java.training.operations.Operation;
import com.java.training.operations.OperationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasicCalculator implements Calculator {

    @Autowired
    private OperationFactory operationFactory;

    public Integer calculate(OperationType operationType, Integer firstInteger, Integer secondInteger) {
        Operation operation = operationFactory.getOperation(operationType);
        return operation.operate(firstInteger, secondInteger);
    }
}
