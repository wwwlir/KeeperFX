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
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	//public AnchorPane personLayout;

	public static void main(String[] args) {launch(args);}
	@Override
	public void start(final Stage primaryStage) throws Exception {//final Stage primaryStage При объявлении переменной final обязательно ее инициализация, но не в параметрах
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
            AnchorPane personLayout = (AnchorPane) loader.load();
            rootLayout.setCenter(personLayout);
            PersonLayoutController controller = loader.getController();
            controller.setMainApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
