package com.optile;

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
 * Created by NrapendraKumar.
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
        Assert.assertEquals(25, readPropertyFile().size());
    }

    @Test
    public void testEmailProperty() {
        Assert.assertEquals("trivajay259@gmail.com", propertyFileMap.get("email.from"));
        Assert.assertEquals("nrapendra.trivedi100@gmail.com,trivajay259@gmail.com", propertyFileMap.get("email.to"));
        Assert.assertEquals("Hello", propertyFileMap.get("email.subject"));
        Assert.assertEquals("I am from India and looking for the position of Java Software Engineer", propertyFileMap.get("email.message"));
    }

    @Test
    public void testJdbcProperty() {
        Assert.assertEquals("jdbc:mysql://host.docker.internal:3306/test_db?createDatabaseIfNotExist=true&serverTimezone=UTC", propertyFileMap.get("spring.datasource.url"));
        Assert.assertEquals("${MYSQL_USER}", propertyFileMap.get("spring.datasource.username"));
        Assert.assertEquals("${MYSQL_PASSWORD}", propertyFileMap.get("spring.datasource.password"));
        Assert.assertEquals("com.mysql.jdbc.Driver", propertyFileMap.get("spring.datasource.driver-class-name"));
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
