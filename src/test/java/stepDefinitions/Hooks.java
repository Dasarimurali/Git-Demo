package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import dependencyInjection.Container;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private Container container;

	private WebDriver driver;

	public Hooks(Container container) throws IOException {
		// TODO Auto-generated constructor stub

		this.container = container;

		// driver = container.getDriver();
	}

	@Before
	public void beofre() {
		System.out.println("Hooks Before");
	}

	@After
	public void CloseTheBrowser() throws IOException {
		container.getDriver().quit();
	}

	@AfterStep
	public void screenshotForFailedScenarios(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {

			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			byte[] bytefile = FileUtils.readFileToByteArray(file);
			
			scenario.attach(bytefile, "image/PNG", "image.PNG");
		}

	}

}
