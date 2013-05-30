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

@lombok.Data
@lombok.ToString

@XmlRootElement(name="finserusers")
public class Users {

	private Map<String, User> usersMap;

	public Users() {
		this.usersMap = new HashMap<String, User>();
	}

}
