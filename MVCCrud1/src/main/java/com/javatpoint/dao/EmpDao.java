package com.javatpoint.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.javatpoint.bean.Emp;

public class EmpDao {

	JdbcTemplate template;
	
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


	public int save(Emp emp) {
		String sql="insert into employee1(name,salary,designation) values('"+emp.getName()+"',"+emp.getSalary()+",'"+emp.getDesignation()+"')";    
	    return template.update(sql);    
	}


	public List<Emp> getEmployees() {
		
		return template.query("select * from employee1", new RowMapper<Emp>() {
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


	public Emp getEmpById(int id) {
		 String sql="select * from employee1 where id=?";    
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));    

	}


	public int update(Emp p) {
		String sql="update employee1 set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";    
	    return template.update(sql);  
		
	}


	public int delete(int id) {
		 String sql="delete from employee1 where id="+id+"";    
		    return template.update(sql);  
		
	}


	public void generatePDF() {
		Document document = new Document();
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\workspace\\MyHB5\\MVCCrud1\\src\\main\\resources\\HelloWorld.pdf"));
	         document.open();
	         document.add(new Paragraph("A Hello World PDF document."));
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
		
	}


	

	
}
