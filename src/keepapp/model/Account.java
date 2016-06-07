package keepapp.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Account extends implElement implements IElement {
	
	private final StringProperty login;
	private final StringProperty password;
	private final StringProperty link;
	private final StringProperty note;
	
	public Account(){
		this(null, null);
	}
	public Account(String name, String login){
		this(0, name, login);
	}
	public Account(int ID,String name,String login){
		super(ID, name);
		this.login = new SimpleStringProperty(login);
		this.password = new SimpleStringProperty("");
		this.link = new SimpleStringProperty("");
		this.note = new SimpleStringProperty("");
	}
	
    //Setters getters
	public StringProperty getLoginProperty() {return login;}
	public void setLogin(String login) {this.login.set(login);}
	public String getLogin() {return login.get();}
	
	public StringProperty getPasswordProperty() {return password;}
	public void setPassword(String password) {this.password.set(password);}
	public String getPassword() {return password.get();}
		
	public StringProperty getLinkProperty() {return link;}
	public String getLink(){return link.get();}
	public void setLink(String link){this.link.set(link);}
	
	public StringProperty getNoteProperty(){return note;}
	public String getNote(){return note.get();}
	public void setNote(String note){this.note.set(note);}

}
