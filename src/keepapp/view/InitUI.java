package keepapp.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import keepapp.MainApp;
import keepapp.model.Person;
import keepapp.view.PersonLayers.PersonEditDialogController;
import keepapp.view.PersonLayers.PersonLayoutController;

public class InitUI extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	
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
	        controller.setInitUI(this);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void showMainLayout(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("View/MainLayout.fxml"));
			AnchorPane mainLayout = (AnchorPane)loader.load();
			rootLayout.setCenter(mainLayout);
			MainLayoutController mainLController = loader.getController();
			mainLController.setMainApp(this);
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
	public void closeMainLayout(){
		
	}
	public void showPersonLayout(){
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/PersonLayers/PersonLayout.fxml"));
            AnchorPane personLayout = (AnchorPane) loader.load();
            rootLayout.setCenter(personLayout);
            PersonLayoutController controller = loader.getController();
            controller.setMainApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public boolean showPersonEditDialog(Person person) {
	    try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/PersonLayers/PersonEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Person");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        PersonEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setPerson(person);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public Stage getPrimaryStage() {
		return primaryStage;
	}

}
