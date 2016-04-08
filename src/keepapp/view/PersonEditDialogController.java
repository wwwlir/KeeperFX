package keepapp.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import keepapp.logic.util.DateUtil;
import keepapp.model.Person;
import javafx.scene.control.Alert.AlertType;
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
    private Person person;
    private Stage dialogStage;
    
    @FXML
    private void initialize() {
    }
    private void setPerson(Person person){
    	this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        addressField.setText(person.getAddress());
        phoneNumbersField.setText(person.getPhoneNumbers());
        noteField.setText(person.getNote());
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    @FXML
    private void handlerOk(){
    	
    }
    @FXML
    private void handlerCancel(){
    	
    }
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (addressField.getText() == null || addressField.getText().length() == 0) {
            errorMessage += "No valid street!\n"; 
        }

        if (phoneNumbersField.getText() == null || phoneNumbersField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n"; 
        }

        if (noteField.getText() == null || noteField.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
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
}
