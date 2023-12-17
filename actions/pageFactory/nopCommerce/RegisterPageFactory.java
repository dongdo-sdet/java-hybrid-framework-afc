package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageFactory extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextbox;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextbox;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;

	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registrationSuccessMessage;

	@FindBy(xpath = "//a[contains(@class,'continue-button')]")
	private WebElement continueButton;

	public void sendKeysToFirstNameTextbox(String firstName) {
		waitElementVisible(driver, firstNameTextbox);
		sendKeysToElement(driver, firstNameTextbox, firstName);
	}

	public void sendKeysToLastNameTextbox(String lastName) {
		waitElementVisible(driver, lastNameTextbox);
		sendKeysToElement(driver, lastNameTextbox, lastName);
	}

	public void sendKeysToEmailTextbox(String emailAddress) {
		waitElementVisible(driver, emailTextbox);
		sendKeysToElement(driver, emailTextbox, emailAddress);
	}

	public void sendKeysToPasswordTextbox(String password) {
		waitElementVisible(driver, passwordTextbox);
		sendKeysToElement(driver, passwordTextbox, password);
	}

	public void sendKeysToConfirmPasswordTextbox(String password) {
		waitElementVisible(driver, confirmPasswordTextbox);
		sendKeysToElement(driver, confirmPasswordTextbox, password);
	}

	public void clickToRegisterButton() {
		waitElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getRegisterSuccessMessage() {
		waitElementVisible(driver, registrationSuccessMessage);
		return getElementText(driver, registrationSuccessMessage);
	}

	public void clickToContinueButton() {
		waitElementClickable(driver, continueButton);
		clickToElement(driver, continueButton);
	}

}
