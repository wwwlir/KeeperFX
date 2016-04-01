package keepapp.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import keepapp.MainApp;
import keepapp.API.IPerson;
import keepapp.logic.ObjectRepository;
import keepapp.logic.util.DateUtil;
import keepapp.model.Person;

public class PersonLayoutController {
	MainApp mainApp;
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
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
	
	public void initTree(){
		TreeItem<Person> rootItem = new TreeItem<Person>();
		rootItem.setExpanded(true);
		
		
		ObservableList<Person> obsPersonList = iperson.getShortListPerson();
		
		for(Person person: obsPersonList){
			TreeItem<Person> item = new TreeItem<Person> (person);//Отображаемое название берется из метода toString() объекта            
            rootItem.getChildren().add(item);
		}
		personTree.setRoot(rootItem);
		//personTree.setVisible(true); //По умолчанию свойство уже выставленно true
		personTree.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
	}
	private Object showPersonDetails(TreeItem<Person> newValue) {
		// TODO Auto-generated method stub
		int ID = newValue.getValue().getPersonID().get();
		Person person = iperson.getPersonByID(ID);
		
		if (person != null) {
            // Fill the labels with info from the person object.
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            addressLabel.setText(person.getAddress());
            phoneNumbersLabel.setText(person.getPhoneNumbers());
            noteLabel.setText(person.getNote());
            // TODO: We need a way to convert the birthday into a String! 
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        } else {
            // Person is null, remove all the text.
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
