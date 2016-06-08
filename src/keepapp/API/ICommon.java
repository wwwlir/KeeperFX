package keepapp.API;

import javafx.collections.ObservableList;
import keepapp.model.IElement;

public interface ICommon {
	public ObservableList<IElement> getShortList();
	public ObservableList<IElement> getGroupList();
	public ObservableList<IElement> getShortListForGroup(String groupName);
	public IElement getByID(int ID);
	public boolean deleteByID(int ID);
	public boolean add(IElement element);
	public boolean update(IElement element);
}
