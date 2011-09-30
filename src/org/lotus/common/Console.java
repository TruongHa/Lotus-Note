package org.lotus.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

	private static InputStreamReader input = new InputStreamReader(System.in);
	private static BufferedReader reader = new BufferedReader(input);

	public static String readLine() throws IOException {
		return reader.readLine();
	}
}
