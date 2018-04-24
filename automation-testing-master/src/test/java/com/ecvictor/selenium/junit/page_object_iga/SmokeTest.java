package com.ecvictor.selenium.junit.page_object_iga;

import com.ecvictor.selenium.junit.page_object_design.page_object.homePage.HomePage;
import com.ecvictor.selenium.junit.page_object_iga.module.HomePageAction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
/* Created by caoc on 2/10/17.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */

public class SmokeTest extends BaseTest {
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testOpenHomePage() throws Exception {

        assertEquals(driver.getTitle(), "IGA | Supermarket in Quebec: Recipes, Online Grocery, Flyer");

    }

    @Test
    public void testMyAccount() throws Exception {
        //Given IGA homepage
        //When I click My account
        //Then the login page is up
         HomePageAction.clickMyAccount();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

}
