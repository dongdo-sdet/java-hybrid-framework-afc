package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePageObject;
import commons.PageGeneratorNopCommerce;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePageObject {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void sendKeysToEmailTextbox(String emailAddress) {
		waitElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void sendKeysToPasswordTextbox(String password) {
		waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorNopCommerce.getHomePage(driver);
	}

}
