package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.jQuery.UploadFilesPageObject;
import pageObjects.jQuery.WebTablePageObject;

public class PageGeneratorJQuery {

	public static WebTablePageObject getWebTablePage(WebDriver driver) {
		return new WebTablePageObject(driver);
	}

	public static UploadFilesPageObject getUploadFilesPage(WebDriver driver) {
		return new UploadFilesPageObject(driver);
	}

}
