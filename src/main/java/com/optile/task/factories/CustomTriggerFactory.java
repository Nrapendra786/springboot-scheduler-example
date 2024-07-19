package com.optile.task.factories;

import com.optile.task.utils.TriggerUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.util.Objects;

/**
 * Created by NrapendraKumar.
 */

@Configuration
@Slf4j
public class CustomTriggerFactory {

    @Autowired
    private CustomJobDetailFactory customJobDetailFactory;

    @Autowired
    private Environment environment;

    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryDataWareHouseBean() {
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        JobDetail dataWareHouseJobDetail = customJobDetailFactory.dataWareHouseJob().getObject();
        assert dataWareHouseJobDetail != null;
        simpleTriggerFactoryBean.setJobDetail(dataWareHouseJobDetail);
        simpleTriggerFactoryBean.setRepeatInterval(Long.parseLong(Objects.requireNonNull(environment.getProperty(TriggerUtil.DATA_WARE_HOUSE_SIMPLE_TRIGGER_REPEAT_INTERVAL))));
        return simpleTriggerFactoryBean;
    }

    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryEmailBean() {
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        JobDetail emailJobDetail = customJobDetailFactory.emailJob().getObject();
        assert emailJobDetail != null;
        simpleTriggerFactoryBean.setJobDetail(emailJobDetail);
        simpleTriggerFactoryBean.setRepeatInterval(Long.parseLong(Objects.requireNonNull(environment.getProperty(TriggerUtil.EMAIL_SIMPLE_TRIGGER_REPEAT_INTERVAL))));
        return simpleTriggerFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryEmailBean() {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(Objects.requireNonNull(customJobDetailFactory.emailJob().getObject()));
        cronTriggerFactoryBean.setStartDelay(Long.parseLong(Objects.requireNonNull(environment.getProperty(TriggerUtil.EMAIL_CRON_TRIGGER_START_DELAY))));
        cronTriggerFactoryBean.setName(Objects.requireNonNull(environment.getProperty(TriggerUtil.EMAIL_CRON_TRIGGER_NAME)));
        cronTriggerFactoryBean.setGroup(Objects.requireNonNull(environment.getProperty(TriggerUtil.EMAIL_CRON_TRIGGER_GROUP)));
        cronTriggerFactoryBean.setCronExpression(Objects.requireNonNull(environment.getProperty(TriggerUtil.EMAIL_CRON_TRIGGER_CRON_EXPRESSION)));
        cronTriggerFactoryBean.setPriority(Integer.parseInt(Objects.requireNonNull(environment.getProperty(TriggerUtil.EMAIL_CRON_TRIGGER_CRON_PRIORITY))));
        return cronTriggerFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryDataWareHouseBean() {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(Objects.requireNonNull(customJobDetailFactory.dataWareHouseJob().getObject()));
        cronTriggerFactoryBean.setStartDelay(Long.parseLong(Objects.requireNonNull(environment.getProperty(TriggerUtil.DATAWAREHOUSE_CRON_TRIGGER_START_DELAY))));
        cronTriggerFactoryBean.setName(Objects.requireNonNull(environment.getProperty(TriggerUtil.DATAWAREHOUSE_CRON_TRIGGER_NAME)));
        cronTriggerFactoryBean.setGroup(Objects.requireNonNull(environment.getProperty(TriggerUtil.DATAWAREHOUSE_CRON_TRIGGER_GROUP)));
        cronTriggerFactoryBean.setCronExpression(Objects.requireNonNull(environment.getProperty(TriggerUtil.DATAWAREHOUSE_CRON_TRIGGER_CRON_EXPRESSION)));
        cronTriggerFactoryBean.setPriority(Integer.parseInt(Objects.requireNonNull(environment.getProperty(TriggerUtil.DATAWAREHOUSE_CRON_TRIGGER_CRON_PRIORITY))));
        return cronTriggerFactoryBean;
    }
}
