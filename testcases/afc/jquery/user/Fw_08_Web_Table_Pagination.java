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
import pageObjects.jQuery.WebTablePageObject;

public class Fw_08_Web_Table_Pagination extends BaseTest {
	private WebDriver driver;
	private WebTablePageObject webTablePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.PAGINATION_WEB_TABLE_URL);
		webTablePage = PageGeneratorJQuery.getWebTablePage(driver);
	}

	@Test
	public void TC_01_Switch_Page_And_Search() {
		webTablePage.clickToPaginationPageByNumber("13");
		Assert.assertTrue(webTablePage.isPaginationPageActiveByNumber("13"));

		webTablePage.sendKeysToFilterTextboxByColumnLabel("Country", "Malaysia");
		Assert.assertTrue(webTablePage.isRowDisplayedByValues("284790", "Malaysia", "266685", "551471"));

		webTablePage.clickToPaginationPageByNumber("10");
		Assert.assertTrue(webTablePage.isPaginationPageActiveByNumber("10"));

		webTablePage.sendKeysToFilterTextboxByColumnLabel("Country", "Indonesia");
		Assert.assertTrue(webTablePage.isRowDisplayedByValues("2254542", "Indonesia", "2376570", "4631110"));
	}

	@Test
	public void TC_02_Get_All_Values_By_Column() {
		webTablePage.getAllValuesByColumnLabelAllPages("Country");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
