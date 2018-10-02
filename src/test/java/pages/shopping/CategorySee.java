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
 * @author Sumanth_Pole
 *
 * Below class is used to see the contents in the
 * left division of the amazon website
 * it extends Web_Driver page which is a base page
 *
 */
public class CategorySee {

	/**
	 * Below web element is a seemore text come butoon
	 * it is used to show the extra menu option when got clicked
	 */
	@FindBy(xpath = "//span[text()='See more']")
	public WebElement seeMore;

	/**
	 * Below web element is a see less text come button
	 * it minimizes and shows only few options in the left division of the amazon website
	 */
	@FindBy(xpath = "//span[text()='See Less']")
	private WebElement seeLess;

	/**
	 * Below variable is makes the program to wait until the element is found
	 */
	WebDriverWait wait;
	/**
	 * Below constructor used to initialise the driver by calling superclass constructor
	 * It uses PageFactory technique to find all web elements optimally
	 * @param driver
	 * @param wait
	 */
	public CategorySee(WebDriver driver, WebDriverWait wait) {

		PageFactory.initElements(driver, this);
		this.wait = wait;
	}

	/**
	 * Below method is used to click the seeMore button by useing seeMore Web Element
	 */
	public void clickSeeMore() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='See more']")));
		seeMore.click();
	}

	/**
	 * Below method is used to click the seeLess button by using seeLess Web Element
	 */
	public void clickSeeLess() {
		seeLess.click();
	}
}
