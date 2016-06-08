package keepapp.API;

import javafx.collections.ObservableList;
import keepapp.model.IElement;
import keepapp.model.Link;
import keepapp.model.DAOFactory.DAOFactory;
import keepapp.model.DAOFactory.LinkDAO;

public class implCommon implements ICommon {
	private LinkDAO linkDAO;
	public implCommon(){
		getLinkDAO();
	}
	public void getLinkDAO(){
		DAOFactory firebirtdFactory = DAOFactory.getDAOFactory(DAOFactory.FIREBIRD);
		LinkDAO linkDAO = firebirtdFactory.getLinkDAO();
		this.linkDAO = linkDAO;
	}
	@Override
	public ObservableList<IElement> getShortList() {
		ObservableList linkList = linkDAO.getLinkData();
		return linkList;
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
