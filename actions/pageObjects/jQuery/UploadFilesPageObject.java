package pageObjects.jQuery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.UploadFilesPageUI;

public class UploadFilesPageObject extends BasePage {
	private WebDriver driver;

	public UploadFilesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void uploadFileToPage(String... fileNames) {
		uploadFile(driver, fileNames);
	}

	public boolean isFileLoadedNameDisplayed(String fileName) {
		waitElementVisible(driver, UploadFilesPageUI.FILE_LOADED_NAME, fileName);
		return isElementDisplayed(driver, UploadFilesPageUI.FILE_LOADED_NAME, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startBtns = getListWebElement(driver, UploadFilesPageUI.START_BUTTON);
		for (WebElement startBtn : startBtns) {
			startBtn.click();
			sleepInSecond(2);
		}
	}

	public boolean isFileUploadedLinkDisplayed(String fileName) {
		waitElementVisible(driver, UploadFilesPageUI.FILE_UPLOADED_LINK, fileName);
		return isElementDisplayed(driver, UploadFilesPageUI.FILE_UPLOADED_LINK, fileName);
	}

	public boolean isFileUploadedImgDisplayed(String fileName) {
		waitElementVisible(driver, UploadFilesPageUI.FILE_UPLOADED_IMG, fileName);
		return isImageDisplayedByJS(driver, UploadFilesPageUI.FILE_UPLOADED_IMG, fileName);
	}

	public void clickToDeleteButton() {
		List<WebElement> deleteBtns = getListWebElement(driver, UploadFilesPageUI.DELETE_BUTTON);
		for (WebElement deleteBtn : deleteBtns) {
			deleteBtn.click();
			sleepInSecond(2);
		}
	}

}
