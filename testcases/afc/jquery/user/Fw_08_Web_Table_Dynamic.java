package afc.jquery.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorJQuery;
import pageObjects.jQuery.WebTablePageObject;

public class Fw_08_Web_Table_Dynamic extends BaseTest {
	private WebDriver driver;
	private WebTablePageObject webTablePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.DYNAMIC_WEB_TABLE_URL);
		webTablePage = PageGeneratorJQuery.getWebTablePage(driver);
	}

	@Test
	public void TC_01_Actions_To_All_Fields() {
		webTablePage.sendKeysToTextboxByRowNumberAndColumnLabel("1", "Company", "AFC");

		webTablePage.sendKeysToTextboxByRowNumberAndColumnLabel("2", "Contact Person", "Dong");

		webTablePage.selectDropdownByRow("3", "Japan");

		webTablePage.checkToCheckboxByRow("1");

		webTablePage.sendKeysToTextboxByRowNumberAndColumnLabel("2", "Order Placed", "3082023");

		webTablePage.setDayMonthYearToDatePickerByRow("3", "08/30/2023");

		webTablePage.uncheckToCheckboxByRow("1");

		webTablePage.clickToIconByRowNumber("1", "Insert Row Above");

		webTablePage.clickToIconByRowNumber("2", "Remove Current Row");

		webTablePage.clickToIconByRowNumber("3", "Move Up");

		webTablePage.clickToIconByRowNumber("3", "Remove Current Row");

		webTablePage.clickToIconByRowNumber("1", "Move Down");

		webTablePage.clickToIconByRowNumber("1", "Remove Current Row");
	}

	@Test
	public void TC_02_Load_Data() {
		webTablePage.clickToLoadDataButton();

		webTablePage.clickToAppendRowButton();

		webTablePage.sendKeysToTextboxByRowNumberAndColumnLabel("9", "Company", "AFC");

		webTablePage.clickToIconByRowNumber("8", "Move Down");

		webTablePage.sendKeysToTextboxByRowNumberAndColumnLabel("8", "Contact Person", "Dong");

		webTablePage.clickToIconByRowNumber("7", "Remove Current Row");

		webTablePage.selectDropdownByRow("7", "Japan");

		webTablePage.clickToIconByRowNumber("6", "Move Down");

		webTablePage.checkToCheckboxByRow("6");

		webTablePage.clickToIconByRowNumber("4", "Remove Current Row");

		webTablePage.clickToIconByRowNumber("5", "Insert Row Above");

		webTablePage.clickToIconByRowNumber("6", "Move Up");

		webTablePage.clickToIconByRowNumber("3", "Remove Current Row");

		webTablePage.sendKeysToTextboxByRowNumberAndColumnLabel("4", "Order Placed", "3082023");

		webTablePage.clickToRemoveLastRowButton();

		webTablePage.clickToIconByRowNumber("6", "Remove Current Row");

		webTablePage.clickToIconByRowNumber("3", "Move Down");

		webTablePage.clickToIconByRowNumber("3", "Move Up");

		webTablePage.setDayMonthYearToDatePickerByRow("2", "08/30/2023");

		webTablePage.clickToIconByRowNumber("4", "Remove Current Row");

		webTablePage.clickToIconByRowNumber("2", "Move Down");

		webTablePage.clickToIconByRowNumber("2", "Remove Current Row");

		webTablePage.clickToIconByRowNumber("1", "Move Down");

		webTablePage.clickToIconByRowNumber("2", "Remove Current Row");

		webTablePage.clickToRemoveLastRowButton();

		webTablePage.uncheckToCheckboxByRow("1");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
