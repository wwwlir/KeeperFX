package keepapp.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import keepapp.MainApp;

public class MainLayoutController {

	private InitUI initUI;

	public void setMainApp(InitUI initUI) {
        this.initUI = initUI;
    }
	@FXML
	private void inicialize(){
		
	}
	@FXML
	private void showPersonView(){
		initUI.showPersonLayout();
	}
	@FXML
	private void showMainView(){
		try {
			initUI.showMainLayout();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
