package com.lab.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LanguagePage extends Base{
	
	By languageBtnLocator = By.cssSelector("a.nav-link.dropdown-toggle.btn.ps-3.p-0.py-2.px-0.text-center.d-flex.align-items-center.justify-content-center.gap-0.border.waves-effect");
	By russianLanguageButton = By.cssSelector("a.dropdown-item.d-flex.gap-3.fadeout.waves-effect[href='https://www.phptravels.net/language/fr/French/LTR']");
	
	By mainHomeMessage = By.cssSelector("h4.text-white strong");

	
	public LanguagePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void changeLanguageToRussian() throws InterruptedException {
		click(languageBtnLocator);
		Thread.sleep(1000);
		click(russianLanguageButton);
	}
	
	
	public String getMainMessage() {
		WebElement mainMessage = waitForVisibility(mainHomeMessage, 10);
		//WebElement mainMessage = findElement(mainHomeMessage);
	    return mainMessage.getText();
	}

}
