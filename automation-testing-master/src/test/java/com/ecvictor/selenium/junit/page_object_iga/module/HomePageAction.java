package com.ecvictor.selenium.junit.page_object_iga.module;

import com.ecvictor.selenium.junit.page_object_iga.page_object.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.ecvictor.selenium.junit.page_object_iga.page_object.HomePage.myAccount;
import static org.junit.Assert.assertEquals;

 public  class  HomePageAction extends BaseAction {

    public static void clickMyAccount() {
        myAccount.click();
        assertEquals(driver.findElement(By.xpath("//H1[@class='push-medium--bottom']")).getText(), "LOGIN");
    }

    public static void checkPromotionChicken() {
        driver.findElement(By.xpath(HomePage.promotionChicken)).click();
        assertEquals(driver.findElement(
                By.cssSelector("h1.h3-like.product-detail__name > span")).getText(),
                "Chicken Drumstick");
    }
}
