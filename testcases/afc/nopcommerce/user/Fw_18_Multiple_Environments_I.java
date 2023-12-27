package afc.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorNopCommerce;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Fw_18_Multiple_Environments_I extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private String firstName, lastName, emailAddress, password;

	@Parameters({ "browser", "server", "role" })
	@BeforeClass
	public void beforeClass(String browserName, String serverName, String role) {
		driver = getDriverByServerAndRole(browserName, serverName, role);
		homePage = PageGeneratorNopCommerce.getHomePage(driver);

		firstName = "Duy Dong";
		lastName = "Do";
		emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
		password = "Selenium3";
	}

	@Test
	public void User_01_Register() {
		homePage.clickToHeaderLinkByLinkText("Register");
		registerPage = PageGeneratorNopCommerce.getRegisterPage(driver);

		registerPage.sendKeysToTextboxByID("FirstName", firstName);

		registerPage.sendKeysToTextboxByID("LastName", lastName);

		registerPage.sendKeysToTextboxByID("Email", emailAddress);

		registerPage.sendKeysToTextboxByID("Password", password);

		registerPage.sendKeysToTextboxByID("ConfirmPassword", password);

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void User_02_Login() {
		homePage.clickToHeaderLinkByLinkText("Log in");
		loginPage = PageGeneratorNopCommerce.getLoginPage(driver);

		loginPage.sendKeysToTextboxByID("Email", emailAddress);

		loginPage.sendKeysToTextboxByID("Password", password);

		loginPage.clickToButtonByText("Log in");
		loginPage = PageGeneratorNopCommerce.getLoginPage(driver);

		Assert.assertTrue(homePage.isHeaderLinkDisplayedByLinkText("My account"));

		homePage.clickToHeaderLinkByLinkText("Log out");

		Assert.assertTrue(homePage.isHeaderLinkDisplayedByLinkText("Register"));

		Assert.assertTrue(homePage.isHeaderLinkDisplayedByLinkText("Log in"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
