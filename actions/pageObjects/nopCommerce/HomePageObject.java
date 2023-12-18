package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePageObject;
import commons.PageGeneratorNopCommerce;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePageObject {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterHeaderLink() {
		waitElementClickable(driver, HomePageUI.REGISTER_HEADER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_HEADER_LINK);
		return PageGeneratorNopCommerce.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginHeaderLink() {
		waitElementClickable(driver, HomePageUI.LOGIN_HEADER_LINK);
		clickToElement(driver, HomePageUI.LOGIN_HEADER_LINK);
		return PageGeneratorNopCommerce.getLoginPage(driver);
	}

	public boolean isMyAccountHeaderLinkDisplayed() {
		waitElementVisible(driver, HomePageUI.MY_ACCOUNT_HEADER_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_HEADER_LINK);
	}

	public void clickToLogoutHeaderLink() {
		waitElementClickable(driver, HomePageUI.LOGOUT_HEADER_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_HEADER_LINK);
	}

	public boolean isRegisterHeaderLinkDisplayed() {
		waitElementVisible(driver, HomePageUI.REGISTER_HEADER_LINK);
		return isElementDisplayed(driver, HomePageUI.REGISTER_HEADER_LINK);
	}

	public boolean isLoginHeaderLinkDisplayed() {
		waitElementVisible(driver, HomePageUI.LOGIN_HEADER_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGIN_HEADER_LINK);
	}

}
