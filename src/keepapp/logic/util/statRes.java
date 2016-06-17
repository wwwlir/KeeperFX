package keepapp.logic.util;

import javafx.collections.ObservableList;
import keepapp.model.Person;

public class statRes {
	public static ObservableList<Person> personList;
	public static void setPerson(ObservableList<Person> personListIn){
		personList = personListIn;
	}
	public static ObservableList<Person> getPerson(){
		return personList;
	}
}
