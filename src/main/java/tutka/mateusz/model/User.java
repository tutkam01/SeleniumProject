package tutka.mateusz.model;

import javax.xml.bind.annotation.XmlRootElement;

@lombok.Data
@lombok.ToString
@XmlRootElement
public class User {
 private String firstName;
 private String lastName;
 private String mailAddress;
 private String login;
 private String password;
}
