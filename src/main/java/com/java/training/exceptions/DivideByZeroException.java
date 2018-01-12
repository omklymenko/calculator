package com.java.training.exceptions;

import static com.java.training.enums.ErrorMessage.DIVIDE_BY_ZERO_ERROR;

public class DivideByZeroException extends RuntimeException {

    public DivideByZeroException() {
        super(DIVIDE_BY_ZERO_ERROR.getMessage());
    }
}
