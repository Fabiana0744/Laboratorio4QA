package com.lab.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOut_Test {
	
	private WebDriver driver;
	LogOutPage logOutPage;
	LogInPage logInPage;

	@Before
	public void setUp() throws Exception {
		logOutPage = new LogOutPage(driver);
		driver = logOutPage.chromeDriverConnection();
		logOutPage.visit("https://www.phptravels.net/");
		logInPage = new LogInPage(driver);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void logOutTest() throws InterruptedException {
		logInPage.logIn("user@phptravels.com", "demouser");
		logOutPage.logOut();
		
	    WebElement successMessage = logOutPage.getLogOutSuccessMessage();

	    assertEquals("You have been logout successfully", successMessage.findElement(By.tagName("p")).getText());
	}

}
