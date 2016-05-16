package keepapp.view;

import javafx.fxml.FXML;
import keepapp.MainApp;

public class RootLayoutController {

    private InitUI initUI;

    public void setMainApp(MainApp mainApp) {
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
    	initUI.showMainLayout();		
    }
    @FXML
	private void showPersonView(){
		initUI.showPersonLayout();
	}
    @FXML
	private void showKeePassView(){
		initUI.showKeePassLayout();
	}
    @FXML
	private void showKeeLinkView(){
		initUI.showKeeLinkLayout();
	}
//end
}