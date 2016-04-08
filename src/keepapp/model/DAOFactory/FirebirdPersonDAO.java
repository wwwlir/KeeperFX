package keepapp.model.DAOFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;


import javax.sql.RowSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import keepapp.model.Person;

public class FirebirdPersonDAO implements PersonDAO {
	
	int setIDPerson;
	private final String DRIVER = "org.firebirdsql.jdbc.FBDriver";
	private final String DBURL = "jdbc:firebirdsql:embedded:C:\\FirebirdDatabase\\FDBT.FDB";
	
	private Connection createConnection(){
		Connection conn = null;
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
	private void closeConnection(){
		//conn.close;
		//statement.close();
	}

	@Override
	public int insertPerson(Person person) {
		Date getBirthday = Date.valueOf(person.getBirthday());
		String strSQL = "insert into persons (fname, lname, address, phonenumbers, birthday) values (?,?,?,?,?)";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, person.getFirstName());
			stmt.setString(2, person.getLastName());
			stmt.setString(3, person.getAddress());
			stmt.setString(4, person.getPhoneNumbers());
			stmt.setDate(5, getBirthday);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public boolean deletePerson(Person person) {//����������, �� ������ person
		findPerson(person);
		String strSQL = "delete from PERSONS where id=?";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setInt(1, setIDPerson);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
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
			stmt.close();
			conn.close();
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
		String strSQL = "update PERSONS set lname=?, fname=?, address=?, phonenumbers=?, birthday=? where id=?";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, person.getFirstName());
			stmt.setString(2, person.getLastName());
			stmt.setString(3, person.getAddress());
			stmt.setString(4, person.getPhoneNumbers());
			stmt.setDate(5, getBirthday);
			stmt.setInt(6, setIDPerson);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public RowSet selectPersonRS() {
		// TODO Auto-generated method stub
		return null;
	}

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
	public ObservableList<Person> getPersonData() {//����������, �������� ID, ������ ������� �����
		ObservableList<Person> personData = FXCollections.observableArrayList();
		String strSQL = "select id, fname, lname from persons";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				personData.add(new Person(res.getInt("id"), res.getString("fname"),res.getString("lname")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return personData;
	}
	@Override
	public Person getPersonByID(int ID) {
		String strSQL = "select * from PERSONS where ID=?";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setInt(1, ID);
			ResultSet res =  stmt.executeQuery();
			res.next();
			Person person = new Person(res.getInt("id"),res.getString("fname"),res.getString("lname"));
			person.setAddress(res.getString("address"));
			person.setPhoneNumbers(res.getString("phoneNumbers"));
			//person.setNote(res.getString("city"));
			Date birthDate = res.getDate("birthday");
			LocalDate birthLocalDate = birthDate.toLocalDate(); 
			person.setBirthday(birthLocalDate);
			stmt.close();
			conn.close();
			return person;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean deletePersonByID(int ID) {//�������� �� �������
		String strSQL = "delete from PERSONS where id=?";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setInt(1, ID);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
