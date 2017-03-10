package com.roman.exception;

/**
 * Created by LINKOR on 11.11.2016 in 15:35.
 * Date: 2016.11.11
 */
public class MethodException extends RuntimeException {
    public MethodException() {
        super();
    }
    public MethodException(String message) {
        super(message);
    }
    public MethodException(String message, Throwable cause) {
        super(message, cause);
    }
    public MethodException(Throwable cause) {
        super(cause);
    }
    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }
    @Override
    public String toString() {
        return getClass().toString() + ":\n message = " + getMessage() + "\n lmessage = " + getLocalizedMessage() + " \n cause = " +getCause();
    }
}
