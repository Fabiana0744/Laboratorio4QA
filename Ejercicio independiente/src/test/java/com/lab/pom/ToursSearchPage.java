package com.lab.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToursSearchPage extends Base {

	//By hotelsBtnLinkLocator = By.cssSelector("a.nav-link[href='https://www.phptravels.net/hotels']");
	//By destinationHotelDropdown = By.cssSelector("span.select2-selection--single[aria-labelledby='select2-hotels_city-container']");

	
	By toursBtnLinkLocator = By.cssSelector("a.nav-link[href='https://www.phptravels.net/tours']");
	
	By destinationDropdown = By.cssSelector("span.select2-selection--single[aria-labelledby='select2-tours_city-container']");
	By dropdownListDestinations = By.xpath("//div[contains(@class, 'to--insert')]");
	
	By dateInput = By.id("date");
	
	By travellersField = By.cssSelector("a.dropdown-toggle.dropdown-btn.travellers.waves-effect\r\n"
			+ "");

	
	By currentAdultsLocator = By.id("tours_adults");
	By currentChildsLocator = By.id("tours_child");
	
	
	By decrementAdultButton = By.xpath("//div[contains(@class, 'qty-box')][1]//div[contains(@class, 'qtyDec')]");
	By incrementAdultButton = By.xpath("//div[contains(@class, 'qty-box')][1]//div[contains(@class, 'qtyInc')]");
	
	By decrementChildButton = By.xpath("(//div[contains(@class, 'qty-box')])[2]//div[contains(@class, 'qtyDec')]");
	By incrementChildButton = By.xpath("(//div[contains(@class, 'qty-box')])[2]//div[contains(@class, 'qtyInc')]");

	By searchButton = By.cssSelector("button.search_button");
	
	
	By monthOrYearSwitch = By.cssSelector("div.datepicker-days th.switch");
	By specificMonthLocator = By.xpath("//div[@class='datepicker-months']//span[@class='month' and text()='Dec']");
	By specificDayLocator = By.xpath("//td[contains(@class, 'day') and not(contains(@class, 'old')) and text()='25']");


	By tourCardLocator = By.cssSelector("div.card.p-2.rounded-3");
	
	By outsideElement = By.tagName("body");

	
	public ToursSearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void selectToursLink() throws InterruptedException {
        click(toursBtnLinkLocator);
        Thread.sleep(2000);
    }
    
    public void selectDestination() throws InterruptedException {
        click(destinationDropdown);
        Thread.sleep(500);
        
        List<WebElement> options = findElements(dropdownListDestinations);
        WebElement option = options.get(3);
        click(option);

    }
    

    public void selectDate() throws InterruptedException {
        click(dateInput);
        Thread.sleep(500);
        
     // Cambia a vista de meses y selecciona diciembre
        findElement(monthOrYearSwitch).click();
        Thread.sleep(500);
        findElement(specificMonthLocator).click();
        Thread.sleep(500);

        // Ahora selecciona el día 25 en diciembre
        click(dateInput);
        findElement(specificDayLocator).click();

    }
    
    public void selectAdults(int desiredAdults) throws InterruptedException {
        click(travellersField);
        Thread.sleep(1000);
        selectNumberOfTravellers(desiredAdults, currentAdultsLocator, incrementAdultButton, decrementAdultButton);
        click(outsideElement);
    }
    
    public void selectChildren(int desiredChildren) throws InterruptedException {
        click(travellersField);
        Thread.sleep(1000);
        selectNumberOfTravellers(desiredChildren, currentChildsLocator, incrementChildButton, decrementChildButton);
        click(outsideElement);
    }

    private void selectNumberOfTravellers(int desiredCount, By currentCountLocator, By incrementButton, By decrementButton) {
        int currentCount = Integer.parseInt(findElement(currentCountLocator).getAttribute("value"));

        while (currentCount < desiredCount) {
            click(incrementButton);
            currentCount++;
        }

        while (currentCount > desiredCount) {
            click(decrementButton);
            currentCount--;
        }
    }
    


    public void searchTours() throws InterruptedException {
        click(searchButton);
        Thread.sleep(3000);
    }
    
    
    public WebElement getTourCard() {
    	return findElement(tourCardLocator);
    }

}
