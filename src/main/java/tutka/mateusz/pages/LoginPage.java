package tutka.mateusz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tutka.mateusz.model.User;

public class LoginPage extends FinserPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(User user, LoginMode loginMode) {
		getLoginForm().login(user, loginMode);
	}

	private void fillAuthenticationData(User user, LoginMode loginMode, String loginCss, String passwordCss) {
		switch (loginMode) {
		case LOGIN:
			driver.findElement(By.cssSelector(loginCss)).sendKeys(user.getLogin());
			break;
		case MAIL:
			driver.findElement(By.cssSelector(loginCss)).sendKeys(user.getMailAddress());
			break;
		}
		driver.findElement(By.cssSelector(passwordCss)).sendKeys(user.getPassword());
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

	private void clickLogin2() {
		driver.findElement(By.cssSelector("[id='login'] input[type='submit']")).click();
	}

	public enum LoginMode {
		LOGIN, MAIL;
	}

	interface LoginInterface {
		void login(User user, LoginMode loginMode);
	}

	class Login1 implements LoginInterface {

		@Override
		public void login(User user, LoginMode loginMode) {
			fillAuthenticationData(user, loginMode, ".username>input", ".password>input");
			clickLogin();
		}

	}

	class Login2 implements LoginInterface {

		@Override
		public void login(User user, LoginMode loginMode) {
			fillAuthenticationData(user, loginMode, "[id='login'] input[name='username']",
					"[id='login'] input[name='password']");
			clickLogin2();
		}

	}

	private LoginInterface getLoginForm() {
		if (driver.findElement(By.cssSelector(".submenu.loginForm")).isDisplayed()) {
			return new Login1();
		} else {
			return new Login2();
		}
	}

}
