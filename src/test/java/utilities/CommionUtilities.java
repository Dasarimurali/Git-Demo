package utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommionUtilities {

	WebDriver driver;

	public CommionUtilities(WebDriver driver) {
		// TODO Auto-generated constructor stub.
		this.driver = driver;
	}

	public void switchToChlidWindow() {

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> iterator = windows.iterator();

		String Parentwindow = iterator.next();

		// System.out.println(Parentwindow);

		// Assert.assertEquals(parent, Parentwindow);

		String childwindow = iterator.next();

		driver.switchTo().window(childwindow);

	}

	public void waitVisibilityOfByEleLocated(By ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}


}
