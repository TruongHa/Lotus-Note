package org.lotus;

import java.util.List;

import org.lotus.command.ICommand;
import org.lotus.common.Console;
import org.lotus.common.Utils;
import org.lotus.context.CommandContext;
import org.lotus.context.persistence.PersistenceContext;
import org.lotus.dao.DAOManager;
import org.lotus.dao.NoteManager;
import org.lotus.model.Note;

public class Main {

	/**
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {

		load();
		String command = null;
		do {
			command = Console.readLine();
			execute(command, args);
		} while (!command.equalsIgnoreCase("exit"));
		persist();
	}

	/**
	 * Load data from db into persistence context
	 * @throws Exception 
	 */
	public static void load() throws Exception {
		List<Note> notes = NoteManager.getAll();
		for(Note note:notes){
			PersistenceContext.put(note.toString(), note);
		}
	}

	/**
	 * Save data from persistence to db
	 */
	public static void persist() {

	}

	/**
	 * Execute each command
	 * 
	 * @param line
	 * @param args
	 * @throws Exception
	 */
	public static void execute(String line, String[] args) throws Exception {

		List<String> parts = Utils.buildParameters(line);

		if ((parts != null) && parts.size() > 0) {
			String command = capitalize(parts.get(0));
			if (command != null) {
				String className = "org.lotus.command.impl." + command;
				ICommand comm = (ICommand) Class.forName(className)
						.newInstance();
				comm.run(new CommandContext(parts));
			}
		}
	}

	private static String capitalize(String text) {
		if ((text != null) && (!text.isEmpty())) {
			String firstLetter = text.substring(0, 1).toUpperCase();
			String afterText = text.substring(1).toLowerCase();
			String newText = firstLetter + afterText;
			return newText;
		}
		return null;
	}
}
