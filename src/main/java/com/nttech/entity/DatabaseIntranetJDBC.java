package com.nttech.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseIntranetJDBC {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void getUser() {
		String sql = "SELECT * FROM `user`";
		List<Employee> list =  jdbcTemplate.query(sql, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.name = rs.getString("name");
				employee.age = rs.getInt("age");
				// TODO Auto-generated method stub
				return employee;
			}
			
		});
		
		for(Employee  employee: list) {
			System.out.println("Value: " + employee.name + "Age" + employee.age);
		}
	}

}
