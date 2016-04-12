package keepapp.model.DAOFactory;

public class FirefirdDAOFactory extends DAOFactory {

	
	public PersonDAO getPersonDAO() {
		// TODO Auto-generated method stub
		return new FirebirdPersonDAO();
	}
	public DatabaseDAO getDatabaseDAO(){
		return new FirebirdDatabaseDAO();
	}
}
