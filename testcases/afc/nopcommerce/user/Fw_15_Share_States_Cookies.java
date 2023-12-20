package afc.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import afc.nopcommerce.commons.Common_01_User_Register_Login;
import commons.BaseTest;
import commons.PageGeneratorNopCommerce;
import pageObjects.nopCommerce.CustomerInfoPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;

public class Fw_15_Share_States_Cookies extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfoPage;
	private String firstName, lastName, emailAddress;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorNopCommerce.getHomePage(driver);

		firstName = Common_01_User_Register_Login.firstName;
		lastName = Common_01_User_Register_Login.lastName;
		emailAddress = Common_01_User_Register_Login.emailAddress;

		loginPage = homePage.clickToLoginHeaderLink();
		loginPage.loginByCookies(Common_01_User_Register_Login.loginCookies);
	}

	@Test
	public void User_01_Verify_Customer_Info() {
		loginPage.clickToHeaderLinkByLinkText("My account");
		customerInfoPage = new CustomerInfoPageObject(driver);

		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);

		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);

		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
	}

	@Test
	public void User_02_Logout() {
		Assert.assertTrue(customerInfoPage.isHeaderLinkDisplayedByLinkText("Log out"));

		customerInfoPage.clickToHeaderLinkByLinkText("Log out");
		homePage = PageGeneratorNopCommerce.getHomePage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
