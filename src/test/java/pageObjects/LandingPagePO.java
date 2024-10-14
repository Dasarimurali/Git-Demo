package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dependencyInjection.Container;

public class LandingPagePO {

	WebDriver driver;

	By search = By.cssSelector("[type='search']");

	By productName = By.xpath("//h4[@class='product-name']");

	private By increment = By.xpath("//a[@class='increment']");

	private By addToCart = By.cssSelector("[class='product-action'] [type='button']");

	public LandingPagePO(WebDriver driver) {

		this.driver = driver;
		// PageFactory.initElements(this, driver);
		// PageFactory.initElements(driver, this);
	}

	public void searchItem(String item) {

		driver.findElement(search).sendKeys(item);

	}

	public String getproductName() {

		// driver.findElement(productName).getText().split("-")[0].trim()

		return driver.findElement(productName).getText().split("-")[0].trim();

	}

	public void setIncrement(int no) {

		for (int i = 1; i <= no-1; i++) {

			driver.findElement(increment).click();

		}

	}

	public void clickOnAddToCart() {

		driver.findElement(addToCart).click();

	}

}
