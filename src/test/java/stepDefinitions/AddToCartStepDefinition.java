package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;

import dependencyInjection.Container;
import io.cucumber.java.en.Then;
import pageObjects.AddToCartPO;
import pageObjects.LandingPagePO;

public class AddToCartStepDefinition {

	private Container container;

	private AddToCartPO addToCatPage;

	private LandingPagePO landingPage;
	
	//public By promoInfo = By.cssSelector(".promoInfo");

	public AddToCartStepDefinition(Container container) {
		// TODO Auto-generated constructor stub
		this.container = container;
		
		addToCatPage = container.getPageObjectmanager().getAddToCartPageObj();
	}

	@Then("Click on Cart Icon")
	public void click_on_cart_icon() {
		//addToCatPage = container.getPageObjectmanager().getAddToCartPageObj();
		
		addToCatPage.clickCartBag();
		addToCatPage.proccedToCheckOut();
	}

	@Then("Validate the Product Name is displayed in cart page")
	public void validate_the_product_name_is_displayed_in_cart_page() {

		//addToCatPage = container.getPageObjectmanager().getAddToCartPageObj();

		System.out.println("Product Name from Cart "+ addToCatPage.getProductName());
		
		Assert.assertEquals(container.getProductName(), addToCatPage.getProductName());
	}
	
	@Then("^Verify user has Ability to enter Promocode (.+) and Place Order$")
	public void verify_user_has_ability_to_enter_promocode_and_place_order(String promo) throws InterruptedException {
	   
		
		addToCatPage.enterPromo(promo);
		addToCatPage.clickOnPromobtn();
		//Thread.sleep(5000);
		container.getUtils().waitVisibilityOfByEleLocated(addToCatPage.getBypromoInfo());
		String promoTXT = addToCatPage.getPromoInfo();
		
		Assert.assertEquals(promoTXT, "Code applied ..!");
		
		addToCatPage.clickOnpalceOrder();
	}
	

}
