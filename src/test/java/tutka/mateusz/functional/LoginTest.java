package tutka.mateusz.functional;

import static org.testng.AssertJUnit.assertEquals;

import org.junit.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tutka.mateusz.config.Configuration;
import tutka.mateusz.config.SeleniumConfiguration;
import tutka.mateusz.model.User;
import tutka.mateusz.pages.LoginPage;

public class LoginTest extends SeleniumConfiguration {
	LoginPage loginPage;
	User finserUser;
	@BeforeClass
	public void setup(){
		launchSelenium();
		initialize();
		finserUser = Configuration.getUsers().get("finserSelenium");
	}
	public void initialize(){
		loginPage = new LoginPage(getWebDriver());
	}
	@AfterClass
	public void quit(){
		stopSelenium();
	}
	@Test(enabled = false)
	public void shouldBeLoginFormPresentOnTheMainPage(){
		
	}
	@Test(enabled = true)
	public void shouldLoginByLogin(){
		loginPage.loginByLogin(finserUser);
		assertEquals(finserUser.getLogin(), loginPage.getLoggedUserLogin());
		
		
	}

}
