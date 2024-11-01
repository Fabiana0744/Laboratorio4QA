package com.project.pom;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends Base{

	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("submit");
	
	By signedInMessage = By.tagName("font");
	
	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void signIn() {
		if(isDisplayed(userLocator)) {
			type("qualityadmin", userLocator);
			type("pass1", passLocator);
			click(signInBtnLocator);
		}
		else {
			System.out.println("Username textbox was not present");
		}
	}
	
	
	public String signedInMessage() {	//en lugar de isHomePageDisplayed
		List<WebElement> fonts = findElements(signedInMessage);
				
		return getText(fonts.get(3));
	}
	
	
}
