package com.java.training.models;

import com.java.training.enums.OperationType;

public class MathExpression {

    private int id;
    private OperationType operationType;
    private Integer firstParam;
    private Integer secondParam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Integer getFirstParam() {
        return firstParam;
    }

    public void setFirstParam(Integer firstParam) {
        this.firstParam = firstParam;
    }

    public Integer getSecondParam() {
        return secondParam;
    }

    public void setSecondParam(Integer secondParam) {
        this.secondParam = secondParam;
    }

}
