package org.lotus.common.parser.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lotus.common.IParser;
import org.lotus.model.Model;
import org.lotus.model.Task;

public class TaskParser implements IParser {
	
	public List<Model> parse(ResultSet resultSet) throws SQLException{
		List<Model> models = new ArrayList<Model>();
		while(resultSet.next()){
			Task task = new Task();
			task.setId(resultSet.getInt("task_id"));			
			task.setName(resultSet.getString("name"));
			task.setDescription(resultSet.getString("description"));
			task.setEstimateTime(resultSet.getLong("estimate_time"));
			task.setActualTime(resultSet.getLong("actual_time"));
			task.setStatus(resultSet.getInt("status"));
			task.setDate(resultSet.getDate("date"));
			Integer parentId = resultSet.getInt("parent_id");
			Task parent = new Task();
			parent.setId(parentId);
			task.setParent(parent);
			
			models.add(task);
		}
		return models;
	}
}
