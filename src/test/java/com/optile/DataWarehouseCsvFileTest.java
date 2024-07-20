package com.optile;

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
 * Created by NrapendraKumar.
 */

public class DataWarehouseCsvFileTest {


    private List<DataWareHouseModelTest> dataWareHouseModelFileData;
    private List<DataWareHouseModelTest> dataWareHouseModelTestData;
    private List<DataWareHouseModelTest> dataWareHouseModelTestIncorrectData;


    @Before
    public void initializeList(){
        dataWareHouseModelFileData = dataWareHouseFileData();
        dataWareHouseModelTestData = getCorrectDataWareHouseList();
        dataWareHouseModelTestIncorrectData = getInCorrectDataWareHouseList();
    }

    @Test
    public void testPassDataWareHouseData() throws IOException {
        Assert.assertEquals(dataWareHouseModelFileData.size(), dataWareHouseModelTestData.size());
        for(int iForloop = NumberUtil.ZERO ; iForloop < dataWareHouseModelTestData.size() ; iForloop++) {
            DataWareHouseModelTest dataWareHouseModelFileDataTest = dataWareHouseModelFileData.get(iForloop);
            DataWareHouseModelTest dataWareHouseModelTest = dataWareHouseModelTestData.get(iForloop);

            Assert.assertEquals(dataWareHouseModelFileDataTest.getUserName(), dataWareHouseModelTest.getUserName());
            Assert.assertEquals(dataWareHouseModelFileDataTest.getLastName(), dataWareHouseModelTest.getLastName());
            Assert.assertEquals(dataWareHouseModelFileDataTest.getAge(), dataWareHouseModelTest.getAge());
        }
    }

    @Test
    public void testFailDataWareHouseData() throws IOException {
        Assert.assertNotEquals(dataWareHouseModelFileData.size(), dataWareHouseModelTestIncorrectData.size() + 1);

        for(int iForloop = NumberUtil.ZERO ; iForloop < dataWareHouseModelTestIncorrectData.size() ; iForloop++) {

            DataWareHouseModelTest dataWareHouseModelFileDataTest = dataWareHouseModelFileData.get(iForloop);
            DataWareHouseModelTest dataWareHouseModelTestFail = dataWareHouseModelTestIncorrectData.get(iForloop);

            Assert.assertNotEquals(dataWareHouseModelFileDataTest.getUserName(), dataWareHouseModelTestFail.getUserName());
            Assert.assertNotEquals(dataWareHouseModelFileDataTest.getLastName(), dataWareHouseModelTestFail.getLastName());
            Assert.assertNotEquals(dataWareHouseModelFileDataTest.getAge(), dataWareHouseModelTestFail.getAge());
        }
    }

    private List<DataWareHouseModelTest> dataWareHouseFileData() {
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

    private List<DataWareHouseModelTest> getCorrectDataWareHouseList() {
        List<DataWareHouseModelTest> dataWareHouseModelTests = new ArrayList<>();
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Jill", "Billy", 24));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Joe", "Laufer", 34));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Justin", "Mamber", 21));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Jane", "Kane", 67));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("John", "Doel", 39));
        return dataWareHouseModelTests;
    }

    private List<DataWareHouseModelTest> getInCorrectDataWareHouseList() {
        List<DataWareHouseModelTest> dataWareHouseModelTests = new ArrayList<>();
        dataWareHouseModelTests.add(new DataWareHouseModelTest("JillPing", "Billy1", 27));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Joe1", "Laufer1", 39));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Justin1", "Mambers1", 19));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("Jane1", "Kaney1", 87));
        dataWareHouseModelTests.add(new DataWareHouseModelTest("John1", "Doelm1", 43));
        return dataWareHouseModelTests;
    }


    @Data
    private static class DataWareHouseModelTest {
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
