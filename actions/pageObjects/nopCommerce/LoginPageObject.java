package pageObjects.nopCommerce;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import commons.BasePageObject;
import commons.PageGeneratorNopCommerce;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePageObject {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Enter '{0}' in 'Email' text box")
	public void sendKeysToEmailTextbox(String emailAddress) {
		waitElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	@Step("Enter '{0}' in 'Password' text box")
	public void sendKeysToPasswordTextbox(String password) {
		waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Click to 'Log in' button")
	public HomePageObject clickToLoginButton() {
		waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorNopCommerce.getHomePage(driver);
	}

	public HomePageObject loginByCookies(Set<Cookie> loginCookies) {
		setCookies(driver, loginCookies);
		refreshPage(driver);
		waitElementClickable(driver, "//div[@class='bar-notification success']//span[@class='close']");
		clickToElement(driver, "//div[@class='bar-notification success']//span[@class='close']");
		sleepInSecond(3);
		return PageGeneratorNopCommerce.getHomePage(driver);
	}

}
