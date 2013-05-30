package tutka.mateusz.config;

import java.util.Map;

import tutka.mateusz.model.User;
import tutka.mateusz.model.Users;
import tutka.mateusz.techutils.JaxbUtils;

public class Configuration {
	private static Map<String, User> usersMap;
	public static Map<String, User>  getUsers(){
		if (usersMap == null) {
			Users users = JaxbUtils
					.unmarshalXml(Users.class, System.getProperty("user.dir")
							+ "/src/resources/users.xml");
			usersMap = users.getUsersMap();
		}
		return usersMap;
	}

}
