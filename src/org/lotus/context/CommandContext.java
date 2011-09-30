package org.lotus.context;

import java.util.List;

public class CommandContext {

	private List<String> args;

	public CommandContext(List<String> args) {		
		this.args = args;
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}

}
