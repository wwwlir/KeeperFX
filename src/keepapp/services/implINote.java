package keepapp.services;

import javafx.collections.ObservableList;
import keepapp.model.Note;
import keepapp.model.DAOFactory.DAOFactory;
import keepapp.model.DAOFactory.NoteDAO;
import keepapp.services.API.INote;

public class implINote implements INote {
	private NoteDAO noteDAO;
	public implINote(){
		getNoteDAO();
	}
	public void getNoteDAO(){
		DAOFactory firebirtdFactory = DAOFactory.getDAOFactory(DAOFactory.FIREBIRD);
		NoteDAO noteDAO = firebirtdFactory.getNoteDAO();
		this.noteDAO = noteDAO;
	}
	@Override
	public ObservableList<Note> getShortListNote() {
		ObservableList<Note> noteList = noteDAO.getNoteData();
		return noteList;
	}

	@Override
	public ObservableList<Note> getGroupListNote() {
		ObservableList<Note> noteGroupList = noteDAO.getNoteGroup();
		return noteGroupList;
	}

	@Override
	public ObservableList<Note> getShortListNotesF(String groupName) {
		return noteDAO.getShortNote(groupName);
	}

	@Override
	public Note getNoteByID(int ID) {
		return noteDAO.getNoteByID(ID);
	}

	@Override
	public boolean deleteNoteByID(int ID) {
		return noteDAO.deleteNoteByID(ID);
	}

	@Override
	public boolean addNote(Note note) {
		noteDAO.insertNote(note);
		return false;
	}

	@Override
	public boolean updateNoteByID(Note note) {
		return noteDAO.updateNote(note);
	}

}
