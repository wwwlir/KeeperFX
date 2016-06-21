package keepapp.services.API;

import javafx.collections.ObservableList;
import keepapp.model.Link;

public interface IKeeLink {
	public ObservableList<Link> getShortListLink();
	public ObservableList<Link> getGroupListLink();
	public ObservableList<Link> getShortListLinksF(String groupName);
	public Link getLinkByID(int ID);
	public boolean deleteLinkByID(int ID);
	public boolean addLink(Link link);
	public boolean updateLinkByID(Link link);
}
