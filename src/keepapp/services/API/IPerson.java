package keepapp.services.API;

import javafx.collections.ObservableList;
import keepapp.model.Person;

public interface IPerson {
	public ObservableList<Person> getShortListPerson();
	public ObservableList<Person> getGroupListPerson();
	public Person getPersonByID(int ID);
	public boolean deletePersonByID(int ID);
	public boolean addPerson(Person person);
	public boolean updatePersonByID(Person person);
}
