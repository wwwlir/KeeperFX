package keepapp.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import keepapp.MainApp;

public class MainLayoutController {
	private MainApp mainApp;
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
	@FXML
	private void inicialize(){
		
	}
	@FXML
	private void showPersonView(){
		mainApp.showPersonLayout();
	}
}
