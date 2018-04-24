package com.ecvictor.selenium.junit.page_object_iga;

import com.ecvictor.selenium.junit.page_object_iga.module.BaseAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.fail;

public class BaseTest extends BaseAction{
    public String baseUrl;

    public void setUp() throws Exception {
        baseUrl = "https://www.iga.net";
        driver.get(baseUrl);
    }

    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
        StringBuffer verificationErrors = new StringBuffer();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
