package com.spring.quartz.tests;

import com.optile.task.exceptions.ScheduledJobException;
import com.optile.task.utils.AppUtil;
import com.optile.task.utils.NumberUtil;
import lombok.Data;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NrapendraKumar on 03-10-2016.
 */

public class DataWarehouseCsvFileTest {


    private List<DataWareHouseModelTest> dataWareHouseModelFileData = null;
    private List<DataWareHouseModelTest> dataWareHouseModelTestData = null;
    private List<DataWareHouseModelTest> dataWareHouseModelTestIncorrectData = null;


    @Before
    public void initializeList(){
        dataWareHouseModelFileData = datawareHouseFileData();
        dataWareHouseModelTestData = getCorrectDataWareHouseList();
        dataWareHouseModelTestIncorrectData = getInCorrectDataWareHouseList();
    }

    @Test
    public void testPassDataWareHouseData() throws IOException {
         Assert.assertTrue(dataWareHouseModelFileData.size() == dataWareHouseModelTestData.size());
        for(int iForloop = NumberUtil.ZERO ; iForloop < dataWareHouseModelTestData.size() ; iForloop++) {
            DataWareHouseModelTest dataWareHouseModelFileDataTest = dataWareHouseModelFileData.get(iForloop);
            DataWareHouseModelTest dataWareHouseModelTest = dataWareHouseModelTestData.get(iForloop);

            Assert.assertTrue(dataWareHouseModelFileDataTest.getUserName().equals(dataWareHouseModelTest.getUserName()));
            Assert.assertTrue(dataWareHouseModelFileDataTest.getLastName().equals(dataWareHouseModelTest.getLastName()));
            Assert.assertTrue(dataWareHouseModelFileDataTest.getAge() == dataWareHouseModelTest.getAge());
        }
    }

    @Test
    public void testFailDataWareHouseData() throws IOException {
        Assert.assertFalse(dataWareHouseModelFileData.size() == dataWareHouseModelTestIncorrectData.size() + 1);

        for(int iForloop = NumberUtil.ZERO ; iForloop < dataWareHouseModelTestIncorrectData.size() ; iForloop++) {

            DataWareHouseModelTest dataWareHouseModelFileDataTest = dataWareHouseModelFileData.get(iForloop);
            DataWareHouseModelTest dataWareHouseModelTestFail = dataWareHouseModelTestIncorrectData.get(iForloop);

            Assert.assertFalse(dataWareHouseModelFileDataTest.getUserName().equals(dataWareHouseModelTestFail.getUserName()));
            Assert.assertFalse(dataWareHouseModelFileDataTest.getLastName().equals(dataWareHouseModelTestFail.getLastName()));
            Assert.assertFalse(dataWareHouseModelFileDataTest.getAge() == dataWareHouseModelTestFail.getAge());
        }
    }

    public List<DataWareHouseModelTest> datawareHouseFileData() {
        InputStream inputStream = getClass().getResourceAsStream(AppUtil.DATA_WARE_HOUSE_CSV_FILE);
        List<DataWareHouseModelTest> dataWareHouseModelTests = new ArrayList<>();
        try {
            LineIterator lineIterator = IOUtils.lineIterator(inputStream, AppUtil.UTF_8);
            while (lineIterator.hasNext()) {
                String line = lineIterator.nextLine();
                String[] elements = line.split(AppUtil.COMMA);
                DataWareHouseModelTest dataWareHouse = new DataWareHouseModelTest(elements[NumberUtil.ZERO],
                        elements[NumberUtil.ONE],
                        Integer.parseInt(elements[NumberUtil.TWO]));
                dataWareHouseModelTests.add(dataWareHouse);
            }
        } catch (IOException e) {
            throw new ScheduledJobException(e.getMessage(), e.getCause());
        }
        return dataWareHouseModelTests;
    }

    public List<DataWareHouseModelTest> getCorrectDataWareHouseList() {
        List<DataWareHouseModelTest> dataWareHouseModelTests = new ArrayList<>();
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Jill", "Billy", 24));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Joe", "Laufer", 34));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Justin", "Mamber", 21));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Jane", "Kane", 67));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("John", "Doel", 39));
        return dataWareHouseModelTests;
    }

    public List<DataWareHouseModelTest> getInCorrectDataWareHouseList() {
        List<DataWareHouseModelTest> dataWareHouseModelTests = new ArrayList<>();
        dataWareHouseModelTests.add(new DataWareHouseModelTest("JillPing", "Billy1", 27));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Joe1", "Laufer1", 39));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Justin1", "Mambers1", 19));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Jane1", "Kaney1", 87));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("John1", "Doelm1", 43));
        return dataWareHouseModelTests;
    }


    @Data
    private class DataWareHouseModelTest {
        private String userName;
        private String lastName;
        private int age;

        public DataWareHouseModelTest(String userName, String lastName, int age) {
            this.userName = userName;
            this.lastName = lastName;
            this.age = age;
        }
    }

}
