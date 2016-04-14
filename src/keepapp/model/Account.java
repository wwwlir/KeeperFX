package keepapp.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Account {
	private IntegerProperty ID;
	private StringProperty name;
	private StringProperty login;
	private StringProperty password;
	private StringProperty group;
	private IntegerProperty isGroup;
	private StringProperty link;
	private StringProperty note;
	
	public Account(int ID, String name, String login) {
		this.ID = new SimpleIntegerProperty(ID);
		this.name = new SimpleStringProperty(name);
		this.login = new SimpleStringProperty(login);
	}
	public Account(StringProperty name, StringProperty login, StringProperty password, StringProperty group,
			IntegerProperty isGroup) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.group = group;
		this.isGroup = isGroup;
	}
	public IntegerProperty getIDPreperty(){return ID;}
	public int getID(){return ID.get();}
	public StringProperty getNameProperty() {return name;}
	public void setName(StringProperty name) {this.name = name;}
	public StringProperty getLoginProperty() {return login;}
	public void setLogin(StringProperty login) {this.login = login;}
	public StringProperty getPasswordProperty() {return password;}
	public void setPassword(StringProperty password) {this.password = password;}
	public StringProperty getGroupProperty() {return group;}
	public void setGroup(StringProperty group) {this.group = group;}
	public IntegerProperty getIsGroupProperty() {return isGroup;}
	public void setIsGroup(IntegerProperty isGroup) {this.isGroup = isGroup;}
	public StringProperty getLinkProperty() {
		return link;
	}
	public String getLink(){
		return link.get();
	}
	public void setLink(StringProperty link) {
		this.link = link;
	}
	public StringProperty getNoteProperty() {
		return note;
	}
	public String getNote(){
		return note.get();
	}
	public void setNote(StringProperty note) {
		this.note = note;
	}
	public String getName() {return name.get();}
	public String getLogin() {return login.get();}
	public String getPassword() {return password.get();}
	public String getGroup() {return group.get();}
	public int getIsGroup() {return isGroup.get();}
	
	public String toString(){
		return name.get();
	}
}
