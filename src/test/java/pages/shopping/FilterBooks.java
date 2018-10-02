/**
 * 
 */
package pages.shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author Sumanth
 * Below class is to filter books by star rating
 * The class extends the Web_Driver class which is a base class to all
 *
 */
public class FilterBooks {

	/**
	 * Below variable is a web element of 4 stars
	 * it will show only books with 4 star rating or above when got clicked
	 */
	@FindBy(xpath = "//span[text()='4 Stars & Up']")
	private WebElement starsFilter;

	/**
	 * Below variable is an element of paperback books
	 * It will only show the books which have paperback facility in the amazon website
	 */
	@FindBy(xpath = "//span[text()='Paperback']")
	private WebElement paperBack;

    /**
     * Below variable is makes the program to wait until the element is found
     */
    WebDriverWait wait;
	/**
	 * Below is the constructor which initialises the driver by calling superclass constructor
	 * It uses pagefactory technique to optimally find the web elements
     * @param driver
     * @param wait
     */
	public FilterBooks(WebDriver driver, WebDriverWait wait) {

		PageFactory.initElements(driver, this);
        this.wait = wait;
	}

	/**
	 * Below method clicks the 4 stars on the web page using starsFilter web element
	 */
	public void clickStars() {
		starsFilter.click();
	}

	/**
	 * Below method clicks paperBack check box using paperBack web element
	 */
	public void clickPaperBack() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='Paperback']")));
	    paperBack.click();
	}

}
