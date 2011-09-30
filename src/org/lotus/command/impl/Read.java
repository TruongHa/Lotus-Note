package org.lotus.command.impl;

import java.util.List;

import org.lotus.command.ICommand;
import org.lotus.common.Console;
import org.lotus.context.CommandContext;
import org.lotus.dao.NoteManager;
import org.lotus.model.Note;

public class Read implements ICommand {

	@Override
	public void run(CommandContext context) throws Exception {

		List<String> args = context.getArgs();

		Integer id = null;
		if (args.isEmpty()) {
			System.out.print("Note id to read: ");
			String text = Console.readLine();
			id = Integer.parseInt(text);
		} else {
			id = Integer.parseInt(args.get(1));
		}

		Note note = NoteManager.get(id);
		System.out.println("Name: " + note.getName());
		System.out.println("Content: " + note.getContent());
		System.out.println("Date: " + note.getDate());
	}

}
