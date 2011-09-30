package org.lotus.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.lotus.common.ConnectionManager;
import org.lotus.context.persistence.PersistenceContext;
import org.lotus.model.Model;

public class DAOManager {

	/**
	 * Merge model
	 * 
	 * @param model
	 * @throws Exception
	 */
	public static <E extends Model> E merge(E model) throws Exception {
		if(model.getId()==null){
			Integer id = getNewId(model.getClass().getSimpleName());
			model.setId(id);
		}
		PersistenceContext.put(model.toString(), model);
		return model;
	}

	private static Integer getNewId(String name) throws Exception {
		String query = "SHOW TABLE STATUS LIKE '" + name + "'";
		Connection con = ConnectionManager.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			return rs.getInt("Auto_increment");
		}
		return 1;
	}

	/**
	 * Get model
	 * 
	 * @param <E>
	 * @param id
	 * @param clss
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	public static <E extends Model> E get(int id, Class<E> clss)
			throws InstantiationException, IllegalAccessException {
		E e = clss.newInstance();
		e.setId(id);
		E m = (E) PersistenceContext.get(e.toString());
		if (!m.isRetired())
			return m;
		else
			return null;
	}

	/**
	 * Remove model
	 * 
	 * @param model
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static void remove(Model model) throws InstantiationException,
			IllegalAccessException {
		Model foundModel = get(model.getId(), model.getClass());
		foundModel.setRetired(true);
		PersistenceContext.put(foundModel.toString(), foundModel);
	}
}
