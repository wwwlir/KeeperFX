package keepapp.logic;

import keepapp.model.AppSettings;

public class InitApp {
	
	InitApp(){
//		defaultSettingsInitial();
		SettingsInitial();
	}
	public static void Initialize(){
		new InitApp();
	}

	private void defaultSettingsInitial() {
		// TODO Auto-generated method stub
		AppSettings settings = new AppSettings();
		settings.setPathDataBase("C:\\FirebirdDatabase\\FDBT.FDB");
		SettingsRepository.setSettings(settings);
	}
	private void SettingsInitial(){
		SettingsRepository.readSettings();
	}
	
}
