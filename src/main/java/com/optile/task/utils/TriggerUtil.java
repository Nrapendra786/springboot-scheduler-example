package com.optile.task.utils;

/**
 * Created by NrapendraKumar
 */
public class TriggerUtil {

    public static final String CRON_TRIGGER = "cronTrigger";
    public static final String SIMPLE_TRIGGER = "simpleTrigger";
    public static final String START_DELAY = "startDelay";
    public static final String NAME = "name";
    public static final String GROUP = "group";
    public static final String CRON_EXPRESSION = "cronExpression";
    public static final String PRIORITY = "priority";
    public static final String REPEAT_INTERVAL = "repeat.interval";


    public static final String EMAIL_CRON_TRIGGER_START_DELAY = AppUtil.EMAIL + AppUtil.DOT + CRON_TRIGGER + AppUtil.DOT + START_DELAY;
    public static final String EMAIL_CRON_TRIGGER_NAME = AppUtil.EMAIL + AppUtil.DOT + CRON_TRIGGER + AppUtil.DOT + NAME;
    public static final String EMAIL_CRON_TRIGGER_GROUP = AppUtil.EMAIL + AppUtil.DOT + CRON_TRIGGER + AppUtil.DOT + GROUP;
    public static final String EMAIL_CRON_TRIGGER_CRON_EXPRESSION = AppUtil.EMAIL + AppUtil.DOT + CRON_TRIGGER + AppUtil.DOT + CRON_EXPRESSION;
    public static final String EMAIL_CRON_TRIGGER_CRON_PRIORITY = AppUtil.EMAIL + AppUtil.DOT + CRON_TRIGGER + AppUtil.DOT + PRIORITY;

    public static final String DATAWAREHOUSE_CRON_TRIGGER_START_DELAY = AppUtil.DATA_WARE_HOUSE + AppUtil.DOT + CRON_TRIGGER + AppUtil.DOT + START_DELAY;
    public static final String DATAWAREHOUSE_CRON_TRIGGER_NAME = AppUtil.DATA_WARE_HOUSE + AppUtil.DOT + CRON_TRIGGER + AppUtil.DOT + NAME;
    public static final String DATAWAREHOUSE_CRON_TRIGGER_GROUP = AppUtil.DATA_WARE_HOUSE + AppUtil.DOT + CRON_TRIGGER + AppUtil.DOT + GROUP;
    public static final String DATAWAREHOUSE_CRON_TRIGGER_CRON_EXPRESSION = AppUtil.DATA_WARE_HOUSE + AppUtil.DOT + CRON_TRIGGER + AppUtil.DOT + CRON_EXPRESSION;
    public static final String DATAWAREHOUSE_CRON_TRIGGER_CRON_PRIORITY = AppUtil.DATA_WARE_HOUSE + AppUtil.DOT + CRON_TRIGGER + AppUtil.DOT + PRIORITY;

    public static final String EMAIL_SIMPLE_TRIGGER_REPEAT_INTERVAL = AppUtil.EMAIL + AppUtil.DOT + SIMPLE_TRIGGER + AppUtil.DOT + REPEAT_INTERVAL;
    public static final String DATA_WARE_HOUSE_SIMPLE_TRIGGER_REPEAT_INTERVAL = AppUtil.DATA_WARE_HOUSE + AppUtil.DOT + SIMPLE_TRIGGER + AppUtil.DOT + REPEAT_INTERVAL;
}
