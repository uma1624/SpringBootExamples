
package com.aus.advice;

public class OrderServiceException extends RuntimeException {
    public OrderServiceException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    String message ;

}
