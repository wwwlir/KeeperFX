package keepapp.model.DAOFactory;

import java.util.Collection;

import javax.sql.RowSet;

import javafx.collections.ObservableList;
import keepapp.model.Note;

public interface NoteDAO {
	public int insertNote(Note note);
	public boolean deleteNote(Note note);
	public boolean deleteNoteByID(int ID);
	public Note getNoteByID(int ID);
	public Note findNote(Note note);
	public boolean updateNote(Note note);
	public ObservableList<Note> getNoteData();
	public ObservableList<Note> getNoteGroup();
	public ObservableList<Note> getShortNote(String groupName);
	public RowSet selectNoteRS();
	@SuppressWarnings("rawtypes")
	public Collection selectNoteTO();
	public void printNote();
}
