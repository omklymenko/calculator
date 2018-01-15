package com.java.training.enums;

import java.util.HashMap;
import java.util.Map;

import static com.java.training.enums.ErrorMessage.NOT_SUPPORTED_OPERATION_ERROR;

public enum OperationType {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;

    private static Map<String, OperationType> operationTypeMap = new HashMap<>();

    static {
        operationTypeMap.put("+", ADD);
        operationTypeMap.put("-", SUBTRACT);
        operationTypeMap.put("*", MULTIPLY);
        operationTypeMap.put("/", DIVIDE);
    }

    public static OperationType getOperationType(String sign) {
        if(operationTypeMap.containsKey(sign)){
            return operationTypeMap.get(sign);
        } else {
            throw new IllegalArgumentException(NOT_SUPPORTED_OPERATION_ERROR.getMessage());
        }
    }

    public static String getKeyFromValue(OperationType operationType) {
        for (String key : operationTypeMap.keySet()) {
            if (operationTypeMap.get(key).equals(operationType)) {
                return key;
            }
        }
        return null;
    }

    public static String getSign(OperationType operationType) {
        if(operationTypeMap.containsValue(operationType)){
            return getKeyFromValue(operationType);
        } else {
            throw new IllegalArgumentException(NOT_SUPPORTED_OPERATION_ERROR.getMessage());
        }
    }
}
