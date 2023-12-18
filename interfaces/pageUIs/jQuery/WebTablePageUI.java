package pageUIs.jQuery;

public class WebTablePageUI {

	// Pagination WebTable
	public static final String PAGINATION_PAGE_BY_NUMBER = "//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String FILTER_TEXTBOX_BY_LABEL = "//div[text()='%s']/parent::div/following-sibling::input";
	public static final String ROW_BY_VALUES = "//tr//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";
	public static final String ALL_PAGINATION_PAGES = "//li[@class='qgrd-pagination-page']/a";
	public static final String COLUMN_INDEX_BY_LABEL = "//div[text()='%s']/ancestor::th/preceding-sibling::th";
	public static final String ALL_ROW_VALUES_BY_COLUMN_INDEX = "//tr/td[%s]";

	// Dynamic WebTable
	public static final String COLUMN_INDEX_BY_COLUMN_LABEL = "//th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_ROW = "//tbody/tr[1]//select";
	public static final String CHECKBOX_BY_ROW = "//tbody/tr[%s]/td//input[@type='checkbox']";
	public static final String DATE_PICKER_BY_ROW = "//tbody/tr[3]/td//input[contains(@id,'memberSince')]";
	public static final String ICON_BY_ROW_AND_TITLE = "//tbody/tr[%s]//button[@title='%s']";
	public static final String LOAD_DATA_BUTTON = "//button[@id='load']";
	public static final String APPEND_ROW_BUTTON = "//button[@title='Append Row']";
	public static final String REMOVE_LAST_ROW_BUTTON = "//button[@title='Remove Last Row']";

}
