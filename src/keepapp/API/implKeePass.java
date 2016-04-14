package keepapp.API;

import javafx.collections.ObservableList;
import keepapp.model.Account;
import keepapp.model.Person;
import keepapp.model.DAOFactory.AccountDAO;
import keepapp.model.DAOFactory.DAOFactory;

public class implKeePass implements IKeePass {
	private AccountDAO accountDAO;
	public implKeePass(){
		getAccountDAO();
	}
	public void getAccountDAO(){
		DAOFactory firebirtdFactory = DAOFactory.getDAOFactory(DAOFactory.FIREBIRD);
		AccountDAO accountDAO = firebirtdFactory.getAccountDAO();
		this.accountDAO = accountDAO;
	}
	@Override
	public ObservableList<Account> getShortListAccount() {
		ObservableList<Account> accountList = accountDAO.getAccountData();
		return accountList;
	}

	@Override
	public Account getAccountByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAccountByID(int ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAccountByID(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

}
