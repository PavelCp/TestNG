package com.dataprovider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by November on 15.03.2017.
 */
public class TestFixture {

        protected static WebDriver driver;

        @BeforeClass(groups = "g1", alwaysRun = true)
//    @BeforeTest
//    @Parameters("browser")
        public void setUp() {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }

        @AfterClass(groups = "g1", alwaysRun = true)
//    @AfterTest
        public void tearDown(){
            driver.close();
            driver.quit();
        }
    }