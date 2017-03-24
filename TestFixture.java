package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Created by November on 15.03.2017.
 */
public class TestFixture {

    protected static WebDriver driver;

//    @BeforeClass (groups = "g1", alwaysRun = true)
    @BeforeTest
    @Parameters ("browser")
    public void setUp(String browser){
        switch(browser){
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
//            case "ie":
//                driver = new InternetExplorerDriver();
//                break;
//            case "opera":
//                driver = new OperaDriver();
//                break;
            default: throw new Error("Unrecognized browser - " + browser);
        }

         driver.manage().window().maximize();
    }

//    @AfterClass (groups = "g1", alwaysRun = true)
    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
