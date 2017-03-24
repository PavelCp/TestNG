package com.testng;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AppTest extends TestFixture
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
    @Test (groups = {"negative", "g1"})
    @Parameters ({"invalidUser, invalidPass"})
    public void bothNeg(String invalidUser, String invalidPass) throws InterruptedException {
        driver.get("http://newtours.demoaut.com/");
        driver.findElement(By.xpath("//*[@name='userName']")).sendKeys(invalidUser);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(invalidPass);
        driver.findElement(By.xpath("//*[@name='login']")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "Sign-on: Mercury Tours");
    }

    //negative test case
    @Test (groups = {"negative", "g1"})
    @Parameters ({"invalidUser, invalidPass"})
    public void userNeg(String invalidUser, String validPass) throws InterruptedException {
        driver.get("http://newtours.demoaut.com/");
        driver.findElement(By.xpath("//*[@name='userName']")).sendKeys(invalidUser);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(validPass);
        driver.findElement(By.xpath("//*[@name='login']")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "Sign-on: Mercury Tours");
    }

    //negative test case
    @Test (groups = {"negative", "g1"})
    @Parameters ({"validUser, invalidPass"})
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

    @Test (groups = {"positive"})
    public void login(String validUser, String validPass) throws InterruptedException {
        driver.get("http://newtours.demoaut.com/");
        driver.findElement(By.xpath("//*[@name='userName']")).sendKeys(validUser);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(validPass);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@name='home']//td[1]/img")).isDisplayed(), true);
        driver.findElement(By.xpath("//*[@name='login']")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "Sign-on: Mercury Tours");
    }

}