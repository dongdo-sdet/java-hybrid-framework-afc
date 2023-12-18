package commons;

import org.openqa.selenium.WebDriver;

import pageUIs.nopCommerce.BasePageUI;

public class BasePageObject extends BasePage {
	private WebDriver driver;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToHeaderLinkByLinkText(String linkText) {
		waitElementClickable(driver, BasePageUI.HEADER_LINK_BY_LINK_TEXT, linkText);
		clickToElement(driver, BasePageUI.HEADER_LINK_BY_LINK_TEXT, linkText);
	}

	public boolean isHeaderLinkDisplayedByLinkText(String linkText) {
		waitAllElementsVisible(driver, BasePageUI.HEADER_LINK_BY_LINK_TEXT, linkText);
		return isElementDisplayed(driver, BasePageUI.HEADER_LINK_BY_LINK_TEXT, linkText);
	}

	public void sendKeysToTextboxByID(String textboxID, String keysToSend) {
		waitAllElementsVisible(driver, BasePageUI.TEXTBOX_BY_ID, textboxID);
		sendKeysToElement(driver, BasePageUI.TEXTBOX_BY_ID, keysToSend, textboxID);
	}

	public void clickToButtonByText(String buttonText) {
		waitElementClickable(driver, BasePageUI.BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BasePageUI.BUTTON_BY_TEXT, buttonText);
	}

}
