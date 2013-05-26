package tutka.mateusz.functional;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
//	  System.out.println("Udalo sie?");
//	  User user = new User();
//	  user.setFirstName("finserSelenium");
//	  user.setLastName("AutoUser");
//	  user.setLogin("finserSelenium");
//	  user.setMailAddress("lebrosso@poczta.fm");
//	  user.setPassword("Fins@r.1");
//	  Users users = new Users();
//	  users.getUsers().add(user);
//	  JaxbUtils.marshalObject(users,System.getProperty("user.dir") + "/src/resources/users.xml");
	  Users users = JaxbUtils.unmarshalXml(Users.class, System.getProperty("user.dir") + "/src/resources/users.xml");
	 // getWebDriver().quit();
	  System.out.println(Users.getInstance().get("finserSelenium"));
	  
 }
}
