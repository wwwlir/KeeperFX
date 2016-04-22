package keepapp.view.KeePassLayers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import keepapp.API.IKeePass;
import keepapp.logic.ObjectRepository;
import keepapp.model.Account;
import keepapp.view.InitUI;

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
		setItemsAccount();
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		loginColumn.setCellValueFactory(cellData -> cellData.getValue().getLoginProperty());
		linkColumn.setCellValueFactory(cellData -> cellData.getValue().getLinkProperty());
		accountTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showAccountDetails(newValue));
	}
	//Handlers methods
	@FXML
	private void handleNewAccount(){
		Account tempAccount = new Account();
		if(treeGroupAccaunt.getSelectionModel().getSelectedItem() != null){
			Account selectItem = treeGroupAccaunt.getSelectionModel().getSelectedItem().getValue();
			String selectedGroup = selectItem.getName();
			tempAccount.setGroup(selectedGroup);
		}
		tempAccount.setIsGroup(0);
		
		boolean okClicked = InitUI.showAccountEditDialog(tempAccount);
		if (okClicked) {
			iKeePass.addAccount(tempAccount);
        	initialize();
        }
	}
	@FXML
	private void handleEditAccount(){
		
	}
	@FXML
	private void handleDeleteAccount(){
		
	}
	//other methods
	private void showAccountDetails(Account account){
		if (account != null) {
			if(!(account.getID() < 0)){
				loadTreePerson(account);
			}
			noteLabel.setText(account.getNote());
		} else {
			noteLabel.setText("");
		}
	}
	private void loadTreePerson(Account account) {
		// TODO Auto-generated method stub
		Account tAcc = iKeePass.getAccountByID(account.getID());
		account.setGroup(tAcc.getGroup());
		account.setLink(tAcc.getLink());
		account.setLogin(tAcc.getLogin());
		account.setName(tAcc.getName());
		account.setNote(tAcc.getNote());
		account.setPassword(tAcc.getPassword());
	}
	public void setItemsAccount(){
		accountTable.setItems(iKeePass.getShortListAccount());
	}
}
