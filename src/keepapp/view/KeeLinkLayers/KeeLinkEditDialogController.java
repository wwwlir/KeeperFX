package keepapp.view.KeeLinkLayers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import keepapp.model.Link;

public class KeeLinkEditDialogController {
	@FXML
	private TextField nameField;
	@FXML
	private TextField linkField;
	@FXML
	private TextArea noteField;
	@FXML
	private CheckBox isGroupCheck;
	
	private Link link;
	private Stage dialogStage;
	boolean okClicked = false;
	
	@FXML
	private void initialize(){
		isGroupCheck.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                    Boolean old_val, Boolean new_val) {
                        checkedIsGroup(new_val);
                }
            });
	}
	public void setLink(Link link){
		this.link = link;
		nameField.setText(link.getName());
		linkField.setText(link.getLink());
		noteField.setText(link.getNote());
		if(link.getIsGroup()==1){
			checkedIsGroup(true);
			isGroupCheck.setDisable(true);
		}
	}
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
	//Handler methods
	@FXML
	private void handlerOk(){
    	if (isInputValid()) {
    		link.setName(nameField.getText());
    		link.setLink(linkField.getText());
    		link.setNote(noteField.getText());
    		link.setIsGroup(isGroupCheck.selectedProperty().get()?1:0);
			
			okClicked = true;
			dialogStage.close();
		}
	}
	@FXML
	private void handlerCancel(){
		dialogStage.close();
	}
	
	//Other metods
	public boolean isOkClicked() {
        return okClicked;
    }
	private boolean isInputValid(){
		String errorMessage = "";
		if(!isGroupCheck.selectedProperty().get()){
			
		}
		if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
	}
	private void checkedIsGroup(boolean val){
		
		
		linkField.setDisable(val);
		noteField.setDisable(val);
		
		linkField.setText("");
		noteField.setText("");
		link.setIsGroup(val?1:0);
	}
}
