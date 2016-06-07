package keepapp.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class implElement implements IElement {

	final IntegerProperty ID;
	final StringProperty name;
	final StringProperty group;
	final IntegerProperty isGroup;
	
	public implElement(){
		this(null);
	}
	public implElement(String name){
		this(0, name);
	}
	public implElement(int ID,String name){
		this.ID = new SimpleIntegerProperty(ID);
		this.name = new SimpleStringProperty(name);
		this.group = new SimpleStringProperty("");
		this.isGroup = new SimpleIntegerProperty(0);
		initProperty();
	}
	public void initProperty(){
		
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
	
	public String toString(){
		return name.get();
	}

}
