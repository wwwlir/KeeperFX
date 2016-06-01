package keepapp.view.SettingsLayers;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import keepapp.logic.SettingsRepository;

public class SettingsEditDialogController {
	
	private Stage dialogStage;
	
	@FXML
	private TextField basePatch;
	
	@FXML
	private void initialize(){
		setSettings();
	}
	private void setSettings(){
		basePatch.setText(SettingsRepository.settings.getPathDataBase());
	}
	//handlers
	@FXML
	private void handlerOk(){
		SettingsRepository.settings.setPathDataBase(basePatch.getText());
		SettingsRepository.saveSettings();
		dialogStage.close();
	}
	@FXML
	private void handlerDelete(){
		dialogStage.close();
	}
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
	public void setDialogStage(Stage dialogStage){
		this.dialogStage = dialogStage;
	}
	
}
