package com.ecvictor.selenium.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class IGALoginPage extends BaseClass{

	public IGALoginPage(WebDriver driver){
		super(driver);
	}


	@FindBy(how= How.XPATH, using="//a[@id='header_0_MobileAccountLink']")
	public static WebElement myAccountButton;
	
		
	}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
