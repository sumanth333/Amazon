/**
 * 
 */
package pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author Sumanth
 * This is a home page it shows amazon.in web page and able to
 * direct to the sign in page
 *
 */
public class AmazonPage {

	/**
	 * below web element is a sign in button
	 */
	@FindBy(id = "nav-link-yourAccount")
	WebElement account;

	/**
	 * Below variable is makes the program to wait until the element is found
	 */
	WebDriverWait wait;

	/**
	 *
	 * @param driver
	 * Below Constructor uses pagefactory to find the elements in an optimal way
	 * @param wait
	 */
	public AmazonPage(WebDriver driver, WebDriverWait wait) {
		PageFactory.initElements(driver, this);
		this.wait = wait;
	}

	/**
	 * Below method clicks the sign in button and takes to another page
	 */
	public void clickAccount() {
		account.click();
	}

}
