package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;

public class OfferspagePO {

	public WebDriver driver;

	By topDeals = By.linkText("Top Deals");

	By search = By.cssSelector("#search-field");

	By prodName = By.xpath("//tr/td[1]");

	public OfferspagePO(WebDriver driver) {

		this.driver = driver;

	}

	public void clickOnLink() {

		driver.findElement(topDeals).click();
	}

	public void searchItem(String name) {

		driver.findElement(search).sendKeys(name);

	}

	public String getProdName() {

		return driver.findElement(prodName).getText();

	}

	// @After
	public void CloseTheBrowser() throws IOException {
		
		System.out.println("After Annothation in Cucumber");
		driver.close();
	}

}
