package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.AddToCartPO;
import pageObjects.LandingPagePO;
import pageObjects.OfferspagePO;

public class PageObjectManager {

	private WebDriver driver;

	private LandingPagePO landingPage;

	private OfferspagePO offersPage;

	private AddToCartPO addtocartpage;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;
	}

	public LandingPagePO getLandingPageObj() {

		if (landingPage == null) {
			landingPage = new LandingPagePO(driver);
		}
		return landingPage;

	}

	public OfferspagePO getOfferspageObj() {

		return (offersPage == null) ? new OfferspagePO(driver) : offersPage;

	}

	public AddToCartPO getAddToCartPageObj() {

		return (addtocartpage == null) ? new AddToCartPO(driver) : addtocartpage;
	}

}
