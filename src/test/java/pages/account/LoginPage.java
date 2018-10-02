/**
 * 
 */
package pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sumanth
 * 
 * This class will store the locaters and methods of Login page
 *
 *
 */
public class LoginPage {

	/**
	 * Below variable is a text input element asks for User email or phone number
	 */
	@FindBy(id = "ap_email")
	WebElement username;

	/**
	 * Below variable is a password input field asks for the password
	 * registered on the above user
	 */
	@FindBy(id = "ap_password")
	WebElement password;

	/**
	 * Below variable is a button used to continue to the next page with user name
	 *
	 */
	@FindBy(id = "continue")
	WebElement continueWithUsername;

	/**
	 * Below variable is a submit button used to submit the password and call for validation
	 */
	@FindBy(id = "signInSubmit")
	WebElement signInSubmit;


	/**
	 * Below constructor is uses a page factory technique to find the web elements optimally
	 * This constructor initialises the driver with given driver
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to send the passed string into the input field of username
	 * @param user
	 */
	public void typeUserName(String user) {
		username.sendKeys(user);
	}

	/**
	 * This method used to insert password in password field from passwd string parameter
	 * @param passwd
	 */
	public void typePassword(String passwd) {
		password.sendKeys(passwd);
	}

	/**
	 * Below method used to click the continue button with given username
	 */
	public void clickContinue() {
		continueWithUsername.click();
	}

	/**
	 * Below method is used to submit the password details to the server
	 * to validate the username and password
	 */
	public void clickSignInSubmit() {
		signInSubmit.click();
	}

}
