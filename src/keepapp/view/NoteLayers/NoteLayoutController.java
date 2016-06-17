package keepapp.view.NoteLayers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import keepapp.API.INote;
import keepapp.logic.ObjectRepository;
import keepapp.model.Link;
import keepapp.model.Note;
import keepapp.view.InitUI;

public class NoteLayoutController {
	@FXML
	private TreeView<Note> treeGroupNote;
	@FXML
	private TableView<Note> noteTable;
	@FXML
	private TableColumn<Note, String> nameColumn;
	@FXML
	private Label noteLabel;
	private InitUI initUI;
	INote iNote = ObjectRepository.getINote();
	
	@FXML
	private void initialize(){
		initTreeGroup();
		treeGroupNote.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showGroupItems(newValue));
		
		setItemsNote();
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		noteTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showNoteDetails(newValue));
	}
	public void setMainApp(InitUI initUI){
		this.initUI = initUI;
	}
	//Handlers method
	@FXML
	private void handleNewNote(){
		Note tempNote = new Note();
		if(treeGroupNote.getSelectionModel().getSelectedItem() != null){
			Note selectItem = treeGroupNote.getSelectionModel().getSelectedItem().getValue();
			String selectedGroup = selectItem.getName();
			tempNote.setGroup(selectedGroup);
		}else{
			tempNote.setGroup("Home");
		}
		tempNote.setIsGroup(0);
		
		boolean okClicked = initUI.showNoteEditDialog(tempNote);
		if (okClicked) {
			iNote.addNote(tempNote);
        	initialize();
        }
	}
	@FXML
	private void handleEditNote(){
		Note selectedNote = noteTable.getSelectionModel().getSelectedItem();
		if(selectedNote != null){
			boolean okClicked = initUI.showNoteEditDialog(selectedNote);
			if(okClicked){
				iNote.updateNoteByID(selectedNote);
				initialize();
			}
		}else{
			// Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(initUI.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No note Selected");
            alert.setContentText("Please select a note in the table.");
            alert.showAndWait();
		}
	}
	@FXML
	private void handleDeleteNote(){
		int ID;
		Note selectNote = noteTable.getSelectionModel().getSelectedItem();//Удаляет только из таблицы
		if (selectNote != null) {
			ID = selectNote.getID();
		} else {
			ID = treeGroupNote.getSelectionModel().getSelectedItem().getValue().getID();
		}
		
		iNote.deleteNoteByID(ID);
		initialize();
	}
	//Other methods
	private void showNoteDetails(Note note){
		if (note != null) {
			if(!(note.getID() < 0)){
				loadDataNote(note);
			}
			noteLabel.setText(note.getNote());
		} else {
			noteLabel.setText("");
		}
	}
	private void loadDataNote(Note note) {
		// TODO Auto-generated method stub
		Note tempNote = iNote.getNoteByID(note.getID());
		note.setGroup(tempNote.getGroup());
		note.setNote(tempNote.getNote());
		note.setName(tempNote.getName());
	}
	public void setItemsNote(){
		noteTable.setItems(iNote.getShortListNote());
	}
	private void initTreeGroup(){
		Note homeNote = new Note(-1, "Home");
		homeNote.setIsGroup(1);
		TreeItem<Note> rootNoteTreeItem = new TreeItem<Note>(homeNote);
		rootNoteTreeItem.setExpanded(true);
		
		ObservableList<Note> obsGroupList = iNote.getGroupListNote();
		for(Note noteGroupNode: obsGroupList){
			TreeItem<Note> item = new TreeItem<Note>(noteGroupNode);
			item.setExpanded(true);
			rootNoteTreeItem.getChildren().add(item);
		}
		treeGroupNote.setRoot(rootNoteTreeItem);		
	}
	private void showGroupItems(TreeItem<Note> setGroup){
		
		if (setGroup == null || setGroup.getValue().getID()<0) {
			loadItemsGroupInTable("Home");
		}else{
			loadDataNote(setGroup.getValue());
			loadItemsGroupInTable(setGroup.getValue().getName());
		}
	}
	private void loadItemsGroupInTable(String groupName){
		noteTable.setItems(iNote.getShortListNotesF(groupName));
	}
}
