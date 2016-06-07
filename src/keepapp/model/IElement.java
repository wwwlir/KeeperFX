package keepapp.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public interface IElement {
	
	public void initProperty();
	public IntegerProperty getIDPreperty();
	public int getID();
	public void setID(int id);
	
	public StringProperty getNameProperty();
	public void setName(String name);
	public String getName();
	
	public StringProperty getGroupProperty();
	public void setGroup(String group);
	public String getGroup();
	
	public IntegerProperty getIsGroupProperty();
	public void setIsGroup(int isGroup);
	public int getIsGroup();
}
