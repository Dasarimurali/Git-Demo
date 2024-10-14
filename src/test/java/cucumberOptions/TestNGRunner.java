package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\features", glue = "stepDefinitions", monochrome = true, /*
																										 * dryRun = true
																										 * ,
																										 */
		tags = "@Regression", plugin = { "html:target/CucumberReports/cucumber.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/Failed_Scenarios.txt"})
public class TestNGRunner extends AbstractTestNGCucumberTests {

	// Run test parllely in Cucumber Runner
	// @Override
	@DataProvider(parallel = true)
	public Object[][] Senarios() {

		return super.scenarios();

	}

}

// Q/A
/*
 * how do you make your test run parallel in cucumber using TestNGRunner
 * 
 * will call the scenarios method from its parent class and set the parallel
 * attribue = ture from the data provider
 * 
 */
