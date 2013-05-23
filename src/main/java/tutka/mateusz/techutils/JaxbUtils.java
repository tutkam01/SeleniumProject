package tutka.mateusz.techutils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JaxbUtils {
 public static <T> void marshalObject(T object, String filePath ){
	 try {
		 
			File file = new File(filePath);
			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
			jaxbMarshaller.marshal(object, file);
			jaxbMarshaller.marshal(object, System.out);
	 
		      } catch (JAXBException e) {
		    	  e.printStackTrace();
		      }
	 
		}
}

