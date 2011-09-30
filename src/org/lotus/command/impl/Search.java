package org.lotus.command.impl;

import java.util.Date;
import java.util.List;

import org.lotus.command.ICommand;
import org.lotus.common.Console;
import org.lotus.context.CommandContext;
import org.lotus.dao.NoteManager;
import org.lotus.dao.TaskManager;
import org.lotus.model.Note;
import org.lotus.model.Task;

public class Search implements ICommand {

	@Override
	public void run(CommandContext context) throws Exception {
		List<String> args = context.getArgs();
		if (args != null) {
			if (args.size() > 1) {
				String obj = args.get(1);
				if (obj.equalsIgnoreCase("note")) {
					newNote(context);
				} else if (obj.equalsIgnoreCase("task")) {
					searchTask(context);
				}
			} else {
				newNote(context);
			}
		}
	}

	private void newNote(CommandContext context) throws Exception {
		
	}

	/**
	 * Search task
	 * @param context
	 * @throws Exception
	 */
	private void searchTask(CommandContext context) throws Exception {
		String name = context.getArgs().get(2);
		List<Task> tasks = TaskManager.search(name);
		for(Task task:tasks){
			System.out.println(task);
		}
		
	}

}
