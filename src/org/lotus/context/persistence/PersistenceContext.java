package org.lotus.context.persistence;

import java.util.HashMap;
import java.util.Map;

import org.lotus.model.Model;

public class PersistenceContext {

	private static Map<String, Model> persistenceContext = new HashMap<String, Model>();

	public static void put(String name, Model model) {
		persistenceContext.put(name, model);
	}

	public static Model get(String name) {

		return persistenceContext.get(name);
	}

	public static Map<String, Model> getPersistenceContext() {
		return persistenceContext;
	}

	public static void setPersistenceContext(
			Map<String, Model> persistenceContext) {
		PersistenceContext.persistenceContext = persistenceContext;
	}
}
