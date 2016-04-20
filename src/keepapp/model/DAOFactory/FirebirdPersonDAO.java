package keepapp.model.DAOFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collection;


import javax.sql.RowSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import keepapp.model.Person;

public class FirebirdPersonDAO implements PersonDAO {
	
	int setIDPerson;
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
	public int insertPerson(Person person) {
		Date getBirthday = Date.valueOf(person.getBirthday());
		String strSQL = "insert into persons (fname, lname, address, phonenumbers, birthday, note, ISGROUP, groupname) values (?,?,?,?,?,?,?,?)";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, person.getFirstName());
			stmt.setString(2, person.getLastName());
			stmt.setString(3, person.getAddress());
			stmt.setString(4, person.getPhoneNumbers());
			stmt.setDate(5, getBirthday);
			stmt.setString(6, person.getNote());
			stmt.setInt(7, person.getIsGroup());
			stmt.setString(8, person.getGroup());
			stmt.executeUpdate();
			closeConnection(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public boolean deletePerson(Person person) {//Переделать, не искать person
		findPerson(person);
		String strSQL = "delete from PERSONS where id=?";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setInt(1, setIDPerson);
			stmt.executeUpdate();
			closeConnection(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Person findPerson(Person person) {
		// TODO Auto-generated method stub
		String strSQL = "select ID from PERSONS where fname=? and lname=?";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, person.getFirstName());
			stmt.setString(2, person.getLastName());
			ResultSet res =  stmt.executeQuery();
			res.next();
			int type = res.getInt("ID");
			this.setIDPerson = type;
			closeConnection(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updatePerson(Person person) {
		// TODO Auto-generated method stub
		Date getBirthday = Date.valueOf(person.getBirthday());
		String strSQL = "update PERSONS set fname=?, lname=?, address=?, phonenumbers=?, birthday=?, note=? where id=?";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, person.getFirstName());
			stmt.setString(2, person.getLastName());
			stmt.setString(3, person.getAddress());
			stmt.setString(4, person.getPhoneNumbers());
			stmt.setDate(5, getBirthday);
			stmt.setString(6, person.getNote());
			stmt.setInt(7, person.getPersonID());
			stmt.executeUpdate();
			closeConnection(stmt);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public RowSet selectPersonRS() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection selectPersonTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printPersons() {
		// TODO Auto-generated method stub

	}

	@Override
	public ObservableList<Person> getPersonData() {//Переделать, получать ID, учесть большой объем
		ObservableList<Person> personData = FXCollections.observableArrayList();
		String strSQL = "select id, fname, lname, groupname from persons where isgroup=0";
		Person tempPerson;
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				tempPerson = new Person(res.getInt("id"), res.getString("fname"),res.getString("lname"));
				tempPerson.setGroup(res.getString("groupname"));
				tempPerson.setIsGroup(0);
				personData.add(tempPerson);
//				personData.add(new Person(res.getInt("id"), res.getString("fname"),res.getString("lname")));
			}
			closeConnection(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return personData;
	}
	@Override
	public Person getPersonByID(int ID) {
		String strSQL = "select ID, FNAME, LNAME, ADDRESS, PHONENUMBERS, BIRTHDAY, GROUPNAME, ISGROUP, NOTE from PERSONS where ID=?";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setInt(1, ID);
			ResultSet res =  stmt.executeQuery();
			res.next();
			Person person = new Person(res.getInt("id"),res.getString("fname"),res.getString("lname"));
			person.setAddress(res.getString("address"));
			person.setPhoneNumbers(res.getString("phoneNumbers"));
			person.setNote(res.getString("note"));
			Date birthDate = res.getDate("birthday");
			LocalDate birthLocalDate = birthDate.toLocalDate(); 
			person.setBirthday(birthLocalDate);
			person.setGroup(res.getString("groupname"));
			person.setIsGroup(res.getInt("isgroup"));
			closeConnection(stmt);
			return person;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean deletePersonByID(int ID) {//Удаление по индексу
		String strSQL = "delete from PERSONS where id=?";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setInt(1, ID);
			stmt.executeUpdate();
			closeConnection(stmt);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public ObservableList<Person> getPersonGroup() {
		ObservableList<Person> personData = FXCollections.observableArrayList();
		Person tempPerson;
		String strSQL = "select id, fname, groupname from persons where isgroup=1";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				tempPerson = new Person(res.getInt("id"), res.getString("fname"),"");
				tempPerson.setGroup(res.getString("groupname"));
				tempPerson.setIsGroup(1);
				personData.add(tempPerson);
			}
			closeConnection(stmt);
			return personData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
