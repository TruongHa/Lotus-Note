package org.lotus.common.parser.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lotus.common.IParser;
import org.lotus.model.Model;
import org.lotus.model.Note;

public class NoteParser implements IParser {
	
	public List<Model> parse(ResultSet resultSet) throws SQLException{
		List<Model> models = new ArrayList<Model>();
		while(resultSet.next()){
			Note note = new Note();
			note.setId(resultSet.getInt("note_id"));
			note.setName(resultSet.getString("name"));
			note.setContent(resultSet.getString("content"));
			note.setDate(resultSet.getDate("date"));
			note.setRetired(resultSet.getInt("retired")==1);
			models.add(note);
		}
		return models;
	}
}
