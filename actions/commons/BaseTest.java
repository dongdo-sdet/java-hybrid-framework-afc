package commons;

import java.io.File;
import java.io.IOException;
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
		BrowsersList browserList = BrowsersList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case FIREFOX:
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			break;
		case EDGE:
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

	protected WebDriver getDriverByServer(String browserName, String serverName) {
		BrowsersList browserList = BrowsersList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case FIREFOX:
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException("'" + browserName.toUpperCase() + "' Browser is invalid.");
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(getUserUrlByServer(serverName));
		return driver;
	}

	protected WebDriver getDriverByServerAndRole(String browserName, String serverName, String role) {
		BrowsersList browserList = BrowsersList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case FIREFOX:
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException("'" + browserName.toUpperCase() + "' Browser is invalid.");
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(getUrlByServerAndRole(serverName, role));
		return driver;
	}

	private String getUrlByServerAndRole(String serverName, String role) {
		RoleList roleList = RoleList.valueOf(role.toUpperCase());
		switch (roleList) {
		case USER:
			return getUserUrlByServer(serverName);
		case ADMIN:
			return getAdminUrlByServer(serverName);
		default:
			throw new RuntimeException("Invalid role");
		}
	}

	private String getUserUrlByServer(String serverName) {
		ServersList serversList = ServersList.valueOf(serverName.toUpperCase());
		switch (serversList) {
		case DEV:
			return GlobalConstants.DEV_NOPCOMMERCE_USER_URL;
		case TEST:
			return GlobalConstants.TEST_NOPCOMMERCE_USER_URL;
		case DEMO:
			return GlobalConstants.DEMO_NOPCOMMERCE_USER_URL;
		case PROD:
			return GlobalConstants.PROD_NOPCOMMERCE_USER_URL;
		default:
			throw new RuntimeException("Invalid Server");
		}
	}

	private String getAdminUrlByServer(String serverName) {
		ServersList serversList = ServersList.valueOf(serverName.toUpperCase());
		switch (serversList) {
		case DEV:
			return GlobalConstants.DEV_NOPCOMMERCE_ADMIN_URL;
		case TEST:
			return GlobalConstants.TEST_NOPCOMMERCE_ADMIN_URL;
		case DEMO:
			return GlobalConstants.DEMO_NOPCOMMERCE_ADMIN_URL;
		case PROD:
			return GlobalConstants.DEMO_NOPCOMMERCE_ADMIN_URL;
		default:
			throw new RuntimeException("Invalid Server");
		}
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

	protected void closeBrowserDriver() {
		String cmd = null;

		String osName = System.getProperty("os.name").toLowerCase();
		log.info("OS Name: " + osName);

		String driverInstance = driver.toString().toLowerCase();
		log.info("Driver instance name: " + driverInstance);

		String browserDriver = null;

		try {
			if (driverInstance.contains("firefox")) {
				browserDriver = "geckodriver";
			} else if (driverInstance.contains("chrome")) {
				browserDriver = "chromedriver";
			} else if (driverInstance.contains("edge")) {
				browserDriver = "msedgedriver";
			} else {
				browserDriver = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriver + "*\"";
			} else {
				cmd = "pkill " + browserDriver;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
