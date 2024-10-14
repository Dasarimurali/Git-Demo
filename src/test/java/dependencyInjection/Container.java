package dependencyInjection;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import managers.PageObjectManager;
import utilities.BaseTest;
import utilities.CommionUtilities;

public class Container {

	private WebDriver driver;
	private String productName;

	private String name;

	private CommionUtilities utils;

	private BaseTest baseTest;

	private PageObjectManager pageObjectmanager;

	public Container() throws IOException {

		baseTest = new BaseTest();

		driver = baseTest.initilizeBrowser();

		pageObjectmanager = new PageObjectManager(driver);

		utils = new CommionUtilities(driver);

	}

	public WebDriver getDriver() throws IOException {

		// driver = baseTest.initilizeBrowser();
		return driver;
	}

	public String getProductName() {
		return productName;
	}

	public String getName() {
		return name;
	}

	public CommionUtilities getUtils() {
		return utils;
	}

	public BaseTest getBaseTest() {
		return baseTest;
	}

	public PageObjectManager getPageObjectmanager() {

		return pageObjectmanager;
	}

	public void setProductName(String productName) {

		this.productName = productName;
		// TODO Auto-generated method stub

	}

}
