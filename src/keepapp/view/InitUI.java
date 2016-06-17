package keepapp.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import keepapp.MainApp;
import keepapp.model.Account;
import keepapp.model.Link;
import keepapp.model.Note;
import keepapp.model.Person;
import keepapp.view.KeeLinkLayers.KeeLinkEditDialogController;
import keepapp.view.KeeLinkLayers.KeeLinkLayoutController;
import keepapp.view.KeePassLayers.KeePassEditDialogController;
import keepapp.view.KeePassLayers.KeePassLayoutController;
import keepapp.view.NoteLayers.NoteEditDialogController;
import keepapp.view.NoteLayers.NoteLayoutController;
import keepapp.view.PersonLayers.PersonEditDialogController;
import keepapp.view.PersonLayers.PersonLayoutController;
import keepapp.view.SettingsLayers.SettingsEditDialogController;

public class InitUI extends Application {
	private static Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(final Stage primaryStage) throws Exception {//final Stage primaryStage При объявлении переменной final обязательно ее инициализация, но не в параметрах
		Thread.sleep(10000);
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
	public void init(){//Инициализация перед методом start()
		
	}
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	private FXMLLoader getLoader(String resource){
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource(resource));
		return loader;		
	}
	//
	public void initRootLayout() throws IOException{
		try {
			FXMLLoader loader = getLoader("view/RootLayout.fxml");
	        rootLayout = (BorderPane) loader.load();
	        Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        RootLayoutController controller = loader.getController();
	        controller.setInitUI(this);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void showMainLayout(){
		try {
			FXMLLoader loader = getLoader("View/MainLayout.fxml");
			AnchorPane mainLayout = (AnchorPane)loader.load();
			rootLayout.setCenter(mainLayout);
			MainLayoutController mainLController = loader.getController();
//			mainLController.setMainApp(this);
			mainLController.setLayout(mainLayout);
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
	public void closeMainLayout(){
		
	}
	public void showPersonLayout(){
		try {
			FXMLLoader loader = getLoader("View/PersonLayers/PersonLayout.fxml");
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
	
	public void showKeePassLayout() {
		try {
			FXMLLoader loader = getLoader("View/KeePassLayers/KeePassLayout.fxml");
            BorderPane keepassLayout = (BorderPane) loader.load();
            rootLayout.setCenter(keepassLayout);
            KeePassLayoutController controller = loader.getController();
            controller.setMainApp(this);
//            controller.setItemsAccount();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public static boolean showAccountEditDialog(Account account) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/KeePassLayers/KeePassEditDialog.fxml"));
			AnchorPane page = (AnchorPane)loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit account");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        KeePassEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setAccount(account);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
	        return false;
		}
	}
	
	public void showKeeLinkLayout() {
		try {
			FXMLLoader loader = getLoader("View/KeeLinkLayers/KeeLinkLayout.fxml");
            BorderPane keelinkLayout = (BorderPane) loader.load();
            rootLayout.setCenter(keelinkLayout);
            KeeLinkLayoutController controller = loader.getController();
            controller.setMainApp(this);
//            controller.setItemsAccount();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public static boolean showLinkEditDialog(Link link) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/KeeLinkLayers/KeeLinkEditDialog.fxml"));
			AnchorPane page = (AnchorPane)loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit link");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        KeeLinkEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setLink(link);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
	        return false;
		}
	}
	
	public boolean showSettingsEditDialog(){
		try{
			FXMLLoader loader = getLoader("view/SettingsLAyers/SettingsEditDialog.fxml");
			AnchorPane pane = (AnchorPane)loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Settings edit");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(pane);
			dialogStage.setScene(scene);
			
			SettingsEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			
			dialogStage.showAndWait();
		}catch(IOException e){
			
		}
		
		return true;
	}
	public void showNoteLayout() {
		try {
            FXMLLoader loader = getLoader("View/NoteLayers/NoteLayout.fxml");
            
            BorderPane noteLayout = (BorderPane) loader.load();
//            BorderPane noteLayout = (BorderPane) loader.load();
            rootLayout.setCenter(noteLayout);
            NoteLayoutController controller = loader.getController();
            controller.setMainApp(this);
//            controller.setItemsAccount();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public void showPlanDayLayout() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean showNoteEditDialog(Note note){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/NoteLayers/NoteEditDialog.fxml"));
			AnchorPane page = (AnchorPane)loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit note");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        NoteEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setNote(note);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
	        return false;
		}
	}

}
