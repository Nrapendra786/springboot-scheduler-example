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
public class DataWareHouseJob extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(DataWareHouseJob.class.getName());

    @Autowired
    @Qualifier(AppUtil.DATA_WARE_HOUSE)
    IScheduledJobService iScheduledJobDataWareHouseService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info(this.getClass().getName());
        iScheduledJobDataWareHouseService.executeJob();
    }
}