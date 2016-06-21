package keepapp.model.DAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.RowSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import keepapp.model.IElement;
import keepapp.model.Note;
import keepapp.model.implElement;

public class FirebirdNoteDAO2 implements IElementDAO {

	@Override
	public int insertElement(IElement element) {
		String strSQL = "insert into notes (NAME, GROUPNAME, NOTE, ISGROUP) values (?,?,?,?)";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, element.getName());
			stmt.setString(2, element.getGroup());
			stmt.setString(3, element.getNote());
			stmt.setInt(4, element.getIsGroup());
			stmt.executeUpdate();
			FirebirdConnection.closeConnection(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return 0;
	}

	@Override
	public boolean deleteElementByID(int ID) {
		String strSQL = "delete from NOTES where id=?";
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
	public IElement getElementByID(int ID) {
		String strSQL = "select ID, NAME, GROUPNAME, ISGROUP, NOTE from NOTES where ID=?";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setInt(1, ID);
			ResultSet res =  stmt.executeQuery();
			res.next();
			Note note = new Note(res.getInt("id"),res.getString("name"));
			note.setNote(res.getString("note"));
			note.setIsGroup(res.getInt("isgroup"));
			note.setGroup(res.getString("groupname"));
			FirebirdConnection.closeConnection(stmt);
			return note;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
	}

	@Override
	public IElement findElement(IElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateElement(IElement element) {
		String strSQL = "update NOTES set name=?, groupname=?, note=? where id=?";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, element.getName());
			stmt.setString(2, element.getGroup());
			stmt.setString(3, element.getNote());
			stmt.setInt(4, element.getID());
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
	public ObservableList<IElement> getElementData() {
		ObservableList<IElement> elementData = FXCollections.observableArrayList();
		String strSQL = "select id, name from notes where isgroup=0";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {				
				elementData.add(new Note(res.getInt("id"), res.getString("name")));
			}
			FirebirdConnection.closeConnection(stmt);
			return elementData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ObservableList<IElement> getElementGroup() {
		ObservableList<IElement> elementGroup = FXCollections.observableArrayList();
		String strSQL = "select id, name, groupname from notes where isgroup=1";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				IElement tempElement = new implElement(res.getInt("id"), res.getString("name"));
				tempElement.setGroup(res.getString("groupname"));
				elementGroup.add(tempElement);
			}
			FirebirdConnection.closeConnection(stmt);
			return elementGroup;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ObservableList<IElement> getShortElement(String groupName) {
		ObservableList<IElement> elementData = FXCollections.observableArrayList();
		String strSQL = "select id, name from notes where isgroup=0 and groupname=?";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, groupName);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {				
				elementData.add(new implElement(res.getInt("id"), res.getString("name")));
			}
			FirebirdConnection.closeConnection(stmt);
			return elementData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RowSet selectElementRS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printElement() {
		// TODO Auto-generated method stub

	}

}
