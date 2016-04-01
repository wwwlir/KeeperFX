package keepapp.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import keepapp.MainApp;

public class MainLayoutController {
//	private MainApp mainApp;
	private InitUI initUI;
//	public void setMainApp(MainApp mainApp) {
//        this.mainApp = mainApp;
//    }
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
}
