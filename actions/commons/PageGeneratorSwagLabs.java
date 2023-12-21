package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.swagLabs.LoginPageObject;
import pageObjects.swagLabs.ProductPageObject;

public class PageGeneratorSwagLabs {

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static ProductPageObject getProductPage(WebDriver driver) {
		return new ProductPageObject(driver);
	}

}
