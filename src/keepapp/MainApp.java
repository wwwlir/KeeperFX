package keepapp;

import javafx.application.Application;
import keepapp.logic.InitApp;
import keepapp.view.InitUI;

public class MainApp{
	public static void main(String[] args) {
		InitApp.Initialize();
		Application.launch(InitUI.class,args);
	}
}
