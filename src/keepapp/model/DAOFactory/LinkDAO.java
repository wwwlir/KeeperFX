package keepapp.model.DAOFactory;

import java.util.Collection;

import javax.sql.RowSet;

import javafx.collections.ObservableList;
import keepapp.model.Link;

public interface LinkDAO {
	public int insertLink(Link link);
	public boolean deleteLink(Link link);
	public boolean deleteLinkByID(int ID);
	public Link getLinkByID(int ID);
	public Link findLink(Link link);
	public boolean updateLink(Link link);
	public ObservableList<Link> getLinkData();
	public ObservableList<Link> getLinkGroup();
	public ObservableList<Link> getShortLink(String groupName);
	public RowSet selectLinkRS();
	@SuppressWarnings("rawtypes")
	public Collection selectLinkTO();
	public void printLink();
}
