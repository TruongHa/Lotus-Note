package org.lotus.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {

	public static int DATETIME = 0;

	private static SimpleDateFormat datetimeFormmater = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm:ss");

	/**
	 * Format Date
	 * @param date
	 * @param formatType
	 * @return
	 */
	public static String format(Date date, int formatType) {

		// Set the formatter
		SimpleDateFormat sdf = null;
		if (formatType == DATETIME) {
			sdf = datetimeFormmater;
		}

		// Format
		if (sdf != null)
			return sdf.format(date);

		return null;
	}
	
	/**
	 * Build the parameters got from command line
	 * @param line
	 * @return
	 */
	public static List<String> buildParameters(String line){
		
		String[] parts = line.split(" ");
		List<String> parameters = new ArrayList<String>();
		
		boolean combination = false;
		
		// get parts of command line
		for(String part:parts){
			
			if(!combination){
				parameters.add(part);				
			} else {
				parameters.set(parameters.size()-1, parameters.get(parameters.size()-1) + " " + part);
			}
			
			if(part.contains("'")){
				combination = !combination;
			}
		}
		
		// optimize each part
		for(int i=0; i<parameters.size(); i++){
			String parameter = parameters.get(i).trim();
			if(parameter.contains("'")){
				parameter = parameter.substring(1, parameter.length()-1);
			}				
			parameter = parameter.trim();
			parameters.set(i, parameter);
		}
		
		return parameters;
	}
	
	/**
	 * Get parameter value from the list of arguments
	 * @param args
	 * @param parameter
	 * @return
	 */
	public static String getParameter(List<String> args, String parameter){
		int index = args.indexOf(parameter);
		if (index >= 0) {
			if (index + 1 < args.size()) {
				return args.get(index + 1);
			}
		}
		return "";
	}
}
