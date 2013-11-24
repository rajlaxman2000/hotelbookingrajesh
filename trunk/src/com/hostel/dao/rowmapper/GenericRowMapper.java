
package com.hostel.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.JdbcUtils;

/**
 * Generic Row Mapper class. All row mapper class should extend this class.
 *
 * @(#) GenericRowMapper.javas 
 */
public abstract class GenericRowMapper<T> implements ParameterizedRowMapper<T> {

	protected List<String> columns;

	@Override
	public abstract T mapRow(ResultSet rs, int rowNum) throws SQLException;

	/**
	 * Method will populate the column names available in result set
	 *
	 * @param rs
	 * @throws SQLException
	 */
	protected void initColumnNames(ResultSet rs) throws SQLException {
		ResultSetMetaData rsMetaData = rs.getMetaData();
		this.columns = new ArrayList<String>(rsMetaData.getColumnCount());

		for(int i = 1; i <= rsMetaData.getColumnCount(); i++) {
			this.columns.add(JdbcUtils.lookupColumnName(rsMetaData, i));
		}
	}
}