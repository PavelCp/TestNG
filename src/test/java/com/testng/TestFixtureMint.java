package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by November on 15.03.2017.
 */
public class TestFixtureMint {

    protected static WebDriver driver;

    @BeforeClass(groups = "g1", alwaysRun = true)
//    @BeforeTest
//    @Parameters("browser")
    public void setUp() {
            driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void refreshMethod(Method m){
//        driver.manage().logs().get("driver");
        System.out.println("method " + m.getName());
        if ((m.getAnnotation(NeedFreshDriver.class)) != null){
            System.out.println("was asked fresh browser instance");
            driver.close();
            driver.quit();
            driver = new FirefoxDriver();
        }
    }

    @BeforeMethod
    public void skippedMethod(Method m){
//        driver.manage().logs().get("driver");
        System.out.println("method " + m.getName());
        SkippedIn ignore = m.getAnnotation(SkippedIn.class);
        if (ignore != null){
            String browser = ((RemoteWebDriver)driver).getCapabilities().getBrowserName();
            DriverType[] skipped = ignore.value();
            for (DriverType skip :
                    skipped) {
                if (skip.getName().equals(browser))
                    throw new SkipException("was asked skip in browser " + browser);
            }
        }
    }

    @AfterMethod
    public void getResult(ITestResult testResult){
        if (!testResult.isSuccess()){
            System.out.println("Test failed \ngetting screenshot "
                    + testResult.getName());
        }
    }

//    @AfterMethod
    public void getLog(Method m) throws IOException{
        LogEntries logEntries = driver.manage().logs().get("driver");
        File driverLog = new File(m.getName() + ".log");
        FileWriter out = new FileWriter(driverLog);
        for (LogEntry logEntry :
             logEntries.getAll()) {
            out.write(logEntries.toString() + "\n");
        }
    }

    @AfterClass(groups = "g1", alwaysRun = true)
//    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}