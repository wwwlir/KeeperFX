package keepapp.API;

import javafx.collections.ObservableList;
import keepapp.model.Person;
import keepapp.model.DAOFactory.DAOFactory;
import keepapp.model.DAOFactory.PersonDAO;

public class implPerson implements IPerson {
	private PersonDAO personDAO;
	public implPerson(){
		getPersonDAO();
	}
	public void getPersonDAO(){
		DAOFactory firebirtdFactory = DAOFactory.getDAOFactory(DAOFactory.FIREBIRD);
		PersonDAO personDAO = firebirtdFactory.getPersonDAO();
		this.personDAO = personDAO;
	}
	@Override
	public ObservableList<Person> getShortListPerson() {
		ObservableList<Person> personList = personDAO.getPersonData();
		return personList;
	}

	@Override
	public Person getPersonByID(int ID) {
		// TODO Auto-generated method stub
		Person person = personDAO.getPersonByID(ID);
		return person;
	}
	@Override
	public boolean deletePersonByID(int ID) {
		return personDAO.deletePersonByID(ID);
	}
	@Override
	public boolean addPerson(Person person) {
		// TODO Auto-generated method stub
		personDAO.insertPerson(person);
		return false;
	}
	@Override
	public boolean updatePersonByID(Person person) {
		// TODO Auto-generated method stub
		
		return personDAO.updatePerson(person);
	}
	@Override
	public ObservableList<Person> getGroupListPerson() {
		ObservableList<Person> groupList = personDAO.getPersonGroup();
		return groupList;
	}

}
