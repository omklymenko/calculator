package com.java.training.exceptions;

import static com.java.training.enums.ErrorMessage.FILE_CREATION_ERROR;

public class FileCreationException extends RuntimeException {

    public FileCreationException() {
        super(FILE_CREATION_ERROR.getMessage());
    }
}
