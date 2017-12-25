package com.java.training.operations;

import com.java.training.interfaces.Operation;

class Addition implements Operation {

    public Integer operate(Integer firstInteger, Integer secondInteger) {
        return firstInteger + secondInteger;
    }
}
