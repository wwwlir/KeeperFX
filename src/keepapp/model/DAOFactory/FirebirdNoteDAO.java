package keepapp.model.DAOFactory;

import java.util.Collection;

import javax.sql.RowSet;

import javafx.collections.ObservableList;
import keepapp.model.Note;

public class FirebirdNoteDAO implements NoteDAO {

	@Override
	public int insertNote(Note note) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteNote(Note note) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNoteByID(int ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Note getNoteByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note findNote(Note note) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateNote(Note note) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObservableList<Note> getNoteData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<Note> getNoteGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<Note> getShortNote(String groupName) {
		// TODO Auto-generated method stub
		return null;
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
