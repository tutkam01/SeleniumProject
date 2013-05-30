package tutka.mateusz.functional;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tutka.mateusz.config.Configuration;
import tutka.mateusz.config.SeleniumConfiguration;
import tutka.mateusz.model.User;
import tutka.mateusz.model.Users;
import tutka.mateusz.techutils.JaxbUtils;

public class PrzykladowyTest extends SeleniumConfiguration{
 @BeforeClass
 public void initialize(){
	 //launchSelenium();
 }
 @Test
 public void przyklad(){
	  User user = new User();
	  user.setFirstName("finserSelenium");
	  user.setLastName("AutoUser");
	  user.setLogin("finserSelenium");
	  user.setMailAddress("lebrosso@poczta.fm");
	  user.setPassword("Fins@r.1");
	  Users users = new Users();
	  users.getUsersMap().put(user.getLogin(), user);
	  JaxbUtils.marshalObject(users,System.getProperty("user.dir") + "/src/resources/users.xml");
	 // Users users = JaxbUtils.unmarshalXml(Users.class, System.getProperty("user.dir") + "/src/resources/users.xml");
	 // getWebDriver().quit();
	  System.out.println(Configuration.getUsers());
	  System.out.println(Configuration.getUsers());
	  
	  
 }
}
