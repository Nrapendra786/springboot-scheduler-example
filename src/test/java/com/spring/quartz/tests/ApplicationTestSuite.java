package com.spring.quartz.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by NrapendraKumar on 08-10-2016.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DataWarehouseCsvFileTest.class,
        EmailPropertyTest.class
})
public class ApplicationTestSuite {
}
