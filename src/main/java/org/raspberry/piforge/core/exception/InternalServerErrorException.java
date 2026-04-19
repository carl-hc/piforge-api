package org.raspberry.piforge.core.exception;

public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(Throwable cause, String message, Object... args) {
        super(String.format(message, args), cause);
    }

}
