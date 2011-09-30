package org.lotus.command.impl;

import org.lotus.command.ICommand;
import org.lotus.context.CommandContext;

public class Help implements ICommand{

	public void run(CommandContext context) {
		
		System.out.println("Help");
	}

}
