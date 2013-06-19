package tutka.mateusz.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tutka.mateusz.techutils.WaitUtils;

public class MainPage extends FinserPage {

	public MainPage(WebDriver driver) {
		super(driver);
	}

	private void chooseAction(int actionNo) {
		WebElement seleniumUser = driver.findElement(By.cssSelector("[id='session']"));
		seleniumUser.click();
		WaitUtils.waitForWebElementPresenceAndVisibility(By.cssSelector("[id='sessionMenu']"));
		List<WebElement> menuOptions = seleniumUser.findElements(By.cssSelector("li>a"));
		menuOptions.get(actionNo - 1).click();
	}

	public void logout() {
		chooseAction(1);
		WaitUtils.waitForPageToLoad();
	}

}
