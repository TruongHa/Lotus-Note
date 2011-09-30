package org.lotus.dao;

import java.util.ArrayList;
import java.util.List;

import org.lotus.common.QueryManager;
import org.lotus.common.Utils;
import org.lotus.common.parser.impl.NoteParser;
import org.lotus.model.Note;

public class NoteManager {

	/**
	 * Create a new note
	 * 
	 * @param note
	 * @throws Exception
	 */
	public static void create(Note note) throws Exception {
		String query = String
				.format("INSERT INTO note (name, content, date) VALUES ('%s', '%s', '%s')",
						note.getName(), note.getContent(),
						Utils.format(note.getDate(), Utils.DATETIME));
		QueryManager.update(query);		
	}

	/**
	 * Get note by id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static Note get(int id) throws Exception {
		
		return null;
	}

	/**
	 * Delete a note
	 * 
	 * @param note
	 * @throws Exception
	 */
	public static void delete(Note note) throws Exception {
		
	}
	
	/**
	 * Get all notes which are not required
	 * @return
	 * @throws Exception
	 */
	public static List<Note> getAll() throws Exception {
		String query = "SELECT * FROM note WHERE retired = 0;";
		@SuppressWarnings("rawtypes")
		List list = QueryManager.execute(query, new NoteParser());

		// Return
		if ((list != null) && (!list.isEmpty())) {
			List<Note> notes = new ArrayList<Note>();
			for (Object obj : list) {
				Note note = (Note) obj;
				notes.add(note);
			}
			return notes;
		} else {
			return null;
		}
	}
}
