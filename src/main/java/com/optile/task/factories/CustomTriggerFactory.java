package com.optile.task.factories;

import com.optile.task.utils.TriggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

/**
 * Created by NrapendraKumar on 08-10-2016.
 */

@Configuration
public class CustomTriggerFactory {

    private static final Logger logger = LoggerFactory.getLogger(CustomTriggerFactory.class.getName());

    @Autowired
    private CustomJobDetailFactory customJobDetailFactory;

    @Autowired
    private Environment environment;

//    @Bean
//    public SimpleTriggerFactoryBean simpleTriggerFactoryDataWareHouseBean() {
//        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
//        JobDetail dataWareHouseJobDetail = customJobDetailFactory.dataWareHouseJob().getObject();
//        simpleTriggerFactoryBean.setJobDetail(dataWareHouseJobDetail);
//        simpleTriggerFactoryBean.setRepeatInterval(Long.parseLong(environment.getProperty(TriggerUtil.DATA_WARE_HOUSE_SIMPLE_TRIGGER_REPEAT_INTERVAL)));
//        return simpleTriggerFactoryBean;
//    }
//
//    @Bean
//    public SimpleTriggerFactoryBean simpleTriggerFactoryEmailBean() {
//        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
//        JobDetail emailJobDetail = customJobDetailFactory.emailJob().getObject();
//        simpleTriggerFactoryBean.setJobDetail(emailJobDetail);
//        simpleTriggerFactoryBean.setRepeatInterval(Long.parseLong(environment.getProperty(TriggerUtil.EMAIL_SIMPLE_TRIGGER_REPEAT_INTERVAL)));
//        return simpleTriggerFactoryBean;
//    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryEmailBean() {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(customJobDetailFactory.emailJob().getObject());
        cronTriggerFactoryBean.setStartDelay(Long.parseLong(environment.getProperty(TriggerUtil.EMAIL_CRON_TRIGGER_START_DELAY)));
        cronTriggerFactoryBean.setName(environment.getProperty(TriggerUtil.EMAIL_CRON_TRIGGER_NAME));
        cronTriggerFactoryBean.setGroup(environment.getProperty(TriggerUtil.EMAIL_CRON_TRIGGER_GROUP));
        cronTriggerFactoryBean.setCronExpression(environment.getProperty(TriggerUtil.EMAIL_CRON_TRIGGER_CRON_EXPRESSION));
        cronTriggerFactoryBean.setPriority(Integer.parseInt(environment.getProperty(TriggerUtil.EMAIL_CRON_TRIGGER_CRON_PRIORITY)));
        return cronTriggerFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryDataWareHouseBean() {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(customJobDetailFactory.dataWareHouseJob().getObject());
        cronTriggerFactoryBean.setStartDelay(Long.parseLong(environment.getProperty(TriggerUtil.DATAWAREHOUSE_CRON_TRIGGER_START_DELAY)));
        cronTriggerFactoryBean.setName(environment.getProperty(TriggerUtil.DATAWAREHOUSE_CRON_TRIGGER_NAME));
        cronTriggerFactoryBean.setGroup(environment.getProperty(TriggerUtil.DATAWAREHOUSE_CRON_TRIGGER_GROUP));
        cronTriggerFactoryBean.setCronExpression(environment.getProperty(TriggerUtil.DATAWAREHOUSE_CRON_TRIGGER_CRON_EXPRESSION));
        cronTriggerFactoryBean.setPriority(Integer.parseInt(environment.getProperty(TriggerUtil.DATAWAREHOUSE_CRON_TRIGGER_CRON_PRIORITY)));
        return cronTriggerFactoryBean;
    }
}
