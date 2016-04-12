package keepapp.view;

import javafx.fxml.FXML;

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
		initUI.showMainLayout();
	}
}
