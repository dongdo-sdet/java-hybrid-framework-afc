package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT);
	}

	public void sendKeysToEmailTextbox(String emailAddress) {
		waitElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public boolean isReEnterEmailTextboxDisplayed() {
		waitElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
	}

	public boolean isReEnterEmailTextboxUndisplayed() {
		waitElementInvisible(driver, LoginPageUI.RE_EMAIL_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.RE_EMAIL_TEXTBOX);
	}

	public void clickToCloseSignUpButton() {
		waitElementClickable(driver, LoginPageUI.CLOSE_SIGN_UP_BUTTON);
		clickToElement(driver, LoginPageUI.CLOSE_SIGN_UP_BUTTON);
	}

	public boolean isEmailTextboxUndisplayed() {
		waitElementInvisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
	}

}
