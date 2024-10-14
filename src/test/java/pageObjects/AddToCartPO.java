package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPO {

	private WebDriver driver;

	private By productNamePath = By.xpath("//p[@class='product-name']");

	private String productName;

	private By cartBag = By.cssSelector("[alt='Cart']");

	private By promoBtn = By.cssSelector(".promoBtn");

	private By promoTxtBox = By.cssSelector(".promoCode");

	private By promoInfo = By.cssSelector(".promoInfo");

	private By palceOrder = By.xpath("//button[text()='Place Order']");

	private By proceedToCheckOut = By.cssSelector("div[class='cart-preview active'] button[type='button']");

	public AddToCartPO(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public String getProductName() {

		productName = driver.findElement(productNamePath).getText().split("-")[0].trim();

		return productName;

	}

	public void clickCartBag() {
		driver.findElement(cartBag).click();
	}

	public void proccedToCheckOut() {

		driver.findElement(proceedToCheckOut).click();

	}

	public void enterPromo(String promo) {

		driver.findElement(promoTxtBox).sendKeys(promo);

	}

	public void clickOnPromobtn() {

		driver.findElement(promoBtn).click();

	}

	public String getPromoInfo() {

		return driver.findElement(promoInfo).getText();
	}

	public void clickOnpalceOrder() {

		driver.findElement(palceOrder).click();
	}
	
	public By getBypromoInfo()
	{
		return promoInfo;
	}
}
