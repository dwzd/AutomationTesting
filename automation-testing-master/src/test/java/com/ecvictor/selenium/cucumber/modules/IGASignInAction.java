package com.ecvictor.selenium.cucumber.modules;

import com.ecvictor.selenium.cucumber.helpers.Log;
import com.ecvictor.selenium.cucumber.pageobjects.AutomationHomePage;
import com.ecvictor.selenium.cucumber.pageobjects.IGALoginPage;
import com.ecvictor.selenium.cucumber.pageobjects.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.HashMap;

import static org.testng.AssertJUnit.assertEquals;

public class IGASignInAction {

	public static void Execute() throws Exception{

		IGALoginPage.myAccountButton.click();
		Log.info("Click action is performed on Submit button");

		Reporter.log("SignIn Action is successfully performed");

	}
	public static void validateSigninFailed(WebDriver driver) throws Exception{

		Assert.assertEquals(driver.findElement(By.xpath("//H1[@class='push-medium--bottom']")).getText(), "LOGIN");
		Log.info("Authentication failed Found");

		Reporter.log("Validation is performed");

	}
}
