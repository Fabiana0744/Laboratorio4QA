package com.lab.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage extends Base {
	
	LogInPage logInPage;
	
	By accountBtnLocator = By.cssSelector("strong.m-0.text-dark.text-uppercase");
	By logoutOptionLocator = By.linkText("Logout");
	
	By logOutMessage = By.cssSelector("div.vt-card.success");

	public LogOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	public void logOut() throws InterruptedException {
		click(accountBtnLocator);
		Thread.sleep(1000);
		if(isDisplayed(accountBtnLocator)) {
			click(logoutOptionLocator);
			Thread.sleep(2000);	
		}
		else {
			System.out.println("Account Dropdown was not present");
		}
	}
	
	public WebElement getLogOutSuccessMessage() {
	    return findElement(logOutMessage);
	}

}
