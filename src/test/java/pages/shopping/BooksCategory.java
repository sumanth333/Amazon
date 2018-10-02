/**
 * 
 */
package pages.shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sumanth
 * This is a class regarding the books category in amazon page
 *
 */
public class BooksCategory {

	/**
	 * Below variable to perform actions like drag and drop or hover
	 */
	Actions action;
/**
 * Below are web elements find by xpaths
 */

	/**
	 * Below variable is a web element to show shop categories when hovered
	 */
	@FindBy(id = "nav-shop")
	WebElement shopByCategory;

	/**
	 * Below variable is a books category in shops category
	 * when clicked shows all the books in amazon website
	 */
	@FindBy(xpath = "//span[text()='Books']")
	WebElement books;

	/**
	 * Below is the By instance used to find ALl books category
	 * fnds by xpath
	 */
	@FindBy(xpath = "//span[text()='All Books']" )
	WebElement allBooks;

	/**
	 * Below variable is makes the program to wait until the element is found
	 */
	WebDriverWait wait;

	/**
	 * Below constructor calls the super constructor and initialises the driver
	 * It uses pagefactory to optimally find the web elements
	 * It initialises the Actions object
	 * @param driver
	 */
	public BooksCategory(WebDriver driver,WebDriverWait wait) {

		PageFactory.initElements(driver, this);
		this.wait = wait;
		action = new Actions(driver);
	}

	/**
	 * Below method performs hovers action on the shop by category
	 * using action instance
	 */
	public void hoverShopByCategory() {
		
		action.moveToElement(shopByCategory).perform();
	}

	/**
	 * Below method performs hover action on the books element
	 * uses action object and books web element
	 */
	public void hoverBooks() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='Books']")));
		action.moveToElement(books).perform();
	}

	/**
	 * Below method perform click operation on allBooks web element
	 */
	public void clickAllBooks() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='All Books']")));
		allBooks.click();
	}

}
