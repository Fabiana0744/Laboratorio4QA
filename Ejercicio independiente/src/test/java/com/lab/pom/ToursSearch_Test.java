package com.lab.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToursSearch_Test {
	
	private WebDriver driver;
	ToursSearchPage toursSearchPage;

	@Before
	public void setUp() throws Exception {
		
		toursSearchPage = new ToursSearchPage(driver);
		driver = toursSearchPage.chromeDriverConnection();
		toursSearchPage.visit("https://www.phptravels.net/");
	
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	
	@Test
	public void searchTourTest() throws InterruptedException {
		toursSearchPage.selectToursLink();
		toursSearchPage.selectDestination();
	    toursSearchPage.selectDate();
	    //toursSearchPage.selectAdults(2);
	    toursSearchPage.selectChildren(3);
	    toursSearchPage.searchTours();
	    WebElement tourCard = toursSearchPage.getTourCard();

	    assertTrue(tourCard.isDisplayed());
	}
	
	
	
	@Test
	public void incrementAdultsTest() throws InterruptedException {
		toursSearchPage.selectToursLink();
		toursSearchPage.selectAdults(2);
	    int adultsCount = Integer.parseInt(toursSearchPage.findElement(toursSearchPage.currentAdultsLocator).getAttribute("value"));
	    assertEquals(2, adultsCount);
	}
	
	
	@Test
	public void decrementAdultsTest() throws InterruptedException {
		toursSearchPage.selectToursLink();
		toursSearchPage.selectAdults(5);
		toursSearchPage.selectAdults(3);
	    int adultsCount = Integer.parseInt(toursSearchPage.findElement(toursSearchPage.currentAdultsLocator).getAttribute("value"));
	    assertEquals(3, adultsCount);
	}
	
	
	@Test
	public void incrementChildrenTest() throws InterruptedException {
		toursSearchPage.selectToursLink();
		toursSearchPage.selectChildren(3);
	    int childrenCount = Integer.parseInt(toursSearchPage.findElement(toursSearchPage.currentChildsLocator).getAttribute("value"));
	    assertEquals(3, childrenCount);
	}
	


	
	@Test
	public void decrementChildrenTest() throws InterruptedException {
		toursSearchPage.selectToursLink();
		toursSearchPage.selectChildren(4);
		toursSearchPage.selectChildren(2);
	    int childrenCount = Integer.parseInt(toursSearchPage.findElement(toursSearchPage.currentChildsLocator).getAttribute("value"));
	    assertEquals(2, childrenCount);
	}
	
	
	
}
