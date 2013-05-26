package tutka.mateusz.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import tutka.mateusz.techutils.JaxbUtils;

//@lombok.Data

@XmlRootElement(name="finserusers")
public class Users {
 
 private static List<User> users;
 private static Map<String,User> usersMap;
 
 @XmlElementWrapper
 @XmlElementRef
 private List<User> getUsers(){
	 return users;
 } 
 private Users(){
	 this.users = new ArrayList<User>();
 }
 public static Map<String,User> getInstance(){
	 if(usersMap==null){
		  Users testUsers = JaxbUtils.unmarshalXml(Users.class, System.getProperty("user.dir") + "/src/resources/users.xml");
		  usersMap = new HashMap<String, User>();
		  for(User user:users){
			  usersMap.put(user.getLogin(), user);
		  }
		  return usersMap;
	 }
	 
	 return usersMap;
 }
 
}
