package com.java.training.interfaces;

import com.java.training.enums.OperationType;

public interface Calculator {

    Integer calculate(OperationType operationType, Integer firstInteger, Integer secondInteger);
}
