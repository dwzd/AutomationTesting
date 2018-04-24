package com.ecvictor.selenium.junit.classic; /**
 * Created by caoc on 2/10/17.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class JusteatTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //chose driver type
        String os = (System.getProperty("os.name"));

        if (os.equalsIgnoreCase("Mac OS X"))
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        else System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");

        driver = new ChromeDriver(chromeOptions);

        baseUrl = "https://www.just-eat.ca";

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSearchH3A() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("homepage-search-fullAddress")).clear();
        driver.findElement(By.id("homepage-search-fullAddress")).sendKeys("");
        driver.findElement(By.id("homepage-search-fullAddress")).clear();
        driver.findElement(By.id("homepage-search-fullAddress")).sendKeys("Service ECVictor Inc., Sherbrooke Street West, Montreal, QC, Canada");
        driver.findElement(By.cssSelector("/html/body/section/div[2]/div/div/div[1]/ul/li[1]")).click();
        assertEquals("Zanga Sushi", driver.findElement(By.cssSelector("h3.listing-item-title")).getText());
         }
    @Test
    public void testPizzaDelivery() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[@href='/account/login/?returnurl=%2F']")).click();
        assertEquals("Login with",
                driver.findElement(By.xpath("//h1[@class='beta form-title']")).getText());
    }

    @Test
    public void testCareer() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Career Opportunities")).click();

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
