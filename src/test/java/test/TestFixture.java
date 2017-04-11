package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * Created by November on 15.03.2017.
 */
public class TestFixture {

    protected static WebDriver driver;

//    @BeforeClass (groups = "g1", alwaysRun = true)
//    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional String browser) {

        if (browser.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver","D:\\GeckoDriver");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            // Set Path for the executable file
//            System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver");
            driver = new ChromeDriver();}
//        } else if (browser.equalsIgnoreCase("ie")) {
//            // Set Path for the executable file
//            System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
//            driver = new InternetExplorerDriver();
//        } else {
//            throw new IllegalArgumentException("The Browser Type is Undefined");
//        }


        /*
        switch(browser){
            case "firefox":{
//                System.setProperty("webdriver.gecko.driver","D:\\GeckoDriver");
                driver = new FirefoxDriver();}
                break;
            case "chrome":{
//                System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver");
                driver = new ChromeDriver();}
                break;
//            case "ie":
//                driver = new InternetExplorerDriver();
//                break;
//            case "opera":
//                driver = new OperaDriver();
//                break;
            default: throw new Error("Unrecognized browser - " + browser);
        }
*/
        else if (browser.equals(null))
            driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

//    @AfterClass (groups = "g1", alwaysRun = true)
//    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}