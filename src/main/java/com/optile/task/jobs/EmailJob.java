package com.optile.task.jobs;

import com.optile.task.services.IScheduledJobService;
import com.optile.task.utils.AppUtil;
import lombok.extern.slf4j.Slf4j;
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
 * Created by NrapendraKumar.
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
@Slf4j
public class EmailJob extends QuartzJobBean {

    @Autowired
    @Qualifier(AppUtil.EMAIL)
    private IScheduledJobService iScheduledJobEmailService;

    protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
        log.info(this.getClass().getName());
        iScheduledJobEmailService.executeJob();
    }
}
