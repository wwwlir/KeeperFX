package keepapp.model.DAOFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import javax.sql.RowSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import keepapp.model.Account;
import keepapp.model.Person;

public class FirebirdAccountDAO implements AccountDAO {
	
	private final String DRIVER = "org.firebirdsql.jdbc.FBDriver";
	private final String DBURL = "jdbc:firebirdsql:embedded:C:\\FirebirdDatabase\\FDBT.FDB";
	Connection conn = null;
	
	private Connection createConnection(){
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DBURL, "SYSDBA", "masterkey");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	private void closeConnection(Statement statement){
		try {
			conn.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int insertAccount(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountByID(int ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account getAccountByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObservableList<Account> getAccountData() {
		ObservableList<Account> accountData = FXCollections.observableArrayList();
		String strSQL = "select id, name, login from accounts";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {				
				accountData.add(new Account(res.getInt("id"), res.getString("name"),res.getString("login")));
			}
			return accountData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RowSet selectAccountRS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectAccountTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printAccount() {
		// TODO Auto-generated method stub

	}

}
