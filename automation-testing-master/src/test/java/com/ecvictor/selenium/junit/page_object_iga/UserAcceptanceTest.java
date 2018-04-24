package com.ecvictor.selenium.junit.page_object_iga;

import com.ecvictor.selenium.junit.page_object_iga.module.HomePageAction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

/* Created by caoc on 2/10/17.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */

public class UserAcceptanceTest extends BaseTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testCheckProduct() throws Exception {
        HomePageAction.checkPromotionChicken();
    }

    @Test
    public void testLoginFailed() throws Exception {
        driver.findElement(By.xpath("//A[@id='header_0_MobileAccountLink']")).click();
        assertEquals(driver.findElement(By.xpath("//H1[@class='push-medium--bottom']")).getText(), "LOGIN");
        driver.findElement(By.id("body_0_main_1_LoginBox_TxtEmail")).sendKeys("info@ecvictor.com");
        driver.findElement(By.id("body_0_main_1_LoginBox_TxtPassword")).sendKeys("ecvictor123");
        driver.findElement(By.id("body_0_main_1_LoginBox_BtnConnection")).click();
        assertEquals(driver.findElement(
                By.cssSelector("#body_0_main_1_LoginBox_ErrorSummaryControl > ul > li")).getText(),
                "Login unsuccessful : try another email address or another password.");
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }


}
