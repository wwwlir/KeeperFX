package keepapp.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Link  extends implElement implements IElement {
	
	private final StringProperty link;
	private final StringProperty note;

	public Link(){
		this(null);
	}
	public Link(String name){
		this(0, name);
	}

	public Link(int ID, String name) {
		super(ID, name);
		// TODO Auto-generated constructor stub
		this.link = new SimpleStringProperty("");
		this.note = new SimpleStringProperty("");
	}

	@Override
	public void initProperty() {
		// TODO Auto-generated method stub

	}
	
	public StringProperty getLinkProperty() {return link;}
	public String getLink(){return link.get();}
	public void setLink(String link){this.link.set(link);}
	
	public StringProperty getNoteProperty(){return note;}
	public String getNote(){return note.get();}
	public void setNote(String note){this.note.set(note);}
	
}
