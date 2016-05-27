package keepapp.view.SettingsLayers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import keepapp.MainApp;

public class SettingsEditDialogController {
	
	@FXML
	private TextField basePatch;
	
	@FXML
	private void initialize(){
		
	}
	//handlers
	@FXML
	private void browseBasePatch(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select database file");
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("FDB files (*.fdb)", "*.fdb"));
		
//		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");
//		fileChooser.getExtensionFilters().add(extFilter);
//		
//		fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("All Images", "*.*"),
//                new FileChooser.ExtensionFilter("HTML Documents", "*.html"),
//                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
//                new FileChooser.ExtensionFilter("PNG", "*.png")
//            );
		
		File file = fileChooser.showOpenDialog(null);
		if(file != null){
			basePatch.setText(file.toString());
		}
		
	}
	//Other methods
	
}
