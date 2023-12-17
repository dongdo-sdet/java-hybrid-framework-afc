package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageFactory extends BasePageFactory {
	private WebDriver driver;

	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;

	public void sendKeysToEmailTextbox(String emailAddress) {
		waitElementVisible(driver, emailTextbox);
		sendKeysToElement(driver, emailTextbox, emailAddress);
	}

	public void sendKeysToPasswordTextbox(String password) {
		waitElementVisible(driver, passwordTextbox);
		sendKeysToElement(driver, passwordTextbox, password);
	}

	public void clickToLoginButton() {
		waitElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

}
