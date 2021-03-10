package com.javatpoint.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.javatpoint.beans.Emp;
import com.javatpoint.mapper.EmpMapper;

@Repository
public class EmpDaoImpl implements EmpDao {

	 final String SAVE_EMP_QUERY = "insert into Emp99(name,salary,designation) values(:name,:salary,:designation)";
	 final String UPDATE_EMP_QUERY = "update Emp99 set name=:name,salary=:salary,designation:designation where id=:id";
	 final String DELETE_EMP_QUERY = "delete from Emp99 where id=:id";
	 final String SELECT_EMP_QUERY = "select id, name, salary, designation from Emp99 where id=:id";
	 final String GET_ALL_EMP_QUERY = "select * from emp99";
	
	 @Autowired
	 private NamedParameterJdbcTemplate template;
	
	public EmpDaoImpl(NamedParameterJdbcTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public void save(final Emp p) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", p.getName());
		map.put("salary", p.getSalary());
		map.put("designation", p.getDesignation());
		
		template.update(SAVE_EMP_QUERY,map);
				
	
	}

	@Override
	public void update(Emp p) {
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id", p.getId())
				.addValue("name", p.getName())
				.addValue("salary", p.getSalary())
				.addValue("designation",p.getDesignation());
		template.update(UPDATE_EMP_QUERY, param,holder);
	}

	@Override
	public void delete(int id) {
		Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("id",id);

		 template.execute(DELETE_EMP_QUERY,map,new PreparedStatementCallback<Object>() {  
		    @Override  
		    public Object doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		        return ps.executeUpdate();  
		    }  
		});  

	}

	@Override
	public Emp getEmpById(int id) {
		SqlParameterSource param = new MapSqlParameterSource("id", Integer.valueOf(id));
		Emp emp = template.queryForObject(SELECT_EMP_QUERY, param, new EmpMapper());
		return emp;
	}

	@Override
	public List<Emp> getEmployees() {
		List<Emp> emps = template.query(GET_ALL_EMP_QUERY, new EmpMapper());
		return emps;
	}

}
