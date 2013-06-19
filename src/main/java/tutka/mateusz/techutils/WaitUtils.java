package tutka.mateusz.techutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.seleniumemulation.WaitForPageToLoad;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tutka.mateusz.config.SeleniumConfiguration;

public class WaitUtils {
	static WebDriver driver = SeleniumConfiguration.getWebDriver();

	public static void setImplicitTimeout(long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public static void waitForPageToLoad() {
		WaitForPageToLoad waitForPageToLoad = new WaitForPageToLoad();
		waitForPageToLoad.apply(driver, new String[] { "30" });
	}

	public static void waitForWebElementPresence(By by) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void waitForWebElementPresenceAndVisibility(By by) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(by));
	}

}
