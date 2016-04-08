package keepapp;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import keepapp.view.InitUI;
import keepapp.view.MainLayoutController;
import keepapp.view.PersonLayoutController;
import keepapp.view.RootLayoutController;

public class MainApp{
	public static void main(String[] args) {Application.launch(InitUI.class,args);}
}
