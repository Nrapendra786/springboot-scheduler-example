package com.spring.quartz.tests;

import com.optile.task.utils.AppUtil;
import com.optile.task.utils.NumberUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by NrapendraKumar on 08-10-2016.
 */


public class EmailPropertyTest {

    private Map<String,String> propertyFileMap = null;

    private static final Logger logger = LoggerFactory.getLogger(EmailPropertyTest.class.getName());


    @Before
    public void initializePropertyFile() throws IOException {
        propertyFileMap = readPropertyFile();
    }

    @Test
    public void testPropertyFileSize() throws IOException {
        Assert.assertTrue(readPropertyFile().size() == 25);
    }

    @Test
    public void testEmailProperty() {
        Assert.assertTrue(propertyFileMap.get("email.from").equals("trivajay259@gmail.com"));
        Assert.assertTrue(propertyFileMap.get("email.to").equals("nrapendra.trivedi100@gmail.com,trivajay259@gmail.com"));
        Assert.assertTrue(propertyFileMap.get("email.subject").equals("Hello"));
        Assert.assertTrue(propertyFileMap.get("email.message").equals("I am from India and looking for the position of Java Developer"));
    }

    @Test
    public void testJdbcProperty() {
        Assert.assertTrue(propertyFileMap.get("spring.datasource.url").equals("jdbc:mysql://localhost/test?serverTimezone=UTC"));
        Assert.assertTrue(propertyFileMap.get("spring.datasource.username").equals("root"));
        Assert.assertTrue(propertyFileMap.get("spring.datasource.password").equals("nrapendra"));
        Assert.assertTrue(propertyFileMap.get("spring.datasource.driver-class-name").equals("com.mysql.jdbc.Driver"));
    }

    private Map<String,String> readPropertyFile() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(AppUtil.APPLICATION_PROPERTIES);
        LineIterator lineIterator = IOUtils.lineIterator(inputStream, AppUtil.UTF_8);
        Map<String,String> propertyFileMap = new HashMap<>();
        while(lineIterator.hasNext()){
            String line = lineIterator.nextLine();
            if(!line.isEmpty() && !line.startsWith(AppUtil.HASH)) {
                String[] lineStringArray = line.split(AppUtil.EQUAL,NumberUtil.TWO);
                propertyFileMap.put(lineStringArray[NumberUtil.ZERO],lineStringArray[NumberUtil.ONE]);
            }
        }
        return propertyFileMap;
    }
}
