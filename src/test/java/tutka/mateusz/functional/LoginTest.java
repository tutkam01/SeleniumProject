package tutka.mateusz.functional;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tutka.mateusz.config.SeleniumConfiguration;
import tutka.mateusz.pages.LoginPage;

public class LoginTest extends SeleniumConfiguration {
	LoginPage loginPage;
	@BeforeClass
	public void setup(){
		initialize();
		launchSelenium();
	}
	public void initialize(){
		loginPage = new LoginPage(getWebDriver());
	}
	@Test(enabled = true)
	public void shouldBeLoginFormPresentOnTheMainPage(){
		
	}
	@Test(enabled = false)
	public void shouldLoginByLogin(){
		
		
	}

}
