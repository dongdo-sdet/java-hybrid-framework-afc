package afc.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.PageGeneratorNopCommerce;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Fw_05_Page_Generator {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private String projectPath = System.getProperty("user.dir");
	private String firstName, lastName, emailAddress, password;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorNopCommerce.getHomePage(driver);

		firstName = "Duy Dong";
		lastName = "Do";
		emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
		password = "Selenium3";
	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.clickToRegisterHeaderLink();

		registerPage.sendKeysToFirstNameTextbox(firstName);

		registerPage.sendKeysToLastNameTextbox(lastName);

		registerPage.sendKeysToEmailTextbox(emailAddress);

		registerPage.sendKeysToPasswordTextbox(password);

		registerPage.sendKeysToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToLoginHeaderLink();

		loginPage.sendKeysToEmailTextbox(emailAddress);

		loginPage.sendKeysToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountHeaderLinkDisplayed());

		homePage.clickToLogoutHeaderLink();

		Assert.assertTrue(homePage.isRegisterHeaderLinkDisplayed());

		Assert.assertTrue(homePage.isLoginHeaderLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int getRandomNumber() {
		return new Random().nextInt(99999);
	}

}
