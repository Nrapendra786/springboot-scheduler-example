package com.optile;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by NrapendraKumar.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DataWarehouseCsvFileTest.class,
        EmailPropertyTest.class
})
public class ApplicationTestSuite {
}
