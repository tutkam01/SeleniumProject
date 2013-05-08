package tutka.mateusz.functional;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tutka.mateusz.config.SeleniumConfiguration;

public class PrzykladowyTest extends SeleniumConfiguration{
 @BeforeClass
 public void initialize(){
	 launchSelenium();
 }
 @Test
 public void przyklad(){
	  System.out.println("Udalo sie?");
	  getWebDriver().quit();
 }
}
