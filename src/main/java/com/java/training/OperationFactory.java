package com.java.training;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.java.training.OperationType.*;

@Component
class OperationFactory {
    private Map<OperationType, Operation> map = new HashMap<OperationType, Operation>();

    public OperationFactory() {
        fillMap();
    }

    private void fillMap(){
        map.put(ADD, new Addition());
        map.put(MULTIPLY, new Multiplication());
        map.put(SUBTRACT, new Subtraction());
        map.put(DIVIDE, new Division());
    }

    Operation getOperation(OperationType operationType){
        return map.get(operationType);
    }
}
