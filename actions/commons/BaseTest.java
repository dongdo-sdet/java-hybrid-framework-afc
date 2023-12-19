package commons;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Logger log = LogManager.getLogger(getClass());

	public WebDriver getDriver() {
		return driver;
	}

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

	@BeforeSuite
	public void beforeSuite() {
		deleteAllAllureResults();
	}

	private void deleteAllAllureResults() {
		try {
			String allureResults = GlobalConstants.ALLURE_REPORTS_PATH;
			File file = new File(allureResults);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
