package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		switch (browserName) {
		case "firefox":
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case "chrome":
			driver = WebDriverManager.chromedriver().create();
			break;
		case "edge":
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException("'" + browserName.toUpperCase() + "' Browser is invalid.");
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;
	}

	protected int getRandomNumber() {
		return new Random().nextInt(99999);
	}

	protected boolean verifyTrue(boolean condition) {
		boolean verify = true;
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			verify = false;
			VerificationFailures.getFailures().addFailuresForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return verify;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean verify = true;
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			verify = false;
			VerificationFailures.getFailures().addFailuresForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return verify;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean verify = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			verify = false;
			VerificationFailures.getFailures().addFailuresForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return verify;
	}
}
