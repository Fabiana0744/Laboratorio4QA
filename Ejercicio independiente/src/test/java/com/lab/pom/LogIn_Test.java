package com.lab.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LogIn_Test {
	
	private WebDriver driver;
	LogInPage logInPage;
	
	@Before
	public void setUp() throws Exception {
		logInPage = new LogInPage(driver);
		driver = logInPage.chromeDriverConnection();
		logInPage.visit("https://www.phptravels.net/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void logInTest() throws InterruptedException {
		logInPage.logIn("user@phptravels.com", "demouser");
		Thread.sleep(2000);
		assertEquals("Welcome Back", logInPage.loggedInMessage());
	}

}
