package keepapp.view.NoteLayers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import keepapp.model.Note;

public class NoteEditDialogController {

	@FXML
	private TextField nameField;
	@FXML
	private TextArea noteField;
	@FXML
	private CheckBox isGroupCheck;
	
	private Note note;
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
	public void setNote(Note note){
		this.note = note;
		nameField.setText(note.getName());
		noteField.setText(note.getNote());
		if(note.getIsGroup()==1){
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
    		note.setName(nameField.getText());
    		note.setNote(noteField.getText());
    		note.setIsGroup(isGroupCheck.selectedProperty().get()?1:0);
			
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
		
		noteField.setDisable(val);
		
		noteField.setText("");
		note.setIsGroup(val?1:0);
	}

}
