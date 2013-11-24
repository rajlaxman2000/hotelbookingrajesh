package com.hostel.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;



public abstract class GenericDAO {

		protected NamedParameterJdbcTemplate jdbcTemplate;
		protected JdbcTemplate oldJdbcTemplate;

		/**
		 * @param dataSource
		 *            the dataSource to create jdbcTemplate
		 */
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			this.oldJdbcTemplate = new JdbcTemplate(dataSource);
		}
		
		
		

}
