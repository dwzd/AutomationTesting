package com.ecvictor.selenium.junit.classic;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {
    public static void main(String[] args) {
        WebDriver driver;
        String baseUrl = "https://www.bing.com";
        DesiredCapabilities caps = DesiredCapabilities.edge();
        caps.setBrowserName("edge");
        caps.setPlatform(Platform.WIN10);
        driver = new EdgeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }
}
