package stepDefinitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dependencyInjection.Container;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import managers.PageObjectManager;
import pageObjects.OfferspagePO;

public class OffersPageStepDefinitions {

	private WebDriver driver;

	private String offersText;

	private String ProductName;

	private Container container;

	private OfferspagePO offerPage;

	private PageObjectManager pageObjectManager;

	public OffersPageStepDefinitions(Container container) throws IOException {

		this.container = container;
		
		driver = container.getDriver();

	}

	
	@Then("^Same product ShortText (.+) should be displayed in Offers Page also$")
	public void same_product_should_be_displayed_in_offers_page_also(String shorttest) throws InterruptedException {

		// pageObjectManager = new PageObjectManager(container.driver);

		offerPage = container.getPageObjectmanager().getOfferspageObj();
		// offerPage = new OfferspagePO(container.driver);

		offerPage.clickOnLink();

		// Assert.assertEquals(parent, childwindow);

		// Thread.sleep(2000);

		//switchToChildWindow();
		
		container.getUtils().switchToChlidWindow();

		// container.driver.findElement(By.cssSelector("#search-field")).sendKeys(shorttest);

		offerPage.searchItem(shorttest);
		// String offersText =
		// container.driver.findElement(By.xpath("//tr/td[1]")).getText();
		
		offerPage = container.getPageObjectmanager().getOfferspageObj();
		offersText = offerPage.getProdName();
		System.out.println(offersText + " From Offers page");

	}

	public void switchToChildWindow() {
		driver.findElement(By.linkText("Top Deals")).click();

		String parent = driver.getWindowHandle();

		// System.out.println(parent);

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> iterator = windows.iterator();

		String Parentwindow = iterator.next();

		// System.out.println(Parentwindow);

		Assert.assertEquals(parent, Parentwindow);

		String childwindow = iterator.next();

		driver.switchTo().window(childwindow);
	}

	@Then("Validate prodct matches with landing Page")
	public void validate_prodct_matches_with_landing_page() {

		Assert.assertEquals(container.getProductName(), offersText);

		// System.out.println(name);
	}
	
	
	

}
