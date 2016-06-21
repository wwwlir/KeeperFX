package keepapp.model.DAOFactory;

import javax.sql.RowSet;
import javafx.collections.ObservableList;
import keepapp.model.IElement;

public interface IElementDAO {
	public int insertElement(IElement element);
	public boolean deleteElementByID(int ID);
	public IElement getElementByID(int ID);
	public IElement findElement(IElement element);
	public boolean updateElement(IElement element);
	public ObservableList<IElement> getElementData();
	public ObservableList<IElement> getElementGroup();
	public ObservableList<IElement> getShortElement(String groupName);
	public RowSet selectElementRS();
	public void printElement();
}
