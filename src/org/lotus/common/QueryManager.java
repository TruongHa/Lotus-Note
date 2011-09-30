package org.lotus.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.lotus.model.Model;

public class QueryManager {
	
	/**
	 * Execute query and return found data
	 * @param query
	 * @param parser
	 * @return
	 * @throws Exception
	 */
	public static List<Model> execute(String query, IParser parser) throws Exception{		
		Connection con = ConnectionManager.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return parser.parse(rs);
	}
	
	/**
	 * Execute update
	 * @param query
	 * @throws Exception
	 */
	public static void update(String query) throws Exception{
		Connection con = ConnectionManager.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
	}
}
