package keepapp.model.DAOFactory;

import java.util.Collection;

import javax.sql.RowSet;

import javafx.collections.ObservableList;
import keepapp.model.Person;

public interface PersonDAO {
	public int insertPerson(Person person);
	public boolean deletePerson(Person person);
	public boolean deletePersonByID(int ID);
	public Person getPersonByID(int ID);
	public Person findPerson(Person person);
	public boolean updatePerson(Person person);
	public ObservableList<Person> getPersonData();
	public RowSet selectPersonRS();
	@SuppressWarnings("rawtypes")
	public Collection selectPersonTO();
	public void printPersons();
}
