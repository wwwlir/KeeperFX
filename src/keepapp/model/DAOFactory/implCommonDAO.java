package keepapp.model.DAOFactory;

import javax.sql.RowSet;

import javafx.collections.ObservableList;
import keepapp.model.IElement;

public class implCommonDAO implements ICommonDAO {

	public implCommonDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insertElement(IElement element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteElementByID(int ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IElement getElementByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IElement findElement(IElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateElement(IElement element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObservableList<IElement> getElementData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<IElement> getElementGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<IElement> getShortElement(String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RowSet selectElementRS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printElement() {
		// TODO Auto-generated method stub

	}

}
