package com.javatpoint.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.javatpoint.beans.Emp;
import com.javatpoint.mapper.EmpMapper;

public class EmpDao {  
	
	
	NamedParameterJdbcTemplate template;  
	
    
public EmpDao(NamedParameterJdbcTemplate template) {
		super();
		this.template = template;
	}

	 final String SAVE_EMP_QUERY = "insert into Emp99(name,salary,designation) values(:name,:salary,:designation)";
	 final String UPDATE_EMP_QUERY = "update Emp99 set name=:name,salary=:salary,designation=:designation where id=:id";
	 final String DELETE_EMP_QUERY = "delete from Emp99 where id=:id";
	 final String SELECT_EMP_QUERY = "select id, name, salary, designation from Emp99 where id=:id";
	 final String GET_ALL_EMP_QUERY = "select * from emp99";
	
	 

	public void save(final Emp p) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", p.getName());
		map.put("salary", p.getSalary());
		map.put("designation", p.getDesignation());
		
		template.update(SAVE_EMP_QUERY,map);
				
	
	}

	public void update(Emp p) {
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id", p.getId())
				.addValue("name", p.getName())
				.addValue("salary", p.getSalary())
				.addValue("designation",p.getDesignation());
		template.update(UPDATE_EMP_QUERY, param,holder);
	}

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

	public Emp getEmpById(int id) {
		SqlParameterSource param = new MapSqlParameterSource("id", Integer.valueOf(id));
		Emp emp = template.queryForObject(SELECT_EMP_QUERY, param, new EmpMapper());
		return emp;
	}

	public List<Emp> getEmployees() {
		List<Emp> emps = template.query(GET_ALL_EMP_QUERY, new EmpMapper());
		return emps;
	}
/*	
	@Autowired
	JdbcTemplate template;  
	
    
public EmpDao(JdbcTemplate template) {
		super();
		this.template = template;
	}
    
public int save(Emp p){    
    String sql="insert into Emp99(name,salary,designation) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";    
    return template.update(sql);    
}    
public int update(Emp p){    
    String sql="update Emp99 set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";    
    return template.update(sql);    
}    
public int delete(int id){    
    String sql="delete from Emp99 where id="+id+"";    
    return template.update(sql);    
}    
public Emp getEmpById(int id){    
    String sql="select * from Emp99 where id=?";    
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));    
}    
public List<Emp> getEmployees(){    
    return template.query("select * from Emp99",new RowMapper<Emp>(){    
        public Emp mapRow(ResultSet rs, int row) throws SQLException {    
            Emp e=new Emp();    
            e.setId(rs.getInt(1));    
            e.setName(rs.getString(2));    
            e.setSalary(rs.getFloat(3));    
            e.setDesignation(rs.getString(4));    
            return e;    
        }    
    });    
} 

*/
}