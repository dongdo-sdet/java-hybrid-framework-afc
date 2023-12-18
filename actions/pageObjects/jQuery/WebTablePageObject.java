package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.WebTablePageUI;

public class WebTablePageObject extends BasePage {
	private WebDriver driver;

	public WebTablePageObject(WebDriver driver) {
		this.driver = driver;
	}

	// Pagination WebTable

	public void clickToPaginationPageByNumber(String pageNumber) {
		waitElementClickable(driver, WebTablePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, WebTablePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public boolean isPaginationPageActiveByNumber(String pageNumber) {
		waitElementVisible(driver, WebTablePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, WebTablePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public void sendKeysToFilterTextboxByColumnLabel(String columnLabel, String keysToSend) {
		waitElementVisible(driver, WebTablePageUI.FILTER_TEXTBOX_BY_LABEL, columnLabel);
		sendKeysToElement(driver, WebTablePageUI.FILTER_TEXTBOX_BY_LABEL, keysToSend, columnLabel);
		sendKeyboardToElement(driver, WebTablePageUI.FILTER_TEXTBOX_BY_LABEL, Keys.ENTER, columnLabel);
	}

	public boolean isRowDisplayedByValues(String female, String country, String male, String total) {
		waitElementVisible(driver, WebTablePageUI.ROW_BY_VALUES, female, country, male, total);
		return isElementDisplayed(driver, WebTablePageUI.ROW_BY_VALUES, female, country, male, total);
	}

	public List<String> getAllValuesByColumnLabelAllPages(String columnLabel) {
		List<String> allValuesOfColumn = new ArrayList<>();
		int columnIndex = getNumberOfElements(driver, WebTablePageUI.COLUMN_INDEX_BY_LABEL, columnLabel) + 1;
		int numberOfPages = getNumberOfElements(driver, WebTablePageUI.ALL_PAGINATION_PAGES);
		for (int i = 1; i <= numberOfPages; i++) {
			clickToPaginationPageByNumber(String.valueOf(i));
			List<WebElement> allRows = getListWebElement(driver, WebTablePageUI.ALL_ROW_VALUES_BY_COLUMN_INDEX, String.valueOf(columnIndex));
			for (WebElement eachRow : allRows) {
				allValuesOfColumn.add(eachRow.getText());
			}
		}
		for (String value : allValuesOfColumn) {
			System.out.println(value);
		}
		return allValuesOfColumn;
	}

	// Dynamic WebTable

	public void sendKeysToTextboxByRowNumberAndColumnLabel(String rowNumber, String columnLabel, String keysToSend) {
		int columnIndex = getNumberOfElements(driver, WebTablePageUI.COLUMN_INDEX_BY_COLUMN_LABEL, columnLabel) + 1;
		waitAllElementsVisible(driver, WebTablePageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		sendKeysToElement(driver, WebTablePageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, keysToSend, rowNumber, String.valueOf(columnIndex));
	}

	public void selectDropdownByRow(String rowNumber, String optionValue) {
		waitAllElementsVisible(driver, WebTablePageUI.DROPDOWN_BY_ROW, rowNumber);
		selectOptionInDefaultDropdown(driver, WebTablePageUI.DROPDOWN_BY_ROW, optionValue, rowNumber);
	}

	public void checkToCheckboxByRow(String rowNumber) {
		waitElementClickable(driver, WebTablePageUI.CHECKBOX_BY_ROW, rowNumber);
		checkToDefaultCheckboxOrRadioButton(driver, WebTablePageUI.CHECKBOX_BY_ROW, rowNumber);
	}

	public void uncheckToCheckboxByRow(String rowNumber) {
		waitElementClickable(driver, WebTablePageUI.CHECKBOX_BY_ROW, rowNumber);
		uncheckToDefaultCheckbox(driver, WebTablePageUI.CHECKBOX_BY_ROW, rowNumber);
	}

	public void setDayMonthYearToDatePickerByRow(String rowNumber, String dateValue) {
		waitAllElementsVisible(driver, WebTablePageUI.DATE_PICKER_BY_ROW, rowNumber);
		removeElementAttributeInDOMByJS(driver, WebTablePageUI.DATE_PICKER_BY_ROW, "type", rowNumber);
		sendKeysToElement(driver, WebTablePageUI.DATE_PICKER_BY_ROW, dateValue, rowNumber);
	}

	public void clickToIconByRowNumber(String rowNumber, String iconTitle) {
		waitElementClickable(driver, WebTablePageUI.ICON_BY_ROW_AND_TITLE, rowNumber, iconTitle);
		clickToElement(driver, WebTablePageUI.ICON_BY_ROW_AND_TITLE, rowNumber, iconTitle);
	}

	public void clickToLoadDataButton() {
		waitElementClickable(driver, WebTablePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver, WebTablePageUI.LOAD_DATA_BUTTON);
	}

	public void clickToAppendRowButton() {
		waitElementClickable(driver, WebTablePageUI.APPEND_ROW_BUTTON);
		clickToElement(driver, WebTablePageUI.APPEND_ROW_BUTTON);
	}

	public void clickToRemoveLastRowButton() {
		waitElementClickable(driver, WebTablePageUI.REMOVE_LAST_ROW_BUTTON);
		clickToElement(driver, WebTablePageUI.REMOVE_LAST_ROW_BUTTON);
	}

}
