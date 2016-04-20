package keepapp.model;

import java.time.LocalDate;

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
    private final IntegerProperty isGroup;
    private final StringProperty group;

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
        this.isGroup = new SimpleIntegerProperty(0);
        this.group = new SimpleStringProperty("");
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

	public IntegerProperty IsGroupProperty() {
		return isGroup;
	}
	public Integer getIsGroup(){
		return isGroup.get();
	}
	public void setIsGroup(int isGroup){
		this.isGroup.set(isGroup);
	}

	public StringProperty groupProperty() {
		return group;
	}
	public String getGroup(){
		return group.get();
	}
	public void setGroup(String group){
		this.group.set(group);
	}
}
