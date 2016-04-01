package keepapp.API;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import keepapp.model.Person;
import keepapp.model.DAOFactory.DAOFactory;
import keepapp.model.DAOFactory.FirebirdPersonDAO;
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

}
