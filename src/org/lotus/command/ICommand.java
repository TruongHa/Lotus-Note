package org.lotus.command;

import org.lotus.context.CommandContext;

public interface ICommand {
	
	public void run(CommandContext context) throws Exception;
}
