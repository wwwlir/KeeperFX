package keepapp.view.NoteLayers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import keepapp.API.INote;
import keepapp.logic.ObjectRepository;
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
		
	}
	public void setMainApp(InitUI initUI){
		this.initUI = initUI;
	}
	//Handlers method
	@FXML
	private void handleNewNote(){
		
	}
	@FXML
	private void handleEditNote(){
		
	}
	@FXML
	private void handleDeleteNote(){
		
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
		note.setNote(tempNote.getNote());
	}
	public void setItemsLink(){
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
		if (!(setGroup.getValue().getID()<0)) {
			loadDataNote(setGroup.getValue());
			loadItemsGroupInTable(setGroup.getValue().getName());
		}else{
			loadItemsGroupInTable("Home");
		}
	}
	private void loadItemsGroupInTable(String groupName){
		noteTable.setItems(iNote.getShortListNotesF(groupName));
	}
}
