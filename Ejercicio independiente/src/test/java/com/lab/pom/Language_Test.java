package com.lab.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Language_Test {
	
	private WebDriver driver;
	LanguagePage languagePage;

	@Before
	public void setUp() throws Exception {
		languagePage = new LanguagePage(driver);
		driver = languagePage.chromeDriverConnection();
		languagePage.visit("https://www.phptravels.net/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void changeLanguageTest() throws InterruptedException {
		languagePage.changeLanguageToRussian();
		assertEquals("Votre voyage commence ici !", languagePage.getMainMessage());
	}

}
