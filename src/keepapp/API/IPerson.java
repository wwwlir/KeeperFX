package keepapp.API;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import keepapp.model.Person;

public interface IPerson {
	public ObservableList<Person> getShortListPerson();
	public Person getPersonByID(int ID);
	public boolean deletePersonByID(int ID);
}
