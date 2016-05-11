package keepapp.API;

import javafx.collections.ObservableList;
import keepapp.model.Account;

public interface IKeePass {
	public ObservableList<Account> getShortListAccount();
	public ObservableList<Account> getGroupListAccount();
	public ObservableList<Account> getShortListAccountsF(String groupName);
	public Account getAccountByID(int ID);
	public boolean deleteAccountByID(int ID);
	public boolean addAccount(Account account);
	public boolean updateAccountByID(Account account);
}
