package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {

	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	protected void sendKeysToElement(WebDriver driver, WebElement element, String keysToSend) {
		element.clear();
		element.sendKeys(keysToSend);
	}

	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	protected boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	protected void waitElementVisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.elementToBeClickable(element));
	}

	private long longTimeOut = 30;

}
