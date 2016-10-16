package com.optile.task.factories;

import com.optile.task.jobs.DataWareHouseJob;
import com.optile.task.jobs.EmailJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

/**
 * Created by NrapendraKumar on 05-10-2016.
 */
@Configuration
public class CustomJobDetailFactory {

    private static final Logger logger = LoggerFactory.getLogger(CustomJobDetailFactory.class.getName());

    @Bean
    public JobDetailFactoryBean emailJob() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(EmailJob.class);
        return jobDetailFactoryBean;
    }

    @Bean
    public JobDetailFactoryBean dataWareHouseJob() {
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setJobClass(DataWareHouseJob.class);
        return factory;
    }
}
