package com.ecvictor.selenium.junit.page_object_iga.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    @FindBy(how= How.XPATH, using="//a[@id='header_0_MobileAccountLink']")
    public static WebElement myAccount;

    public final static String promotionChicken = "//a[@title=\"Fresh Chicken Drumstick\"]";
}
