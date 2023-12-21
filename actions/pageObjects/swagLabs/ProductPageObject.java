package pageObjects.swagLabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.swagLabs.ProductPageUI;

public class ProductPageObject extends BasePage {
	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPageTitleDisplayed() {
		waitElementVisible(driver, ProductPageUI.PAGE_TITLE);
		return isElementDisplayed(driver, ProductPageUI.PAGE_TITLE);
	}

	public void sortDataByProductName(String optionValue) {
		waitElementClickable(driver, ProductPageUI.SORT_DROPDOWN);
		selectOptionInDefaultDropdown(driver, ProductPageUI.SORT_DROPDOWN, optionValue);
	}

	public boolean isProductNameSortASC() {
		waitAllElementsVisible(driver, ProductPageUI.PRODUCT_NAMES);

		List<WebElement> productNames = getListWebElement(driver, ProductPageUI.PRODUCT_NAMES);

		List<String> productNamesUI = new ArrayList<String>();

		for (WebElement productName : productNames) {
			productNamesUI.add(productName.getText());
		}

		System.out.println("--------productNamesUI--------");
		for (String nameUI : productNamesUI) {
			System.out.println(nameUI);
		}

		List<String> productNamesUISorted = new ArrayList<String>(productNamesUI);

		Collections.sort(productNamesUISorted);

		System.out.println("--------productNamesUISorted--------");
		for (String nameUISorted : productNamesUISorted) {
			System.out.println(nameUISorted);
		}

		return productNamesUISorted.equals(productNamesUI);
	}

	public boolean isProductNameSortDESC() {
		waitAllElementsVisible(driver, ProductPageUI.PRODUCT_NAMES);

		List<WebElement> productNames = getListWebElement(driver, ProductPageUI.PRODUCT_NAMES);

		List<String> productNamesUI = new ArrayList<String>();

		for (WebElement productName : productNames) {
			productNamesUI.add(productName.getText());
		}

		System.out.println("--------productNamesUI--------");
		for (String nameUI : productNamesUI) {
			System.out.println(nameUI);
		}

		List<String> productNamesUISorted = new ArrayList<String>(productNamesUI);

		Collections.sort(productNamesUISorted);
		Collections.reverse(productNamesUISorted);

		System.out.println("--------productNamesUISorted--------");
		for (String nameUISorted : productNamesUISorted) {
			System.out.println(nameUISorted);
		}

		return productNamesUISorted.equals(productNamesUI);
	}

	public boolean isProductPriceSortASC() {
		waitAllElementsVisible(driver, ProductPageUI.PRODUCT_PRICES);

		List<WebElement> productPrices = getListWebElement(driver, ProductPageUI.PRODUCT_PRICES);

		List<Float> productPricesUI = new ArrayList<Float>();

		for (WebElement productPrice : productPrices) {
			productPricesUI.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		System.out.println("--------productNamesUI--------");
		for (Float priceUI : productPricesUI) {
			System.out.println(priceUI);
		}

		List<Float> productPricesUISorted = new ArrayList<Float>(productPricesUI);

		Collections.sort(productPricesUISorted);

		System.out.println("--------productNamesUISorted--------");
		for (Float priceUISorted : productPricesUISorted) {
			System.out.println(priceUISorted);
		}

		return productPricesUISorted.equals(productPricesUI);
	}

	public boolean isProductPriceSortDESC() {
		waitAllElementsVisible(driver, ProductPageUI.PRODUCT_PRICES);

		List<WebElement> productPrices = getListWebElement(driver, ProductPageUI.PRODUCT_PRICES);

		List<Float> productPricesUI = new ArrayList<Float>();

		for (WebElement productPrice : productPrices) {
			productPricesUI.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		System.out.println("--------productNamesUI--------");
		for (Float priceUI : productPricesUI) {
			System.out.println(priceUI);
		}

		List<Float> productPricesUISorted = new ArrayList<Float>(productPricesUI);

		Collections.sort(productPricesUISorted);
		Collections.reverse(productPricesUISorted);

		System.out.println("--------productNamesUISorted--------");
		for (Float priceUISorted : productPricesUISorted) {
			System.out.println(priceUISorted);
		}

		return productPricesUISorted.equals(productPricesUI);
	}

}
