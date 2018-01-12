package com.java.training.enums;

public enum ErrorMessage {
    DIVIDE_BY_ZERO_ERROR ("0 is not acceptable as the second parameter for division"),
    FILE_LOADER_ERROR ("Error while opening file with expressions. Please, check if file exists."),
    NOT_SUPPORTED_OPERATION_ERROR("This operation is not supported by Calculator"),
    NOT_A_NUMBER_ERROR ("Only integer is acceptable");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
