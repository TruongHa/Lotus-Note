package org.lotus.dao;

import java.util.ArrayList;
import java.util.List;

import org.lotus.common.QueryManager;
import org.lotus.common.Utils;
import org.lotus.common.parser.impl.TaskParser;
import org.lotus.model.Task;

public class TaskManager {

	/**
	 * Create a new task
	 * 
	 * @param task
	 * @throws Exception
	 */
	public static Task create(Task task) throws Exception {
		String query = String
				.format("INSERT INTO task (name, description, estimate_time, actual_time, status, date) VALUES ('%s', '%s', %s, %s, %s, '%s')",
						task.getName(), task.getDescription(),
						task.getEstimateTime(), task.getActualTime(),
						task.getStatus(),
						Utils.format(task.getDate(), Utils.DATETIME));
		QueryManager.update(query);
		return getLast();
	}

	/**
	 * Get task by id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static Task get(int id) throws Exception {
		String query = String.format("SELECT * FROM task WHERE task_id = %s",
				id);
		@SuppressWarnings("rawtypes")
		List list = QueryManager.execute(query, new TaskParser());
		if ((list != null) && (!list.isEmpty())) {
			return (Task) list.get(0);
		}
		return null;
	}

	/**
	 * Delete a task
	 * 
	 * @param task
	 * @throws Exception
	 */
	public static void delete(Task task) throws Exception {
		String query = String.format("DELETE FROM task WHERE task_id = %s",
				task.getId());
		QueryManager.update(query);
	}

	/**
	 * Get last task
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Task getLast() throws Exception {

		// String query = String
		// .format("SELECT * FROM task ORDER BY task_id DESC LIMIT 0, 1");
		// @SuppressWarnings("rawtypes")
		// List list = QueryManager.execute(query, new TaskParser());
		// if ((list != null) && (!list.isEmpty())) {
		// return (Task) list.get(0);
		// }
		return null;
	}

	/**
	 * Search using pattern
	 * 
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	public static List<Task> search(String name) throws Exception {
		String query = "SELECT * FROM task t WHERE t.name LIKE '%" + name + "%'";
		@SuppressWarnings("rawtypes")
		List list = QueryManager.execute(query, new TaskParser());
		List<Task> tasks = new ArrayList<Task>();
		for (Object obj : list) {
			tasks.add((Task) obj);
		}
		return tasks;
	}

}
