package com.java.training.calculators;

import com.java.training.enums.OperationType;

public interface Calculator {

    Integer calculate(OperationType operationType, Integer firstInteger, Integer secondInteger);
}
