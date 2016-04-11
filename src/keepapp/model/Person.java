package keepapp.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	private final IntegerProperty personID;
	private final StringProperty firstName;
    private final StringProperty lastName;
    private final ObjectProperty<LocalDate> birthday;
    private final StringProperty address;
    private final StringProperty phoneNumbers;
    private final StringProperty note;


    /**
     * Default constructor.
     */
    public Person() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
    	this(0, firstName, lastName);        
    }
    public Person(int personID, String firstName, String lastName) {
    	this.personID = new SimpleIntegerProperty(personID);
    	this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.address = new SimpleStringProperty("");
        this.phoneNumbers = new SimpleStringProperty("+7");
        this.note = new SimpleStringProperty("");
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }
    public String toString(){
    	return this.getFirstName()+" "+this.getLastName();
    }
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getPhoneNumbers() {
        return phoneNumbers.get();
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers.set(phoneNumbers);
    }

    public StringProperty phoneNumbersProperty() {
        return phoneNumbers;
    }

    public String getNote() {
        return note.get();
    }

    public void setNote(String note) {
        this.note.set(note);
    }

    public StringProperty noteProperty() {
        return note;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public IntegerProperty PersonIDProperty() {
		return personID;
	}
    public int getPersonID() {
		return personID.get();
	}

	public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
}
