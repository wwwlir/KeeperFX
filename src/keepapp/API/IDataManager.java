package keepapp.API;

import javafx.collections.ObservableList;

public interface IDataManager {
	public ObservableList<?> getItemList();
	public Object getDataItemByID(int ID);
	public boolean deleteItem(Object item);
	public boolean addItem(Object item);
	public boolean updateDataItem(Object item);
}
