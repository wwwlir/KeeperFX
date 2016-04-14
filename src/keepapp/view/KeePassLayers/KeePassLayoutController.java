package keepapp.view.KeePassLayers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import keepapp.API.IKeePass;
import keepapp.logic.ObjectRepository;
import keepapp.model.Account;

public class KeePassLayoutController {
	
	@FXML
	private TreeView<Account> treeGroupAccaunt;
	
	@FXML
	private TableView<Account> accountTable;
	@FXML
	private TableColumn<Account, String> nameColumn;
	@FXML
	private TableColumn<Account, String> loginColumn;
	@FXML
	private TableColumn<Account, String> linkColumn;
	
	@FXML
	private Label noteLabel;
	
	IKeePass iKeePass = ObjectRepository.getIKeePass();
	
	@FXML
	private void initialize(){
		 nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		 loginColumn.setCellValueFactory(cellData -> cellData.getValue().getLoginProperty());
		 linkColumn.setCellValueFactory(cellData -> cellData.getValue().getLinkProperty());
		 accountTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showAccountDetails(newValue));
	}
	private void showAccountDetails(Account account){
		if (account != null) {
			noteLabel.setText(account.getNote());
		} else {
			noteLabel.setText("");
		}
	}
	public void setItemsAccount(){
		accountTable.setItems(iKeePass.getShortListAccount());
	}
}
