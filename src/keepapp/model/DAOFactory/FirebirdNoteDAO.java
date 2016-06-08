package keepapp.model.DAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.RowSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import keepapp.model.Link;
import keepapp.model.Note;

public class FirebirdNoteDAO implements NoteDAO {

	@Override
	public int insertNote(Note note) {
		String strSQL = "insert into notes (NAME, GROUPNAME, NOTE, ISGROUP) values (?,?,?,?)";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, note.getName());
			stmt.setString(2, note.getGroup());
			stmt.setString(3, note.getNote());
			stmt.setInt(4, note.getIsGroup());
			stmt.executeUpdate();
			FirebirdConnection.closeConnection(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return 0;
	}

	@Override
	public boolean deleteNote(Note note) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNoteByID(int ID) {
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
	public Note getNoteByID(int ID) {
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
	public Note findNote(Note note) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateNote(Note note) {
		String strSQL = "update NOTES set name=?, groupname=?, note=? where id=?";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, note.getName());
			stmt.setString(2, note.getGroup());
			stmt.setString(3, note.getNote());
			stmt.setInt(4, note.getID());
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
	public ObservableList<Note> getNoteData() {
		ObservableList<Note> noteData = FXCollections.observableArrayList();
		String strSQL = "select id, name from notes where isgroup=0";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {				
				noteData.add(new Note(res.getInt("id"), res.getString("name")));
			}
			FirebirdConnection.closeConnection(stmt);
			return noteData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ObservableList<Note> getNoteGroup() {
		ObservableList<Note> noteGroup = FXCollections.observableArrayList();
		String strSQL = "select id, name, groupname from notes where isgroup=1";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				Note tempNote = new Note(res.getInt("id"), res.getString("name"));
				tempNote.setGroup(res.getString("groupname"));
				noteGroup.add(tempNote);
			}
			FirebirdConnection.closeConnection(stmt);
			return noteGroup;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ObservableList<Note> getShortNote(String groupName) {
		ObservableList<Note> noteData = FXCollections.observableArrayList();
		String strSQL = "select id, name from notes where isgroup=0 and groupname=?";
		try {
			Connection conn = FirebirdConnection.createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, groupName);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {				
				noteData.add(new Note(res.getInt("id"), res.getString("name")));
			}
			FirebirdConnection.closeConnection(stmt);
			return noteData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RowSet selectNoteRS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectNoteTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printNote() {
		// TODO Auto-generated method stub

	}

}
