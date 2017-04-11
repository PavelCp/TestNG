package com.dataprovider;


import com.testng.TestFixtureMint;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Test
public class AppTest extends TestFixtureMint
{



    @Test (groups = {"positive", "g1"})
    public void AppTest()
    {
        System.out.println("Test1 run");
    }

    @Test (groups = {"init", "g1"})
    public void _startSite() {
        driver.get("http://newtours.demoaut.com/");
        System.out.println("Current page title - " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
    }


    //negative test case
    @Test (groups = {"negative", "g1"},
            dataProvider = "dUsers")
    public void bothNeg(String invalidUser, String invalidPass) throws InterruptedException {
        driver.get("http://newtours.demoaut.com/");
        driver.findElement(By.xpath("//*[@name='userName']")).sendKeys(invalidUser);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(invalidPass);
        driver.findElement(By.xpath("//*[@name='login']")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "Sign-on: Mercury Tours");
    }

    //negative test case
//    @Test (groups = {"negative", "g1"})

//    public void userNeg(String invalidUser, String validPass) throws InterruptedException {
//        driver.get("http://newtours.demoaut.com/");
//        driver.findElement(By.xpath("//*[@name='userName']")).sendKeys(invalidUser);
//        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(validPass);
//        driver.findElement(By.xpath("//*[@name='login']")).click();
//        Thread.sleep(5000);
//        Assert.assertEquals(driver.getTitle(), "Sign-on: Mercury Tours");
//    }

    //negative test case
    @Test (groups = {"negative", "g1"},
            dataProvider = "users")

    public void passNeg(String validUser, String invalidPass) throws InterruptedException {
        driver.get("http://newtours.demoaut.com/");
        driver.findElement(By.xpath("//*[@name='userName']")).sendKeys(validUser);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@name='home']//tr[2]/td[1]//font")).getText(),
                "User Name:");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(invalidPass);
        driver.findElement(By.xpath("//*[@name='login']")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "Sign-on: Mercury Tours");
    }

    @Test (groups = {"positive"},
            dataProviderClass = POI.class,
            dataProvider = "getData")

    public void login(String validUser, String validPass) throws InterruptedException {
        driver.get("http://newtours.demoaut.com/");
        driver.findElement(By.xpath("//*[@name='userName']")).sendKeys(validUser);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(validPass);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@name='home']//td[1]/img")).isDisplayed(), true);
        driver.findElement(By.xpath("//*[@name='login']")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "Sign-on: Mercury Tours");
    }

    @DataProvider
    public Iterator<Object[]> users(){
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"test", "test"});
        data.add(new Object[]{"test123", "test123"});

        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dUsers(){
        List<Object[]> data = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            data.add(new Object[]{"test" + i, "test" + i});
        }
        return data.iterator();
    }
}