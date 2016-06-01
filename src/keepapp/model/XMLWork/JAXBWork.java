package keepapp.model.XMLWork;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import keepapp.model.AppSettings;

public class JAXBWork {
	public static boolean save(AppSettings settings, String filePath){
		try {
			JAXBContext context = JAXBContext.newInstance(AppSettings.class);
			Marshaller m = context.createMarshaller();
			
			m.marshal(settings, new FileOutputStream(filePath));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	public static AppSettings read(File file){
		try {
			JAXBContext context = JAXBContext.newInstance(AppSettings.class);
			Unmarshaller um = context.createUnmarshaller();
			
			AppSettings settings = (AppSettings)um.unmarshal(file);
			return settings;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
