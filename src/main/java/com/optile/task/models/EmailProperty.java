package com.optile.task.models;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class EmailProperty {

    @Value("${sendgrid.api.key}")
    private String sendApiKey;

    @Value("${email.from}")
    private String from;

    @Value("${email.to}")
    private String to;

    @Value("${email.subject}")
    private String subject;

    @Value("${email.message}")
    private String message;
}
