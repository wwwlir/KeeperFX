package keepapp.view.KeeLinkLayers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import keepapp.API.ICommon;
import keepapp.API.IKeeLink;
import keepapp.logic.ObjectRepository;
import keepapp.model.Link;
import keepapp.view.IController;
import keepapp.view.InitUI;

public class KeeLinkLayoutController implements IController {

	@FXML
	private TreeView<Link> treeGroupLink;
	@FXML
	private TableView<Link> linkTable;
	@FXML
	private TableColumn<Link, String> nameColumn;
	@FXML
	private TableColumn<Link, String> linkColumn;
	@FXML
	private Label noteLabel;
	
	private InitUI initUI;
	IKeeLink iKeeLink = ObjectRepository.getIKeeLink();
	ICommon iCommon = ObjectRepository.getImplCommon();
	
	@FXML
	private void initialize(){
		initTreeGroup();
		treeGroupLink.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showGroupItems(newValue));
		
		setItemsLink();
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		linkColumn.setCellValueFactory(cellData -> cellData.getValue().getLinkProperty());
		linkTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showLinkDetails(newValue));
	}
	public void setMainApp(InitUI initUI){
		this.initUI = initUI;
	}
	
	//Handlers method
	@FXML
	private void handleNewLink(){
		Link tempLink = new Link();
		if(treeGroupLink.getSelectionModel().getSelectedItem() != null){
			Link selectItem = treeGroupLink.getSelectionModel().getSelectedItem().getValue();
			String selectedGroup = selectItem.getName();
			tempLink.setGroup(selectedGroup);
		}else{
			tempLink.setGroup("Home");
		}
		tempLink.setIsGroup(0);
		
		boolean okClicked = initUI.showLinkEditDialog(tempLink);
		if (okClicked) {
			iKeeLink.addLink(tempLink);
        	initialize();
        }
	}
	@FXML
	private void handleEditLink(){
		Link selectedLink = linkTable.getSelectionModel().getSelectedItem();
		if(selectedLink != null){
			boolean okClicked = initUI.showLinkEditDialog(selectedLink);
			if(okClicked){
				iKeeLink.updateLinkByID(selectedLink);
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
	private void handleDeleteLink(){
		Link selectLink = linkTable.getSelectionModel().getSelectedItem();//Удаляет только из таблицы
		int ID = selectLink.getID();
		iKeeLink.deleteLinkByID(ID);
		initialize();
	}
	//Other methods
	private void showLinkDetails(Link link){
		if (link != null) {
			if(!(link.getID() < 0)){
				loadDataLink(link);
			}
			noteLabel.setText(link.getNote());
		} else {
			noteLabel.setText("");
		}
	}
	private void loadDataLink(Link link) {
		// TODO Auto-generated method stub
		Link tempLink = iKeeLink.getLinkByID(link.getID());
		link.setGroup(tempLink.getGroup());
		link.setLink(tempLink.getLink());
		link.setName(tempLink.getName());
		link.setNote(tempLink.getNote());
	}
	public void setItemsLink(){
		linkTable.setItems(iKeeLink.getShortListLink());
	}
	private void initTreeGroup(){//Реализовать фильтр видимых элементов в зависимости от группы. Нужно создать событие при выборе группы
		Link homeLink = new Link(-1, "Home");
		homeLink.setIsGroup(1);
		TreeItem<Link> rootLinkTreeItem = new TreeItem<Link>(homeLink);
		rootLinkTreeItem.setExpanded(true);
		
		ObservableList<Link> obsGroupList = iKeeLink.getGroupListLink();
		for(Link linkGroupNode: obsGroupList){
			TreeItem<Link> item = new TreeItem<Link>(linkGroupNode);
			item.setExpanded(true);
			rootLinkTreeItem.getChildren().add(item);
		}
		treeGroupLink.setRoot(rootLinkTreeItem);
	}
	private void showGroupItems(TreeItem<Link> setGroup){
		if (setGroup == null || setGroup.getValue().getID()<0) {
			loadItemsGroupInTable("Home");
		}else{
			loadDataLink(setGroup.getValue());
			loadItemsGroupInTable(setGroup.getValue().getName());
		}
	}
	private void loadItemsGroupInTable(String groupName){
		linkTable.setItems(iKeeLink.getShortListLinksF(groupName));
	}
}
