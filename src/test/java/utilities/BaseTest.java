package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {

	private WebDriver driver;

	public WebDriver initilizeBrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src\\main\\java\\globalProperties\\GlobalData.properties");

		prop.load(fis);
		String broswerProp = prop.getProperty("browser");
		
		String mvn_browser = System.getProperty("browser");
		
		String broswerName = (mvn_browser != null ? mvn_browser : broswerProp  );
		
		if (driver == null) {

			if (broswerName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
			if (broswerName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			if (broswerName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			if (broswerName.equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.manage().window().maximize();

		}

		return driver;

	}

}
