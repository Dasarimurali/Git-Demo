package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import dependencyInjection.Container;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import pageObjects.LandingPagePO;

public class LandingPageStepDefinitions {

	private WebDriver driver;
	private String ProductName;
	private Container container;

	private PageObjectManager pageObjectManager;

	private LandingPagePO landingPage;

	public LandingPageStepDefinitions(Container container) throws IOException {

		this.container = container;

		driver = container.getDriver();

	}

	@Given("I am in Landing page")
	public void i_am_in_landing_page() throws IOException {

		// container.driver = new ChromeDriver();//

		// Container container = new Container();

		// container.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

	}

	@When("^I Search the product (.+) from Home Page Product appreas$")
	public void i_search_the_product_from_home_page_product_appears(String veggieName) throws InterruptedException {

		// pageObjectManager = new PageObjectManager(container.driver);

		landingPage = container.getPageObjectmanager().getLandingPageObj();

		landingPage.searchItem(veggieName);

		// visibilityOfByEleLocated

		Thread.sleep(2000);

		/*
		 * LandingPagePO landingpage = new LandingPagePO(container.driver);
		 * landingpage.searchItem(veggieName);
		 * //container.driver.findElement(By.cssSelector("[type='search']")).sendKeys(
		 */

		container.setProductName(landingPage.getproductName());

		// landingText = veggieName;

		// container.ProductName = landingPage.getproductName();
		// String ProductName =
		// container.driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
		System.out.println(landingPage.getproductName() + " From Home page");

	}

	@Then("^Increase the Quanitiy by (.+) on the product and click on Add to Cart$")
	public void increase_the_quanitiy_on_the_product_and_click_on_add_to_cart(int num) {

		landingPage.setIncrement(num);
		landingPage.clickOnAddToCart();

	}

}
