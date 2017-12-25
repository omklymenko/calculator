package com.java.training.operations;

import com.java.training.enums.OperationType;
import com.java.training.interfaces.Operation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.java.training.enums.ErrorMessage.NOT_SUPPORTED_OPERATION_ERROR;
import static com.java.training.enums.OperationType.*;

@Component
public class OperationFactory {
    private Map<OperationType, Operation> map = new HashMap<OperationType, Operation>();

    {
        map.put(ADD, new Addition());
        map.put(MULTIPLY, new Multiplication());
        map.put(SUBTRACT, new Subtraction());
        map.put(DIVIDE, new Division());
    }

    public Operation getOperation(OperationType operationType){
        if(!map.containsKey(operationType)){
            throw new IllegalArgumentException(NOT_SUPPORTED_OPERATION_ERROR.getMessage());
        } else return map.get(operationType);
    }
}
