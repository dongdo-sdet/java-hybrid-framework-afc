package commons;

import java.io.File;

public class GlobalConstants {

	public static final String PAGINATION_WEB_TABLE_URL = "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/";
	public static final String DYNAMIC_WEB_TABLE_URL = "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/";
	public static final String UPLOAD_FILE_URL = "https://blueimp.github.io/jQuery-File-Upload/";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String UPLOAD_FILE_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String EXTENT_REPORTS_PATH = PROJECT_PATH + File.separator + "extentReports-output" + File.separator;

	public static final long LONG_TIMEOUT = 30;
	public static final long ONE_SECOND = 1;

}
