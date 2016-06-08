package keepapp.model.DAOFactory;

public class FirefirdDAOFactory extends DAOFactory {

	
	public PersonDAO getPersonDAO(){
		return new FirebirdPersonDAO();
	}
	public DatabaseDAO getDatabaseDAO(){
		return new FirebirdDatabaseDAO();
	}
	public AccountDAO getAccountDAO(){
		return new FirebirdAccountDAO();
	}
	public LinkDAO getLinkDAO(){
		return new FirebirdLinkDAO();
	}
	public NoteDAO getNoteDAO() {
		return new FirebirdNoteDAO();
	}
	public implCommonDAO getImplCommonDAO(){
		return new implCommonDAO();
	}
}
