package keepapp.services;

import javafx.collections.ObservableList;
import keepapp.model.IElement;
import keepapp.model.DAOFactory.DAOFactory;
import keepapp.model.DAOFactory.IElementDAO;
import keepapp.model.DAOFactory.NoteDAO;
import keepapp.services.API.IElementManager;

public class ElementManager implements IElementManager {
	private IElementDAO elementDAO;
	void ElementManager(){
		createElementDAO();
	}
	private void createElementDAO(){
		DAOFactory firebirtdFactory = DAOFactory.getDAOFactory(DAOFactory.FIREBIRD);
		this.elementDAO = firebirtdFactory.getElementDAO();
	}
	@Override
	public ObservableList<IElement> getShortList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<IElement> getGroupList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<IElement> getShortListForGroup(String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IElement getByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteByID(int ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(IElement element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(IElement element) {
		// TODO Auto-generated method stub
		return false;
	}

}
