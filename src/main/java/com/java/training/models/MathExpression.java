package com.java.training.models;

import com.java.training.enums.OperationType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MathExpression {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Override
    public String toString() {
        return firstParam.toString() + OperationType.getSign(operationType) + secondParam.toString();
    }

}
