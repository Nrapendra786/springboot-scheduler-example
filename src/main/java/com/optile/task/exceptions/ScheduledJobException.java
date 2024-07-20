package com.optile.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by NrapendraKumar on 03-10-2016.
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ScheduledJobException extends RuntimeException {

    public ScheduledJobException(String message,Throwable throwable){
        super(message,throwable);
    }
}
