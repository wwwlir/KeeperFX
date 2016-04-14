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
}
