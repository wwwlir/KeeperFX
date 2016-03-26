package keepapp.view;

import javafx.fxml.FXML;
import keepapp.MainApp;

public class RootLayoutController {

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
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
//    	try {
//			mainApp.showMainLayout();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
//end
}