package com.optile.task.services;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;
import com.optile.task.exceptions.ScheduledJobException;
import com.optile.task.models.EmailProperty;
import com.optile.task.utils.AppUtil;
import com.optile.task.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by NrapendraKumar.
 */

@Service
@Qualifier(AppUtil.EMAIL)
@Slf4j
public class EmailScheduledJobServiceImpl implements IScheduledJobService {

    @Autowired
    private EmailProperty emailProperty;

    @Override
    public void executeJob() {
        SendGrid sendgrid = new SendGrid(emailProperty.getSendApiKey());
        SendGrid.Email email = new SendGrid.Email();
        String []emailIds = getEmailIds(emailProperty.getTo()).toArray(new String[0]);
        email.addTo(emailIds);
        email.setFrom(emailProperty.getFrom());
        email.setSubject(emailProperty.getSubject());
        email.setHtml(emailProperty.getMessage());
        try {
             sendgrid.send(email);
        } catch (SendGridException e) {
            throw new ScheduledJobException(e.getMessage(),e.getCause());
        }
    }

    private Set<String> getEmailIds(String emailIds){
        Set<String> emailIdSet = new HashSet<>();
        if (!emailIds.contains(AppUtil.COMMA)) {
            emailIdSet.add(emailIds);
        } else {
            emailIdSet.addAll(Arrays.asList(emailIds.split(AppUtil.COMMA)));
        }
        return emailIdSet;
    }
}
