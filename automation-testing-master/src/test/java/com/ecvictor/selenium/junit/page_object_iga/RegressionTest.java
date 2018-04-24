package com.ecvictor.selenium.junit.page_object_iga;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertEquals;

/* Created by caoc on 2/10/17.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */

public class RegressionTest extends BaseTest {



    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testSearchWine() throws Exception {
        driver.findElement(By.id("header_0_SearchBox_SearchWithinLink")).click();
        driver.findElement(By.xpath("//div[@id='search-box']/div/ul/li[2]/label")).click();
        driver.findElement(By.id("header_0_SearchBox_TxtSearchKeywords")).sendKeys("wine");
        driver.findElement(By.id("header_0_SearchBox_TxtSearchKeywords")).sendKeys(Keys.ENTER);
        assertEquals(driver.findElement(
                By.id("body_0_main_1_GrocerySearch_TemplateResult_SearchResultListView_ctrl0_ctl00_0_NavigateTo_0")).getText(),
                "Spanish White Bottle...");
    }

    @Test
    public void testSearchRecipes() throws Exception {
        driver.findElement(By.id("header_0_SearchBox_SearchWithinLink")).click();
        driver.findElement(By.xpath("//div[@id='search-box']/div/ul/li[3]/label")).click();
        driver.findElement(By.id("header_0_SearchBox_TxtSearchKeywords")).sendKeys("wine");
        driver.findElement(By.id("header_0_SearchBox_TxtSearchKeywords")).sendKeys(Keys.ENTER);
        assertEquals(driver.findElement(
                By.id("body_0_main_1_SiteContentSearch_TemplateResult_SearchResultListView_ctrl0_ctl00_0_RecipeItemTemplate_0_TitleLink_0")).getText(),
                "Mulled Wine");
    }

    @After
    public void tearDown() throws Exception {
    super.tearDown();
    }
}
