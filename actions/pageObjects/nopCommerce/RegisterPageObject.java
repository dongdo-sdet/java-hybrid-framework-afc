package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePageObject;
import commons.PageGeneratorNopCommerce;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePageObject {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void sendKeysToFirstNameTextbox(String firstName) {
		waitElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void sendKeysToLastNameTextbox(String lastName) {
		waitElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void sendKeysToEmailTextbox(String emailAddress) {
		waitElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void sendKeysToPasswordTextbox(String password) {
		waitElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void sendKeysToConfirmPasswordTextbox(String password) {
		waitElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public void clickToRegisterButton() {
		waitElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterSuccessMessage() {
		waitElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public HomePageObject clickToContinueButton() {
		waitElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
		return PageGeneratorNopCommerce.getHomePage(driver);
	}

}
