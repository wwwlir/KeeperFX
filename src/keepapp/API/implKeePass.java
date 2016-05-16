package keepapp.API;

import javafx.collections.ObservableList;
import keepapp.model.Account;
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
		return accountDAO.getAccountByID(ID);
	}

	@Override
	public boolean deleteAccountByID(int ID) {
		return accountDAO.deleteAccountByID(ID);
	}

	@Override
	public boolean addAccount(Account account) {
		accountDAO.insertAccount(account);
		return false;
	}

	@Override
	public boolean updateAccountByID(Account account) {
		return accountDAO.updateAccount(account);
	}
	@Override
	public ObservableList<Account> getGroupListAccount() {
		ObservableList<Account> accountGroupList = accountDAO.getAccountGroup();
		return accountGroupList;
	}
	@Override
	public ObservableList<Account> getShortListAccountsF(String groupName) {
		return accountDAO.getShortAccounts(groupName);
	}

}
