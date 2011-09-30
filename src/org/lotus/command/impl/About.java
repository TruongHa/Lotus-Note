package org.lotus.command.impl;

import org.lotus.command.ICommand;
import org.lotus.context.CommandContext;

public class About implements ICommand{

	public void run(CommandContext context) {
		
		System.out.println("Version 0.1b");		
	}

}
