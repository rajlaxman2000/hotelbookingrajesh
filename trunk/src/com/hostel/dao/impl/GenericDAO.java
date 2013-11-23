package com.hostel.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;



public abstract class GenericDAO {

		protected NamedParameterJdbcTemplate jdbcTemplate;

		/**
		 * @param dataSource
		 *            the dataSource to create jdbcTemplate
		 */
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		}

}
