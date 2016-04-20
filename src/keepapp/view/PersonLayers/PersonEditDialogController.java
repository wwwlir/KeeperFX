package keepapp.view.PersonLayers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import keepapp.logic.util.DateUtil;
import keepapp.model.Person;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class PersonEditDialogController {
	@FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneNumbersField;
    @FXML
    private TextField noteField;
    @FXML
    private TextField birthdayField;
    @FXML
    private CheckBox isGroupCheck;
    
    private Person person;
    private Stage dialogStage;
    boolean okClicked = false;
    
    @FXML
    private void initialize() {
    	isGroupCheck.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                    Boolean old_val, Boolean new_val) {
                        checkedIsGroup(new_val);
                }
            });
    }
    public void setPerson(Person person){
    	this.person = person;
        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        addressField.setText(person.getAddress());
        phoneNumbersField.setText(person.getPhoneNumbers());
        noteField.setText(person.getNote());
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
        if(person.getIsGroup()==1){
        	checkedIsGroup(true);
        	isGroupCheck.setDisable(true);
        }
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    
    
    //Handlers metods
    @FXML
    private void handlerOk(){
//    	if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setAddress(addressField.getText());
            person.setPhoneNumbers(phoneNumbersField.getText());
            person.setNote(noteField.getText());
            person.setBirthday(DateUtil.parse(birthdayField.getText()));
            person.setIsGroup(isGroupCheck.selectedProperty().get()?1:0);
            
            okClicked = true;
            dialogStage.close();
//        }
    }
    @FXML
    private void handlerCancel(){
    	dialogStage.close();
    }
    private void handlerCheckIsGroup(){
    	
    }
    
    
    
    
    //More metods
    public boolean isOkClicked() {
        return okClicked;
    }
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        
        if (!isGroupCheck.selectedProperty().get()){
        	
	        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
	            errorMessage += "No valid last name!\n"; 
	        }
	//        if (addressField.getText() == null || addressField.getText().length() == 0) {
	//            errorMessage += "No valid street!\n"; 
	//        }
	
	        if (phoneNumbersField.getText() == null || phoneNumbersField.getText().length() == 0) {
	            errorMessage += "No valid postal code!\n"; 
	        }
	
	//       if (noteField.getText() == null || noteField.getText().length() == 0) {
	//            errorMessage += "No valid city!\n"; 
	//       }
	
	//       if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
	//            errorMessage += "No valid birthday!\n";
	//       } else {
	            if (!DateUtil.validDate(birthdayField.getText())) {
	                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
	            }
	//       }
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
			lastNameField.setDisable(val);
			lastNameField.setText("");
			addressField.setDisable(val);
			addressField.setText("");
			phoneNumbersField.setDisable(val);
			phoneNumbersField.setText("");
			noteField.setDisable(val);
			noteField.setText("");
			birthdayField.setDisable(val);
			person.setIsGroup(val?1:0);
    }
}
