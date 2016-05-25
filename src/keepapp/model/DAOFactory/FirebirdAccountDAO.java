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

public class FirebirdAccountDAO implements AccountDAO {
	
	@Override
	public int insertAccount(Account account) {
		String strSQL = "insert into accounts (NAME, LOGIN, PASSWD, GROUPNAME, LINK, NOTE, ISGROUP) values (?,?,?,?,?,?,?)";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, account.getName());
			stmt.setString(2, account.getLogin());
			stmt.setString(3, account.getPassword());
			stmt.setString(4, account.getGroup());
			stmt.setString(5, account.getLink());
			stmt.setString(6, account.getNote());
			stmt.setInt(7, account.getIsGroup());
			stmt.executeUpdate();
			FirebirdConnection.closeConnection(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public boolean deleteAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountByID(int ID) {
		String strSQL = "delete from ACCOUNTS where id=?";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setInt(1, ID);
			stmt.executeUpdate();
			FirebirdConnection.closeConnection(stmt);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Account getAccountByID(int ID) {
		String strSQL = "select ID, NAME, LOGIN, PASSWD, GROUPNAME, ISGROUP, LINK, NOTE from ACCOUNTS where ID=?";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setInt(1, ID);
			ResultSet res =  stmt.executeQuery();
			res.next();
			Account account = new Account(res.getInt("id"),res.getString("name"),res.getString("login"));
			account.setPassword(res.getString("passwd"));
			account.setLink(res.getString("link"));
			account.setNote(res.getString("note"));
			account.setIsGroup(res.getInt("isgroup"));
			account.setGroup(res.getString("groupname"));
			FirebirdConnection.closeConnection(stmt);
			return account;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
	}

	@Override
	public Account findAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccount(Account account) {
		String strSQL = "update ACCOUNTS set name=?, login=?, passwd=?, groupname=?, link=?, note=? where id=?";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, account.getName());
			stmt.setString(2, account.getLogin());
			stmt.setString(3, account.getPassword());
			stmt.setString(4, account.getGroup());
			stmt.setString(5, account.getLink());
			stmt.setString(6, account.getNote());
			stmt.setInt(7, account.getID());
			stmt.executeUpdate();
			FirebirdConnection.closeConnection(stmt);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ObservableList<Account> getAccountData() {
		ObservableList<Account> accountData = FXCollections.observableArrayList();
		String strSQL = "select id, name, login from accounts where isgroup=0";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {				
				accountData.add(new Account(res.getInt("id"), res.getString("name"),res.getString("login")));
			}
			FirebirdConnection.closeConnection(stmt);
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
	@Override
	public ObservableList<Account> getAccountGroup() {
		ObservableList<Account> accountGroup = FXCollections.observableArrayList();
		String strSQL = "select id, name, groupname from accounts where isgroup=1";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				Account tempAccount = new Account(res.getInt("id"), res.getString("name"),"");
				tempAccount.setGroup(res.getString("groupname"));
				accountGroup.add(tempAccount);
			}
			FirebirdConnection.closeConnection(stmt);
			return accountGroup;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public ObservableList<Account> getShortAccounts(String groupName) {//������� ����� ������������� ��� ��������� ���������
		ObservableList<Account> accountData = FXCollections.observableArrayList();
//		String strTemp = "select id, name, login from accounts";
//		if(groupName.length() != 0){
//			strTemp.concat(" where isgroup=0 and groupname=?");
//		}
		String strSQL = "select id, name, login from accounts where isgroup=0 and groupname=?";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, groupName);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {				
				accountData.add(new Account(res.getInt("id"), res.getString("name"),res.getString("login")));
			}
			FirebirdConnection.closeConnection(stmt);
			return accountData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
