package com.java.training.enums;

public enum ErrorMessage {
    DIVIDE_BY_ZERO_ERROR ("0 is not acceptable as the second parameter for division"),
    NOT_A_NUMBER_ERROR ("");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
