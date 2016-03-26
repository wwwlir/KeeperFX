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
import keepapp.view.MainLayoutController;
import keepapp.view.PersonLayoutController;
import keepapp.view.RootLayoutController;

public class MainApp extends Application {
	
	Stage primaryStage;
	BorderPane rootLayout;
	public AnchorPane personLayout;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Title");
		//this.primaryStage.getIcons().add(new Image("file:resources/images/Address_Book.png"));
		try {
			initRootLayout();
			showMainLayout();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void initRootLayout() throws IOException{
		try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
	        rootLayout = (BorderPane) loader.load();
	        Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        RootLayoutController controller = loader.getController();
	        //controller.setMainApp(this);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void showMainLayout() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("View/MainLayout.fxml"));
		AnchorPane mainLayout = (AnchorPane)loader.load();
		rootLayout.setCenter(mainLayout);
		MainLayoutController mainLController = loader.getController();
		mainLController.setMainApp(this);
	}
	public void showPersonLayout(){
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/PersonLayout.fxml"));
            personLayout = (AnchorPane) loader.load();
            rootLayout.setCenter(personLayout);
            PersonLayoutController controller = loader.getController();
            controller.setMainApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
