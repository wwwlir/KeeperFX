package keepapp.view;

import java.io.IOException;

import javafx.fxml.FXML;
import keepapp.MainApp;

public class RootLayoutController {

    private MainApp mainApp;
    private InitUI initUI;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    public void setInitUI(InitUI initUI){
    	this.initUI = initUI;
    }

    @FXML
    private void handleNew() {
    }

    @FXML
    private void handleOpen() {
    }

    @FXML
    private void handleSave() {
    }

    @FXML
    private void handleSaveAs() {
    }

    @FXML
    private void handleAbout() {
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    @FXML
    private void handleSetting(){
    	//mainApp.showSettingEditDialog();
    }
    
    @FXML
    public void showMainView(){
  
			try {
				initUI.showMainLayout();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    }
    @FXML
	private void showPersonView(){
		initUI.showPersonLayout();
	}
//end
}