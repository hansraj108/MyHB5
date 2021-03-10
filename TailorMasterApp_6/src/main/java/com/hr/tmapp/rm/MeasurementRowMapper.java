package com.hr.tmapp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hr.tmapp.domain.Measurement;

public class MeasurementRowMapper implements RowMapper<Measurement> {

	@Override
	public Measurement mapRow(ResultSet rs, int rowNum) throws SQLException {
		Measurement m = new Measurement();
		m.setLastUpdate(rs.getDate("LastUpdate"));
		m.setShirtLength(rs.getString("ShirtLength"));
		m.setArmLength(rs.getString("armLength"));
		m.setNeck(rs.getString("Neck"));
		m.setChest(rs.getString("Chest"));
		m.setWaist(rs.getString("Waist"));
		m.setRemark(rs.getString("Remark"));
		m.setMeasurementId(rs.getInt("MeasurementId"));
		m.setCustomerId(rs.getInt("CustomerId"));
		
		return m;
	}

}
