package com.leapnode;

/**
 * Basic Exception class to handle specific exceptions within this project.
 *
 * @author brandon@solanaleap.com
 * @version 0.1
 * @since 0.1
 */
public class LeapNodeException extends Exception {

    private String exceptionMessage = "Nada";

    public LeapNodeException(){};

    public LeapNodeException(String message){}

    public void setMessage(String exceptionMessage){
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
