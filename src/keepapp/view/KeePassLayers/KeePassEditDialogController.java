package keepapp.view.KeePassLayers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import keepapp.model.Account;

public class KeePassEditDialogController {
	@FXML
	private TextField nameField;
	@FXML
	private TextField loginField;
	@FXML
	private TextField passwordField;
	@FXML
	private TextField rePasswordField;
	@FXML
	private TextField linkField;
	@FXML
	private TextField noteField;
	@FXML
	private CheckBox isGroupCheck;
	
	private Account account;
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
	public void setAccount(Account account){
		this.account = account;
		nameField.setText(account.getName());
		loginField.setText(account.getName());
		passwordField.setText(account.getName());
		rePasswordField.setText(account.getName());
		linkField.setText(account.getName());
		noteField.setText(account.getName());
		if(account.getIsGroup()==1){
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
			account.setName(nameField.getText());
			account.setLogin(loginField.getText());
			account.setPassword(passwordField.getText());
			account.setLink(linkField.getText());
			account.setNote(noteField.getText());
			account.setIsGroup(isGroupCheck.selectedProperty().get()?1:0);
			
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
			if(passwordField.getText() != rePasswordField.getText()){
				errorMessage = "Пароли не совпалают!";
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
	private void checkedIsGroup(boolean val){
		
		
		loginField.setDisable(val);
		passwordField.setDisable(val);
		rePasswordField.setDisable(val);
		linkField.setDisable(val);
		noteField.setDisable(val);
		
		
		loginField.setText("");
		passwordField.setText("");
		rePasswordField.setText("");
		linkField.setText("");
		noteField.setText("");
		account.setIsGroup(val?1:0);

	}
}
