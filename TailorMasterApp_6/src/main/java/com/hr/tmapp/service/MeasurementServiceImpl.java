package com.hr.tmapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.tmapp.dao.BaseDAO;
import com.hr.tmapp.dao.MeasurementDAO;
import com.hr.tmapp.domain.Measurement;
import com.hr.tmapp.rm.MeasurementRowMapper;
import com.hr.tmapp.util.StringUtil;

@Service
public class MeasurementServiceImpl extends BaseDAO implements MeasurementService {

	@Autowired
	private MeasurementDAO measurementDAO;
	
	@Override
	public void insertMeasurement(Measurement m) {
		measurementDAO.save(m);
		
	}

	@Override
	public Measurement getMeasurementByCustomerId(Integer customerId) {
		return measurementDAO.findByCustomerId(customerId);
		
	}
	
	@Override
	public List<Measurement> getAllMeasurementByCustomerId(Integer customerId) {
		return measurementDAO.findAllByCustomerId(customerId);
		
	}

	@Override
	public List<Measurement> getAllMeasurement(Integer userId) {
		// TODO Auto-generated method stub
		return measurementDAO.findByProperty("userId", userId);
	}
	
	@Override
	public List<Measurement> searchMeasurement(Integer customerId, String text) {
		String sql = "SELECT MeasurementID, CustomerID, LastUpdate,  ShirtLength, ArmLength, Neck, Chest, Waist, Remark "
				+ "FROM measurements WHERE customerId=? AND (MeasurementID LIKE '%"+text+"%' OR CustomerID LIKE '%"+text+"%' OR LastUpdate LIKE '%"+text+"%' OR ShirtLength LIKE '%"+text+"%' OR ArmLength LIKE '%"+text+"%' OR Neck LIKE '%"+text+"%' OR Chest LIKE '%"+text+"%'  OR Waist LIKE '%"+text+"%' OR Remark LIKE '%"+text+"%')";
		return getJdbcTemplate().query(sql, new MeasurementRowMapper(), customerId);
	}
	
	@Override
	public Measurement getMeasurementByMeasurementId(Integer measurementId) {
		return measurementDAO.findByMeasurementId(measurementId);
	}

	@Override
	public void updateMeasurement(Measurement m) {
		measurementDAO.update(m);
		
	}

	@Override
	public void deleteMeasurement(Integer measurementId) {
		measurementDAO.deleteByMeasurementId(measurementId);
		
	}
	
	@Override
	public void deleteAll(Integer[] measurementId) {
		String ids = StringUtil.toCommaSeperatedString(measurementId);
		String sql = "DELETE FROM measurements WHERE MeasurementId IN ("+ids+") ";
		getJdbcTemplate().update(sql);
		
	}

	@Override
	public void update(Measurement measurement) {
		measurementDAO.update(measurement);
		
	}

	

	

}
