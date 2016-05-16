package keepapp.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Link {
	private final IntegerProperty ID;
	private final StringProperty name;
	private final StringProperty group;
	private final IntegerProperty isGroup;
	private final StringProperty link;
	private final StringProperty note;
	
	public Link(){
		this(null);
	}
	public Link(String name){
		this(0, name);
	}
	public Link(int ID,String name){
		this.ID = new SimpleIntegerProperty(ID);
		this.name = new SimpleStringProperty(name);
		this.group = new SimpleStringProperty("");
		this.isGroup = new SimpleIntegerProperty(0);
		this.link = new SimpleStringProperty("");
		this.note = new SimpleStringProperty("");
	}
	
    //Setters getters
	public IntegerProperty getIDPreperty(){return ID;}
	public int getID(){return ID.get();}
	public void setID(int id){this.ID.set(id);}
	
	public StringProperty getNameProperty() {return name;}
	public void setName(String name) {this.name.set(name);}
	public String getName() {return name.get();}
	
	public StringProperty getGroupProperty() {return group;}
	public void setGroup(String group) {this.group.set(group);}
	public String getGroup() {return group.get();}
	
	public IntegerProperty getIsGroupProperty() {return isGroup;}
	public void setIsGroup(int isGroup) {this.isGroup.set(isGroup);}
	public int getIsGroup() {return isGroup.get();}
	
	public StringProperty getLinkProperty() {return link;}
	public String getLink(){return link.get();}
	public void setLink(String link){this.link.set(link);}
	
	public StringProperty getNoteProperty(){return note;}
	public String getNote(){return note.get();}
	public void setNote(String note){this.note.set(note);}
	
	
	public String toString(){
		return name.get();
	}
}
