package keepapp.view;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import keepapp.MainApp;
import keepapp.model.Person;

public class PersonLayoutController {
	MainApp mainApp;
	@FXML
	private TreeView<String> personTree;
	@FXML
	private void initialize(){
		TreeItem<String> rootItem = new TreeItem<String>("PersonFolder");
		rootItem.setExpanded(true);
		for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String> ("Message" + i);            
            rootItem.getChildren().add(item);
		}        
		personTree.setVisible(true);
	}
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
