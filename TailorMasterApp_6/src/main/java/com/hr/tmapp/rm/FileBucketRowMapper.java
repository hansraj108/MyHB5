package com.hr.tmapp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hr.tmapp.domain.FileBucket;

public class FileBucketRowMapper implements RowMapper<FileBucket> {

	@Override
	public FileBucket mapRow(ResultSet rs, int rowNum) throws SQLException {
		FileBucket fb = new FileBucket();
		fb.setPhotoId(rs.getInt("PhotoID"));
		fb.setOrderId(rs.getInt("OrderID"));
		fb.setCustomerId(rs.getInt("CustomerID"));
		fb.setName(rs.getString("Name"));
		fb.setType(rs.getString("Type"));
		fb.setContent(rs.getBytes("Content"));
		fb.setDescription(rs.getString("description"));
		fb.setSaveDate(rs.getDate("SaveDate"));
		fb.setMeasurementId(rs.getInt("MeasurementID"));
		return fb;
	}
	
	

}
