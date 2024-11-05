package com.lab.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends Base{
	
	By accountBtnLocator = By.cssSelector("strong.m-0.text-dark.text-uppercase");
	By loginOptionLocator = By.linkText("Login");
	
	By emailLocator = By.name("email");
	By passLocator = By.name("password");
	By loginBtnLocator = By.id("submitBTN");
	
    By welcomeBackMessageLocator = By.cssSelector("span.author__meta");


	public LogInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void logIn(String email, String userPassword) throws InterruptedException {
		click(accountBtnLocator);
		Thread.sleep(1000);
		if(isDisplayed(accountBtnLocator)) {
			click(loginOptionLocator);
			Thread.sleep(2000);
			type(email, emailLocator);
			type(userPassword, passLocator);
			click(loginBtnLocator);
			
		}
		else {
			System.out.println("Account Dropdown was not present");
		}
	}
	
	
	public String loggedInMessage() {
		WebElement welcomeMessage = findElement(welcomeBackMessageLocator);
	    return welcomeMessage.getText();
	}

	

}
