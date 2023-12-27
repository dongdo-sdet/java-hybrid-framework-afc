package commons;

import java.io.File;

public class GlobalConstants {

	public static final String DEV_NOPCOMMERCE_USER_URL = "https://dev.nopcommerce.com/";
	public static final String TEST_NOPCOMMERCE_USER_URL = "https://test.nopcommerce.com/";
	public static final String DEMO_NOPCOMMERCE_USER_URL = "https://demo.nopcommerce.com/";
	public static final String PROD_NOPCOMMERCE_USER_URL = "https://prod.nopcommerce.com/";

	public static final String DEV_NOPCOMMERCE_ADMIN_URL = "https://admin-dev.nopcommerce.com/";
	public static final String TEST_NOPCOMMERCE_ADMIN_URL = "https://admin-test.nopcommerce.com/";
	public static final String DEMO_NOPCOMMERCE_ADMIN_URL = "https://admin-demo.nopcommerce.com/";
	public static final String PROD_NOPCOMMERCE_ADMIN_URL = "https://admin-prod.nopcommerce.com/";

	public static final String PAGINATION_WEB_TABLE_URL = "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/";
	public static final String DYNAMIC_WEB_TABLE_URL = "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/";
	public static final String UPLOAD_FILE_URL = "https://blueimp.github.io/jQuery-File-Upload/";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String UPLOAD_FILE_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String EXTENT_REPORTS_PATH = PROJECT_PATH + File.separator + "extentReports-output" + File.separator;
	public static final String ALLURE_REPORTS_PATH = PROJECT_PATH + File.separator + "allure-results";
	public static final String TEST_DATA_PATH = PROJECT_PATH + File.separator + "testdata" + File.separator;

	public static final long LONG_TIMEOUT = 30;
	public static final long SHORT_TIMEOUT = 5;
	public static final long ONE_SECOND = 1;

}
