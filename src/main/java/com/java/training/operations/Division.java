package com.java.training.operations;

import com.java.training.exceptions.DivideByZeroException;
import com.java.training.interfaces.Operation;

public class Division implements Operation {

    public Integer operate(Integer firstInteger, Integer secondInteger) {
        if(secondInteger.equals(0)){
            throw new DivideByZeroException();
        }
        return firstInteger / secondInteger;
    }
}
