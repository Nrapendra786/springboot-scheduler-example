package com.optile.task.configs;

import com.optile.task.factories.AutoWiringSpringBeanJobFactory;
import com.optile.task.factories.CustomJobDetailFactory;
import com.optile.task.factories.CustomTriggerFactory;
import com.optile.task.listeners.SchedulerGlobalJobListener;
import com.optile.task.utils.AppUtil;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

//import com.spring.quartz.example.jobs.IndexJob;

/**
 * Created by NrapendraKumar on 02-10-2016.
 */
@Configuration
@ComponentScan({AppUtil.JOB_PACKAGE_NAME,AppUtil.FACTORY_PACKAGE_NAME})
public class QuartzConfiguration {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private CustomJobDetailFactory customJobDetailFactory;

    @Autowired
    private CustomTriggerFactory customTriggerFactory;


    @Bean
    public AutoWiringSpringBeanJobFactory autoWiringSpringBeanJobFactory(){
        return new AutoWiringSpringBeanJobFactory();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws SchedulerException, IOException {

        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();

        CronTriggerFactoryBean cronTriggerFactoryDataWareHouseBean = customTriggerFactory.cronTriggerFactoryDataWareHouseBean();

        CronTriggerFactoryBean cronTriggerFactoryEmailBean = customTriggerFactory.cronTriggerFactoryEmailBean();

        schedulerFactoryBean.setTriggers(cronTriggerFactoryDataWareHouseBean.getObject(),cronTriggerFactoryEmailBean.getObject());

        schedulerFactoryBean.setJobFactory(autoWiringSpringBeanJobFactory());

        schedulerFactoryBean.setQuartzProperties(quartzProperties());

        schedulerFactoryBean.setGlobalJobListeners(new SchedulerGlobalJobListener());

        schedulerFactoryBean.setDataSource(dataSource);

        return schedulerFactoryBean;
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource(AppUtil.QUARTZ_PROPERTIES));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }
}
