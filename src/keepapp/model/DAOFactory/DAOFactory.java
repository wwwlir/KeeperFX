package keepapp.model.DAOFactory;

public abstract class DAOFactory {
	public static final int FIREBIRD = 1;
	public static final int XMLFILE = 2;
	
	public abstract PersonDAO getPersonDAO();
	public abstract DatabaseDAO getDatabaseDAO();
	public abstract AccountDAO getAccountDAO();
	public abstract LinkDAO getLinkDAO();
	public abstract NoteDAO getNoteDAO();
	public abstract IElementDAO getElementDAO();
	
	public static DAOFactory getDAOFactory(int whichFactory){
		switch (whichFactory) {
		case FIREBIRD:
			return new FirefirdDAOFactory();
		//case XMLFILE:
			//return new XMLFileDAOFactory();
		default:
			return null;
		}
	}
}
