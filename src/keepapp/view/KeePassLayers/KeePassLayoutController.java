package keepapp.view.KeePassLayers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import keepapp.API.IKeePass;
import keepapp.API.implKeePass;
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
	
	private InitUI initUI;
	IKeePass iKeePass = ObjectRepository.getIKeePass();
	
	@FXML
	private void initialize(){
		initTreeGrtoup();
		treeGroupAccaunt.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showGroupItems(newValue));
		
		setItemsAccount();
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		loginColumn.setCellValueFactory(cellData -> cellData.getValue().getLoginProperty());
		linkColumn.setCellValueFactory(cellData -> cellData.getValue().getLinkProperty());
		accountTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showAccountDetails(newValue));
	}
	public void setMainApp(InitUI initUI) {
        this.initUI = initUI;
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
		
		boolean okClicked = initUI.showAccountEditDialog(tempAccount);
		if (okClicked) {
			iKeePass.addAccount(tempAccount);
        	initialize();
        }
	}
	@FXML
	private void handleEditAccount(){
		Account selectedAccaunt = accountTable.getSelectionModel().getSelectedItem();
		if(selectedAccaunt != null){
			boolean okClicked = initUI.showAccountEditDialog(selectedAccaunt);
			if(okClicked){
				iKeePass.updateAccountByID(selectedAccaunt);
				initialize();
			}
		}else{
			// Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(initUI.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No account Selected");
            alert.setContentText("Please select a account in the table.");
            alert.showAndWait();
		}
	}
	@FXML
	private void handleDeleteAccount(){
		Account selectAccount = accountTable.getSelectionModel().getSelectedItem();//Удаляет только из таблицы
		int ID = selectAccount.getID();
		iKeePass.deleteAccountByID(ID);
		initialize();
	}
	
	
	//other methods
	private void showAccountDetails(Account account){
		if (account != null) {
			if(!(account.getID() < 0)){
				loadDataAccount(account);
			}
			noteLabel.setText(account.getNote());
		} else {
			noteLabel.setText("");
		}
	}
	private void loadDataAccount(Account account) {
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
	private void initTreeGrtoup(){//Реализовать фильтр видимых элементов в зависимости от группы. Нужно создать событие при выборе группы
		Account homeAccount = new Account(-1, "Home", "");
		homeAccount.setIsGroup(1);
		TreeItem<Account> rootAccountTreeItem = new TreeItem<Account>(homeAccount);
		rootAccountTreeItem.setExpanded(true);
		
		ObservableList<Account> obsGroupList = iKeePass.getGroupListAccount();
		for(Account accountGroupNode: obsGroupList){
			TreeItem<Account> item = new TreeItem<Account>(accountGroupNode);
			item.setExpanded(true);
			rootAccountTreeItem.getChildren().add(item);
		}
		treeGroupAccaunt.setRoot(rootAccountTreeItem);
	}
	private void showGroupItems(TreeItem<Account> setGroup){
		if (!(setGroup.getValue().getID()<0)) {
			loadDataAccount(setGroup.getValue());
			loadItemsGroupInTable(setGroup.getValue().getName());
		}else{
			loadItemsGroupInTable("Home");
		}
	}
	private void loadItemsGroupInTable(String groupName){
		accountTable.setItems(iKeePass.getShortListAccountsF(groupName));
	}
}
