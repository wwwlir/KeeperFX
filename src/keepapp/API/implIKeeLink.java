package keepapp.API;

import javafx.collections.ObservableList;
import keepapp.model.Account;
import keepapp.model.Link;
import keepapp.model.DAOFactory.AccountDAO;
import keepapp.model.DAOFactory.DAOFactory;
import keepapp.model.DAOFactory.LinkDAO;

public class implIKeeLink implements IKeeLink {
	private LinkDAO linkDAO;
	public implIKeeLink(){
		getLinkDAO();
	}
	public void getLinkDAO(){
		DAOFactory firebirtdFactory = DAOFactory.getDAOFactory(DAOFactory.FIREBIRD);
		LinkDAO linkDAO = firebirtdFactory.getLinkDAO();
		this.linkDAO = linkDAO;
	}
	@Override
	public ObservableList<Link> getShortListLink() {
		ObservableList<Link> linkList = linkDAO.getLinkData();
		return linkList;
	}

	@Override
	public ObservableList<Link> getGroupListLink() {
		ObservableList<Link> linkGroupList = linkDAO.getLinkGroup();
		return linkGroupList;
	}

	@Override
	public ObservableList<Link> getShortListLinksF(String groupName) {
		return linkDAO.getShortLink(groupName);
	}

	@Override
	public Link getLinkByID(int ID) {
		return linkDAO.getLinkByID(ID);
	}

	@Override
	public boolean deleteLinkByID(int ID) {
		return linkDAO.deleteLinkByID(ID);
	}

	@Override
	public boolean addLink(Link link) {
		linkDAO.insertLink(link);
		return false;
	}

	@Override
	public boolean updateLinkByID(Link link) {
		return linkDAO.updateLink(link);
	}

}
