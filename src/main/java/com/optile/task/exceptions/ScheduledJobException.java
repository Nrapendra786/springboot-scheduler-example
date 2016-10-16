package com.optile.task.exceptions;

/**
 * Created by NrapendraKumar on 03-10-2016.
 */
public class ScheduledJobException extends RuntimeException {
    public ScheduledJobException(){
        super();
    }

    public ScheduledJobException(String message,Throwable throwable){
        super(message,throwable);
    }
}
