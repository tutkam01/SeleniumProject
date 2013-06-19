package tutka.mateusz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tutka.mateusz.model.User;

public class LoginPage extends FinserPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(User user, LoginMode loginMode) {

		switch (loginMode) {
		case LOGIN:
			driver.findElement(By.cssSelector(".username>input")).sendKeys(user.getLogin());
			break;
		case MAIL:
			driver.findElement(By.cssSelector(".username>input")).sendKeys(user.getMailAddress());
			break;
		}

		driver.findElement(By.cssSelector(".password>input")).sendKeys(user.getPassword());
		clickLogin();

	}

	public void login(User user) {
		login(user, LoginMode.LOGIN);
	}

	public String getLoggedUserLogin() {
		return driver.findElement(By.cssSelector("[id='session'] a[class='uiMenu']")).getText().trim();

	}

	public boolean isLoginFormDisplayed() {
		return driver.findElement(By.cssSelector(".submenu.loginForm")).isDisplayed();
	}

	private void clickLogin() {
		driver.findElement(By.cssSelector(".submit>input")).click();
	}

	public enum LoginMode {
		LOGIN, MAIL;
	}

}
