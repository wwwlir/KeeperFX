package keepapp.view.PersonLayers;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import keepapp.API.IPerson;
import keepapp.logic.ObjectRepository;
import keepapp.logic.util.DateUtil;
import keepapp.model.Person;
import keepapp.view.InitUI;

public class PersonLayoutController {

	private InitUI initUI;
	@FXML
	private TreeView<Person> personTree;
	@FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label phoneNumbersLabel;
    @FXML
    private Label noteLabel;
    @FXML
    private Label birthdayLabel;
	
    IPerson iperson = ObjectRepository.getIPerson();
    
	@FXML
	private void initialize(){
		initTree();
	}
	public void setMainApp(InitUI initUI) {
        this.initUI = initUI;
    }
	
	//Handlers methods
	@FXML
	private void handleDeletePerson(){
		TreeItem<Person> selectedPers = personTree.getSelectionModel().getSelectedItem();
		int ID = selectedPers.getValue().getPersonID();
		boolean isRemove = selectedPers.getParent().getChildren().remove(selectedPers);
		
		if (isRemove) {
			iperson.deletePersonByID(ID);
        } else {
            // Nothing selected.
//            Alert alert = new Alert(AlertType.WARNING);
//            alert.initOwner(mainApp.getPrimaryStage());
//            alert.setTitle("No Selection");
//            alert.setHeaderText("No Person Selected");
//            alert.setContentText("Please select a person in the table.");
//
//            alert.showAndWait();
        }
	}
	@FXML
	private void handleNewPerson(){
		Person tempPerson = new Person();
		if(personTree.getSelectionModel().getSelectedItem() != null){
			Person selectItem =  personTree.getSelectionModel().getSelectedItem().getValue();//Может быть никого не выделенно
			String selsctedGroup = selectItem.getIsGroup()==1 ? selectItem.getFirstName() : selectItem.getGroup();
			tempPerson.setGroup(selsctedGroup);
		}
		
		tempPerson.setIsGroup(0);
		
        boolean okClicked = initUI.showPersonEditDialog(tempPerson);
        if (okClicked) {
        	iperson.addPerson(tempPerson);
        	initialize();
        }
	}
	@FXML
	private void handleEditePerson(){
		TreeItem<Person> selectedPerson = personTree.getSelectionModel().getSelectedItem();
//		Person tempPerson = iperson.getPersonByID(selectedPerson.getValue().getPersonID());//Раскомментировать
        if (selectedPerson != null) {
            boolean okClicked = initUI.showPersonEditDialog(selectedPerson.getValue());
            if (okClicked) {
                iperson.updatePersonByID(selectedPerson.getValue());
                showPersonDetails(selectedPerson);
                initialize();
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(initUI.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
	}
	
	
	
	//Other methods
	public void initTree(){//Сделать отдельный метод в классе для всех TreeWiew
		Person homePerson = new Person(-1, "Home", "");
		homePerson.setIsGroup(1);
		TreeItem<Person> rootItem = new TreeItem<Person>(homePerson);
		rootItem.setExpanded(true);
		
		
		ObservableList<Person> obsPersonList = iperson.getShortListPerson();
		ObservableList<Person> obsGroupList = iperson.getGroupListPerson();
		ArrayList<String> arrGroup = new ArrayList<>();
		for(Person personGroup: obsGroupList){
			TreeItem<Person> item = new TreeItem<Person> (personGroup);
			item.setExpanded(true);
			arrGroup.add(personGroup.getFirstName());
			rootItem.getChildren().add(item);
//			for(TreeItem<Person> selGroupItem:rootItem.getChildren()){
//				
//			}
		}
		
		int arrId;
		for(Person person: obsPersonList){
			TreeItem<Person> item = new TreeItem<Person> (person);//Отображаемое название берется из метода toString() объекта
			arrId = arrGroup.indexOf(person.getGroup());
			if (arrId == -1) {
				rootItem.getChildren().add(item);
			} else {
				rootItem.getChildren().get(arrId).getChildren().add(item);
			}
            
		}
		personTree.setRoot(rootItem);
		//personTree.setVisible(true); //По умолчанию свойство уже выставленно true
		personTree.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
	}
	
	private void loadTreePerson(TreeItem<Person> Value){
		int ID = Value.getValue().getPersonID();
		Person tempPerson = iperson.getPersonByID(ID);
		Value.getValue().setAddress(tempPerson.getAddress());
		Value.getValue().setBirthday(tempPerson.getBirthday());
		Value.getValue().setNote(tempPerson.getNote());
		Value.getValue().setPhoneNumbers(tempPerson.getPhoneNumbers());
	}
	private Object showPersonDetails(TreeItem<Person> newValue) {
		if(!(newValue.getValue().getPersonID() < 0)){
			loadTreePerson(newValue);
		}
		if (newValue != null) {

            firstNameLabel.setText(newValue.getValue().getFirstName());
            lastNameLabel.setText(newValue.getValue().getLastName());
            addressLabel.setText(newValue.getValue().getAddress());
            phoneNumbersLabel.setText(newValue.getValue().getPhoneNumbers());
            noteLabel.setText(newValue.getValue().getNote());
            birthdayLabel.setText(DateUtil.format(newValue.getValue().getBirthday()));
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            addressLabel.setText("");
            phoneNumbersLabel.setText("");
            noteLabel.setText("");
            birthdayLabel.setText("");
        }
		return null;
	}
}
