package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePageObject;
import pageUIs.nopCommerce.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePageObject {
	private WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getFirstNameTextboxValue() {
		waitElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttributeValue(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getElementAttributeValue(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmailTextboxValue() {
		waitElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttributeValue(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

}
