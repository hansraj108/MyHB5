package com.hr.tmapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hr.tmapp.domain.Measurement;
import com.hr.tmapp.rm.MeasurementRowMapper;

@Repository
public class MeasurementDAOImpl extends BaseDAO implements MeasurementDAO{

	@Override
	public void save(Measurement measurement) {
		String sql = "INSERT INTO measurements (CustomerId, LastUpdate, ShirtLength, ArmLength, Neck, Chest, Waist, Remark) "
				+ "VALUES (:customerId,:lastUpdate, :shirtLength, :armLength, :neck, :chest, :waist, :remark)";
		System.out.println("MeasurementDAOImpl-----------save(Measurement measurement)");
		System.out.println(measurement.getLastUpdate());
		Map m = new HashMap();
		m.put("customerId", measurement.getCustomerId());
		m.put("lastUpdate", measurement.getLastUpdate());
		m.put("shirtLength", measurement.getShirtLength());
		m.put("armLength",measurement.getArmLength());
		m.put("neck",measurement.getNeck());
		m.put("chest",measurement.getChest());
		m.put("waist", measurement.getWaist());
		m.put("remark", measurement.getRemark());
		
		
		SqlParameterSource ps = new MapSqlParameterSource(m);
		KeyHolder kh = new GeneratedKeyHolder();
		
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		Integer measurementId = kh.getKey().intValue();
		measurement.setMeasurementId(measurementId);
		
	}

	@Override
	public void update(Measurement measurement) {
		String sql = "UPDATE measurements "
                + " SET LastUpdate=:lastUpdate,"
                + " ShirtLength=:shirtLength, "
                + " ArmLength=:armLength, "
                + " Neck=:neck,"
                + " Chest=:chest,"
                + " Waist=:waist, "
                + " Remark=:remark "
                + " WHERE MeasurementID = :measurementId ";
        Map m = new HashMap();
        m.put("lastUpdate", measurement.getLastUpdate());
		m.put("shirtLength", measurement.getShirtLength());
		m.put("armLength",measurement.getArmLength());
		m.put("neck",measurement.getNeck());
		m.put("chest",measurement.getChest());
		m.put("waist", measurement.getWaist());
		m.put("remark", measurement.getRemark());
		m.put("measurementId", measurement.getMeasurementId());
       
        SqlParameterSource ps = new MapSqlParameterSource(m);
        getNamedParameterJdbcTemplate().update(sql, ps);
		
	}

	@Override
	public void delete(Measurement measurement) {
		this.deleteByCustomerId(measurement.getCustomerId());
		
	}

	@Override
	public void deleteByCustomerId(Integer customerId) {
		String sql = "DELETE FROM measurements WHERE CustomerId=?";
		getJdbcTemplate().update(sql, customerId);
		
	}

	@Override
	public void deleteByMeasurementId(Integer measurementId) {
		String sql = "DELETE FROM measurements WHERE MeasurementId=?";
		getJdbcTemplate().update(sql, measurementId);
		
	}
	@Override
	public Measurement findByCustomerId(Integer customerId) {
		String sql = "SELECT MeasurementID, CustomerID, LastUpdate,  ShirtLength, ArmLength, Neck, Chest, Waist, Remark "
				+ " FROM measurements WHERE CustomerID = ?";
		Measurement measurement = getJdbcTemplate().queryForObject(sql, new MeasurementRowMapper(),customerId);
		return measurement;
	}
	
	@Override
	public List<Measurement>  findAllByCustomerId(Integer customerId) {
		return findByProperty("CustomerId", customerId);
	}

	@Override
	public Measurement findByMeasurementId(Integer measurementId) {
		return findSingleRecordByProperty("MeasurementId", measurementId);
	}
	
	
	public Measurement findSingleRecordByProperty(String propName, Object PropValue) {
		String sql = "SELECT MeasurementID, CustomerID, LastUpdate,  ShirtLength, ArmLength, Neck, Chest, Waist, Remark "
				+ " FROM measurements "
				+ " WHERE "+propName+
				" = ? ORDER BY MeasurementID DESC";
		Measurement measurement = getJdbcTemplate().queryForObject(sql, new MeasurementRowMapper(), PropValue);
		return measurement;
	}
	
	@Override
	public List<Measurement> findAll() {
		String sql = "SELECT MeasurementID, CustomerID, LastUpdate,  ShirtLength, ArmLength, Neck, Chest, Waist, Remark "
				+ " FROM measurements";
		List<Measurement> measurementList = getJdbcTemplate().query(sql, new MeasurementRowMapper());
		return measurementList;
	}

	@Override
	public List<Measurement> findByProperty(String propName, Object PropValue) {
		String sql = "SELECT MeasurementID, CustomerID, LastUpdate,  ShirtLength, ArmLength, Neck, Chest, Waist, Remark "
				+ " FROM measurements "
				+ " WHERE "+propName+
				" = ? ORDER BY MeasurementID DESC";
		List<Measurement> measurementList = getJdbcTemplate().query(sql, new MeasurementRowMapper(), PropValue);
		return measurementList;
	}
	
	

	

	

}
