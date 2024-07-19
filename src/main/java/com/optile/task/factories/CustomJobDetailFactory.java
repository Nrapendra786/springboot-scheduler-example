package com.optile.task.factories;

import com.optile.task.jobs.DataWareHouseJob;
import com.optile.task.jobs.EmailJob;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

/**
 * Created by NrapendraKumar
 */
@Configuration
@Slf4j
public class CustomJobDetailFactory {

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
