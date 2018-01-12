package com.java.training.exceptions;

import static com.java.training.enums.ErrorMessage.FILE_LOADER_ERROR;

public class FileLoaderException extends RuntimeException {

    public FileLoaderException() {
        super(FILE_LOADER_ERROR.getMessage());
    }
}
