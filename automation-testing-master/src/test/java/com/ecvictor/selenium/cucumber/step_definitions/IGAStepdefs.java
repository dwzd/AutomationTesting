package com.ecvictor.selenium.cucumber.step_definitions;

import com.ecvictor.selenium.cucumber.modules.IGASignInAction;
import com.ecvictor.selenium.cucumber.pageobjects.IGALoginPage;
import cucumber.api.PendingException;
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
import cucumber.api.java.en.Given;

public class IGAStepdefs {
    public WebDriver driver;
    //    public List<HashMap<String,String>> datamap = DataHelper.data();
    public static List<HashMap<String, String>> datamap = null;


    public IGAStepdefs() {
        driver = Hooks.driver;
    }

    @Given("^IGA home page$")
    public void i_open_automationpractice_website() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.iga.net");
    }

    @When("^I click My account$")
    public void i_sign_in() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.initElements(driver, IGALoginPage.class);

        IGASignInAction.Execute();
    }

    @Then("^the login page is up$")
    public void i_validate_failed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        IGASignInAction.validateSigninFailed(driver);
    }

}
