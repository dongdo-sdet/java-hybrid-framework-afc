package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageFactory extends BasePageFactory {
	private WebDriver driver;

	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement registerHeaderLink;

	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginHeaderLink;

	@FindBy(xpath = "//a[@class='ico-account']")
	private WebElement myAccountHeaderLink;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutHeaderLink;

	public void clickToRegisterHeaderLink() {
		waitElementClickable(driver, registerHeaderLink);
		clickToElement(driver, registerHeaderLink);
	}

	public void clickToLoginHeaderLink() {
		waitElementClickable(driver, loginHeaderLink);
		clickToElement(driver, loginHeaderLink);
	}

	public boolean isMyAccountHeaderLinkDisplayed() {
		waitElementVisible(driver, myAccountHeaderLink);
		return isElementDisplayed(driver, myAccountHeaderLink);
	}

	public void clickToLogoutHeaderLink() {
		waitElementClickable(driver, logoutHeaderLink);
		clickToElement(driver, logoutHeaderLink);
	}

	public boolean isRegisterHeaderLinkDisplayed() {
		waitElementVisible(driver, registerHeaderLink);
		return isElementDisplayed(driver, registerHeaderLink);
	}

	public boolean isLoginHeaderLinkDisplayed() {
		waitElementVisible(driver, loginHeaderLink);
		return isElementDisplayed(driver, loginHeaderLink);
	}

}
