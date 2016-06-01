package keepapp.logic;

import java.io.File;

import keepapp.model.AppSettings;
import keepapp.model.XMLWork.JAXBWork;

public class SettingsRepository {
	public static AppSettings settings;
	public static void setSettings(AppSettings settings){
		SettingsRepository.settings = settings;
		saveSettings();
	}
	public static boolean readSettings(){
		try {
			setSettings(JAXBWork.read(new File("Settings.xml")));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static boolean saveSettings(){
		try {
			JAXBWork.save(settings, "Settings.xml");
			applySettings();
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
	private static void applySettings(){
		
	}
}
