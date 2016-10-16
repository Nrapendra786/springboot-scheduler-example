package com.optile.task.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by NrapendraKumar on 05-10-2016.
 */
@Component
public class SpringUtil {

    public static ApplicationContext ctx;

    /**
     * Make Spring inject the application context
     * and save it on a static variable,
     * so that it can be accessed from any point in the application.
     */
    @Autowired
    private void setApplicationContext(ApplicationContext applicationContext) {
        ctx = applicationContext;
    }
}
