package keepapp.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Note extends implElement implements IElement {
	
	private final StringProperty note;
	
	public Note(){
		this(null);
	}
	public Note(String name){
		this(0, name);
	}
	public Note(int ID,String name){
		super(ID, name);
		this.note = new SimpleStringProperty("");
	}
	
    //Setters getters
	public StringProperty getNoteProperty(){return note;}
	public String getNote(){return note.get();}
	public void setNote(String note){this.note.set(note);}
	
	
	public String toString(){
		return name.get();
	}
}
