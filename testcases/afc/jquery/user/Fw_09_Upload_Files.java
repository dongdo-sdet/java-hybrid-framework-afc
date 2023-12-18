package afc.jquery.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorJQuery;
import pageObjects.jQuery.UploadFilesPageObject;

public class Fw_09_Upload_Files extends BaseTest {
	private WebDriver driver;
	private UploadFilesPageObject uploadFilesPage;

	private String javaFile = "java.jpg";
	private String cSharpFile = "cSharp.jpg";
	private String javaScriptFile = "javaScript.jpg";
	private String rubyFile = "ruby.jpg";
	private String pythonFile = "python.jpg";
	private String[] multipleFiles = { javaFile, cSharpFile, javaScriptFile, rubyFile, pythonFile };

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.UPLOAD_FILE_URL);
		uploadFilesPage = PageGeneratorJQuery.getUploadFilesPage(driver);
	}

	@Test
	public void TC_01() {
		uploadFilesPage.uploadFileToPage(javaFile);

		Assert.assertTrue(uploadFilesPage.isFileLoadedNameDisplayed(javaFile));

		uploadFilesPage.clickToStartButton();

		Assert.assertTrue(uploadFilesPage.isFileUploadedLinkDisplayed(javaFile));

		Assert.assertTrue(uploadFilesPage.isFileUploadedImgDisplayed(javaFile));

		uploadFilesPage.clickToDeleteButton();
	}

	@Test
	public void TC_02() {
		uploadFilesPage.uploadFileToPage(multipleFiles);

		Assert.assertTrue(uploadFilesPage.isFileLoadedNameDisplayed(javaFile));
		Assert.assertTrue(uploadFilesPage.isFileLoadedNameDisplayed(cSharpFile));
		Assert.assertTrue(uploadFilesPage.isFileLoadedNameDisplayed(javaScriptFile));
		Assert.assertTrue(uploadFilesPage.isFileLoadedNameDisplayed(rubyFile));
		Assert.assertTrue(uploadFilesPage.isFileLoadedNameDisplayed(pythonFile));

		uploadFilesPage.clickToStartButton();

		Assert.assertTrue(uploadFilesPage.isFileUploadedLinkDisplayed(javaFile));
		Assert.assertTrue(uploadFilesPage.isFileUploadedLinkDisplayed(cSharpFile));
		Assert.assertTrue(uploadFilesPage.isFileUploadedLinkDisplayed(javaScriptFile));
		Assert.assertTrue(uploadFilesPage.isFileUploadedLinkDisplayed(rubyFile));
		Assert.assertTrue(uploadFilesPage.isFileUploadedLinkDisplayed(pythonFile));

		Assert.assertTrue(uploadFilesPage.isFileUploadedImgDisplayed(javaFile));
		Assert.assertTrue(uploadFilesPage.isFileUploadedImgDisplayed(cSharpFile));
		Assert.assertTrue(uploadFilesPage.isFileUploadedImgDisplayed(javaScriptFile));
		Assert.assertTrue(uploadFilesPage.isFileUploadedImgDisplayed(rubyFile));
		Assert.assertTrue(uploadFilesPage.isFileUploadedImgDisplayed(pythonFile));

		uploadFilesPage.clickToDeleteButton();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
