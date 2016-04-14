package keepapp.model.DAOFactory;

import java.util.Collection;
import javax.sql.RowSet;
import javafx.collections.ObservableList;
import keepapp.model.Account;

public interface AccountDAO {
	public int insertAccount(Account account);
	public boolean deleteAccount(Account account);
	public boolean deleteAccountByID(int ID);
	public Account getAccountByID(int ID);
	public Account findAccount(Account account);
	public boolean updateAccount(Account account);
	public ObservableList<Account> getAccountData();
	public RowSet selectAccountRS();
	@SuppressWarnings("rawtypes")
	public Collection selectAccountTO();
	public void printAccount();
}
