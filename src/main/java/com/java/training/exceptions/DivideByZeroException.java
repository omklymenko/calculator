package com.java.training.exceptions;

public class DivideByZeroException extends RuntimeException {

    public DivideByZeroException() {
        super("0 is not acceptable as the second parameter for division");
    }
}
