package org.lotus.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.lotus.model.Model;

public interface IParser {

	public abstract List<Model> parse(ResultSet resultSet) throws SQLException;

}
