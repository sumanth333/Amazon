package pages.shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverconfig.DriverBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sumanth
 *
 * THis class for doing search operation
 * It extends the base class web_Driver
 */


public class SearchBook {

	/**
	 * Below variable contains the web elenent that is an input type
	 * It takes text as input and sends the value to the server when submitted
	 */
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchInput;

	/**
	 * Below variable contains the web elenent that is a search button
	 * It performs search operation what wever given in the above search input
	 */
	@FindBy(className = "nav-input")
	WebElement searchButton;

	/**
	 * Below variable is makes the program to wait until the element is found
	 */
	WebDriverWait wait;
	/**
	 * Below constructor initialises the driver by calling super class
	 * It uses factory technique to find the elements optimally
	 * @param driver
	 * @param wait
	 */
	public SearchBook(WebDriver driver, WebDriverWait wait) {

		PageFactory.initElements(driver, this);
		this.wait = wait;
	}

	/**
	 * Below method takes the book name into the searchInput mentioned above
	 * it uses searchInput webelement to insert text
	 * @param bookName
	 */
	public void typeBookName(String bookName) {
		searchInput.sendKeys(bookName);
		
	}

	/**
	 * Below method clicks the search button
	 * It uses searchButton web element and submits the text intext input
	 */
	public void clickSearch() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-search-submit-text")));
		searchButton.click();
	}

    public void clearText() {
		searchInput.clear();
    }
}
