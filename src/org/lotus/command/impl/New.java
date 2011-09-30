package org.lotus.command.impl;

import java.util.Date;
import java.util.List;

import org.lotus.command.ICommand;
import org.lotus.common.Console;
import org.lotus.common.Utils;
import org.lotus.context.CommandContext;
import org.lotus.dao.NoteManager;
import org.lotus.dao.TaskManager;
import org.lotus.model.Note;
import org.lotus.model.Task;

public class New implements ICommand {

	@Override
	public void run(CommandContext context) throws Exception {
		List<String> args = context.getArgs();
		if(args!=null){
			if(args.size()>1){
				String obj = args.get(1);
				if(obj.equalsIgnoreCase("note")){
					newNote(context);
				} else if(obj.equalsIgnoreCase("task")){
					newTask(context);
				}
			} else {
				newNote(context);
			}
		}
	}
	
	private void newNote(CommandContext context) throws Exception{
		System.out.print("Name: ");
		String name = Console.readLine();
		System.out.print("Content: ");
		String content = Console.readLine();
		Note note = new Note();
		note.setName(name);
		note.setContent(content);
		note.setDate(new Date());
		//note = NoteManager.create(note);
		System.out.print("Note created!");
	}
	
	private void newTask(CommandContext context) throws Exception{		
		Task task = new Task();
		
		// set name
		task.setName(Utils.getParameter(context.getArgs(), "-n"));
		if(task.getName()==null){
			Date now = new Date();
			task.setName("noname" + now.getTime());
		}
		
		// set description
		task.setDescription(Utils.getParameter(context.getArgs(), "-d"));
		task.setDate(new Date());
		TaskManager.create(task);
	}

}
