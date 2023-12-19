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

public class Fw_11_Log4j2_ReportNG extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private String firstName, lastName, emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorNopCommerce.getHomePage(driver);

		firstName = "Duy Dong";
		lastName = "Do";
		emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
		password = "Selenium3";
	}

	@Test
	public void User_01_Register() {
		log.info("User_01_Register - Step 01: Click to 'Register' header link");
		registerPage = homePage.clickToRegisterHeaderLink();

		log.info("User_01_Register - Step 02: Enter '" + firstName + "' in 'First name' text box");
		registerPage.sendKeysToFirstNameTextbox(firstName);

		log.info("User_01_Register - Step 03: Enter '" + lastName + "' in 'Last name' text box");
		registerPage.sendKeysToLastNameTextbox(lastName);

		log.info("User_01_Register - Step 04: Enter '" + emailAddress + "' in 'Email' text box");
		registerPage.sendKeysToEmailTextbox(emailAddress);

		log.info("User_01_Register - Step 05: Enter '" + password + "' in 'Password' text box");
		registerPage.sendKeysToPasswordTextbox(password);

		log.info("User_01_Register - Step 06: Enter '" + password + "' in 'Confirm password' text box");
		registerPage.sendKeysToConfirmPasswordTextbox(password);

		log.info("User_01_Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("User_01_Register - Step 08: Verify registration completed message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");

		log.info("User_01_Register - Step 09: Click to 'Continue' button");
		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void User_02_Login() {
		log.info("User_02_Login - Step 01: Click to 'Log in' header link");
		loginPage = homePage.clickToLoginHeaderLink();

		log.info("User_02_Login - Step 02: Enter '" + emailAddress + "' in 'Email' text box");
		loginPage.sendKeysToEmailTextbox(emailAddress);

		log.info("User_02_Login - Step 03: Enter '" + password + "' in 'Password' text box");
		loginPage.sendKeysToPasswordTextbox(password);

		log.info("User_02_Login - Step 04: Click to 'Log in' button");
		homePage = loginPage.clickToLoginButton();

		log.info("User_02_Login - Step 05: Verify 'My account' header link is displayed");
		Assert.assertFalse(homePage.isMyAccountHeaderLinkDisplayed());

		log.info("User_02_Login - Step 06: Click to 'Log out' header link");
		homePage.clickToLogoutHeaderLink();

		log.info("User_02_Login - Step 07: Verify 'Register' header link is displayed");
		Assert.assertTrue(homePage.isRegisterHeaderLinkDisplayed());

		log.info("User_02_Login - Step 08: Verify 'Log in' header link is displayed");
		Assert.assertTrue(homePage.isLoginHeaderLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
