package pageObjects.swagLabs;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorSwagLabs;
import pageUIs.swagLabs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeysToUserNameTextbox(String userName) {
		waitElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.USERNAME_TEXTBOX, userName);
	}

	public void sendKeysToPasswordTextbox(String passwork) {
		waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwork);
	}

	public ProductPageObject clickToLoginButton() {
		waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorSwagLabs.getProductPage(driver);
	}

}
