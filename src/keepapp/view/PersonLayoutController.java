package keepapp.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import keepapp.MainApp;
import keepapp.API.IPerson;
import keepapp.logic.ObjectRepository;
import keepapp.logic.util.DateUtil;
import keepapp.model.Person;

public class PersonLayoutController {
//	MainApp mainApp;
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
	
	public void initTree(){
		TreeItem<Person> rootItem = new TreeItem<Person>();
		rootItem.setExpanded(true);
		
		
		ObservableList<Person> obsPersonList = iperson.getShortListPerson();
		
		for(Person person: obsPersonList){
			TreeItem<Person> item = new TreeItem<Person> (person);//������������ �������� ������� �� ������ toString() �������            
            rootItem.getChildren().add(item);
		}
		personTree.setRoot(rootItem);
		//personTree.setVisible(true); //�� ��������� �������� ��� ����������� true
		personTree.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
	}
	private Object showPersonDetails(TreeItem<Person> newValue) {
		// TODO Auto-generated method stub
		int ID = newValue.getValue().getPersonID().get();
		
		
		if (ID != 0) {
			Person person = iperson.getPersonByID(ID);
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
	@FXML
	private void handleDeletePerson(){
		TreeItem<Person> selectedPers = personTree.getSelectionModel().getSelectedItem();
		int ID = selectedPers.getValue().getPersonID().get();
		boolean isRemove = selectedPers.getParent().getChildren().remove(selectedPers);
		
		if (isRemove) {
			iperson.deletePersonByID(ID);
			
			
			
//            personTable.getItems().remove(selectedIndex);
//            //DAO
//            DAOFactory firebirdDAO = DAOFactory.getDAOFactory(DAOFactory.FIREBIRD);
//        	personDAO = firebirdDAO.getPersonDAO();
//            personDAO.deletePerson(personTable.getSelectionModel().getSelectedItem());
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
        boolean okClicked = initUI.showPersonEditDialog(tempPerson);
        if (okClicked) {
//        	initUI.getPersonData().add(tempPerson);//��������� � ��������� persondata, ������� ����� ������������ � xml
////          DAO
//            DAOFactory firebirdDAO = DAOFactory.getDAOFactory(DAOFactory.FIREBIRD);
//        	personDAO = firebirdDAO.getPersonDAO();
//            personDAO.insertPerson(tempPerson);
        	iperson.addPerson(tempPerson);
        }
	}
	@FXML
	private void handleEditePerson(){
		TreeItem<Person> selectedPerson = personTree.getSelectionModel().getSelectedItem();
//		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
//        DAOFactory firebirdDAO = DAOFactory.getDAOFactory(DAOFactory.FIREBIRD);
//    	personDAO = firebirdDAO.getPersonDAO();
//    	personDAO.findPerson(selectedPerson);
        if (selectedPerson != null) {
            boolean okClicked = initUI.showPersonEditDialog(selectedPerson.getValue());
            if (okClicked) {
                showPersonDetails(selectedPerson);
//                DAO
                iperson.updatePersonByID(selectedPerson.getValue());
//                personDAO.updatePerson(selectedPerson);
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
}
