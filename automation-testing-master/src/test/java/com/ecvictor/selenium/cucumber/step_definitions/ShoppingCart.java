package com.ecvictor.selenium.cucumber.step_definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ecvictor.selenium.cucumber.modules.SignInAction;
import com.ecvictor.selenium.cucumber.modules.SignoutAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.ecvictor.selenium.cucumber.pageobjects.AutomationHomePage;
import com.ecvictor.selenium.cucumber.pageobjects.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ShoppingCart {
    public WebDriver driver;
    //    public List<HashMap<String,String>> datamap = DataHelper.data();
    public static List<HashMap<String, String>> datamap = null;


    public ShoppingCart() {
        driver = Hooks.driver;
        datamap = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> sampleData = new HashMap<String, String>();
        sampleData.put("username", "abc@xyz.com");
        sampleData.put("password", "Test@123");
        System.out.println("Current data" + sampleData);
        datamap.add(sampleData);
    }

    @When("^I open automationpractice website$")
    public void i_open_automationpractice_website() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://automationpractice.com");
    }

    @When("^I sign in$")
    public void i_sign_in() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.initElements(driver, AutomationHomePage.class);
        PageFactory.initElements(driver, LoginPage.class);

        SignInAction.Execute(driver, datamap.get(0));
    }

    @Then("^Sign out failed due to wrong username password$")
    public void i_validate_failed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        SignInAction.validateSigninFailed(driver);
    }

}