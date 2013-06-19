package tutka.mateusz.functional;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tutka.mateusz.config.Configuration;
import tutka.mateusz.config.SeleniumConfiguration;
import tutka.mateusz.model.User;
import tutka.mateusz.pages.LoginPage;
import tutka.mateusz.pages.LoginPage.LoginMode;
import tutka.mateusz.pages.MainPage;

public class LoginTest extends SeleniumConfiguration {
	private static final String START_PAGE_URL = "http://finser.pl";
	LoginPage loginPage;
	User finserUser;
	MainPage mainPage;

	@BeforeClass
	public void setup() {
		launchSelenium();
		initialize();
	}

	public void initialize() {
		loginPage = new LoginPage(getWebDriver());
		mainPage = new MainPage(getWebDriver());
		finserUser = Configuration.getUsers().get("finserSelenium");
	}

	@AfterClass
	public void quit() {
		stopSelenium();
	}

	/**
	 * I am checking if the form used to login is present and displayed.
	 */
	@Test(priority = 1, enabled = true)
	public void shouldBeLoginFormPresentOnTheMainPage() {
		Assert.assertTrue(loginPage.isLoginFormDisplayed(), "Lack of form dedicated to login purpose.");
	}

	/**
	 * I am checking if I am able to login by user's login.
	 */
	@Test(priority = 2, enabled = true)
	public void shouldLoginByLogin() {
		loginPage.login(finserUser, LoginMode.LOGIN);
		Assert.assertEquals(loginPage.getLoggedUserLogin(), finserUser.getLogin(), "Login process failed!");
		goBackToLoginPage();
	}

	/**
	 * I am checking if I am able to login by user's mail address.
	 */
	@Test(priority = 3, enabled = true)
	public void shouldLoginByMail() {
		loginPage.login(finserUser, LoginMode.MAIL);
		Assert.assertEquals(loginPage.getLoggedUserLogin(), finserUser.getLogin(), "Login process failed!");
		goBackToLoginPage();
	}

	private void goBackToLoginPage() {
		mainPage.logout();
		getWebDriver().get(START_PAGE_URL);
	}
}
