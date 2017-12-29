package com.java.training.models;

import com.java.training.enums.OperationType;

public class Expression {

    private Integer firstInput;
    private Integer secondInput;
    private OperationType operationType;

    public Integer getFirstInput() {
        return firstInput;
    }

    public void setFirstInput(Integer firstInput) {
        this.firstInput = firstInput;
    }

    public Integer getSecondInput() {
        return secondInput;
    }

    public void setSecondInput(Integer secondInput) {
        this.secondInput = secondInput;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

}
