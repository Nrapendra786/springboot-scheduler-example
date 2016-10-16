package com.optile.task.jobs;

import com.optile.task.services.IScheduledJobService;
import com.optile.task.utils.AppUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by NrapendraKumar on 02-10-2016.
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class EmailJob extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(EmailJob.class.getName());

    @Autowired
    @Qualifier(AppUtil.EMAIL)
    private IScheduledJobService iScheduledJobEmailService;


    protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
        logger.info(this.getClass().getName());
        iScheduledJobEmailService.executeJob();
    }
}
