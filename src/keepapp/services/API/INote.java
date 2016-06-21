package keepapp.services.API;

import javafx.collections.ObservableList;
import keepapp.model.Note;

public interface INote {
	public ObservableList<Note> getShortListNote();
	public ObservableList<Note> getGroupListNote();
	public ObservableList<Note> getShortListNotesF(String groupName);
	public Note getNoteByID(int ID);
	public boolean deleteNoteByID(int ID);
	public boolean addNote(Note note);
	public boolean updateNoteByID(Note note);
}
