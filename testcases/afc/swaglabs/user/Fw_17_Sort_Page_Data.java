package afc.swaglabs.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorSwagLabs;
import pageObjects.swagLabs.LoginPageObject;
import pageObjects.swagLabs.ProductPageObject;

public class Fw_17_Sort_Page_Data extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private ProductPageObject productPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorSwagLabs.getLoginPage(driver);
	}

	@Test
	public void TC_01_Login_As_User() {
		loginPage.sendKeysToUserNameTextbox("standard_user");

		loginPage.sendKeysToPasswordTextbox("secret_sauce");

		productPage = loginPage.clickToLoginButton();

		Assert.assertTrue(productPage.isPageTitleDisplayed());
	}

	@Test
	public void TC_02_Sort_Page_Data_By_Name() {
		productPage.sortDataByProductName("Name (A to Z)");

		Assert.assertTrue(productPage.isProductNameSortASC());

		productPage.sortDataByProductName("Name (Z to A)");

		Assert.assertTrue(productPage.isProductNameSortDESC());
	}

	@Test
	public void TC_03_Sort_Page_Data_By_Price() {
		productPage.sortDataByProductName("Price (low to high)");

		Assert.assertTrue(productPage.isProductPriceSortASC());

		productPage.sortDataByProductName("Price (high to low)");

		Assert.assertTrue(productPage.isProductPriceSortDESC());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
