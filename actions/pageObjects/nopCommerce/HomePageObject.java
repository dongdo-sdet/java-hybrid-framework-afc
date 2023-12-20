package pageObjects.nopCommerce;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import commons.BasePageObject;
import commons.PageGeneratorNopCommerce;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePageObject {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Click to 'Register' button")
	public RegisterPageObject clickToRegisterHeaderLink() {
		waitElementClickable(driver, HomePageUI.REGISTER_HEADER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_HEADER_LINK);
		return PageGeneratorNopCommerce.getRegisterPage(driver);
	}

	@Step("Click to 'Log in' button")
	public LoginPageObject clickToLoginHeaderLink() {
		waitElementClickable(driver, HomePageUI.LOGIN_HEADER_LINK);
		clickToElement(driver, HomePageUI.LOGIN_HEADER_LINK);
		return PageGeneratorNopCommerce.getLoginPage(driver);
	}

	@Step("Verify 'My account' header link is displayed")
	public boolean isMyAccountHeaderLinkDisplayed() {
		waitElementVisible(driver, HomePageUI.MY_ACCOUNT_HEADER_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_HEADER_LINK);
	}

	@Step("Click to 'Log out' button")
	public void clickToLogoutHeaderLink() {
		waitElementClickable(driver, HomePageUI.LOGOUT_HEADER_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_HEADER_LINK);
	}

	@Step("Verify 'Register' header link is displayed")
	public boolean isRegisterHeaderLinkDisplayed() {
		waitElementVisible(driver, HomePageUI.REGISTER_HEADER_LINK);
		return isElementDisplayed(driver, HomePageUI.REGISTER_HEADER_LINK);
	}

	@Step("Verify 'Log in' header link is displayed")
	public boolean isLoginHeaderLinkDisplayed() {
		waitElementVisible(driver, HomePageUI.LOGIN_HEADER_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGIN_HEADER_LINK);
	}

	public Set<Cookie> getLoginCookies() {
		return getCookies(driver);
	}

}
