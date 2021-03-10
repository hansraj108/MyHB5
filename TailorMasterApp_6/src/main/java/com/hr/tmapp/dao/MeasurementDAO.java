package com.hr.tmapp.dao;

import java.util.List;

import com.hr.tmapp.domain.Measurement;


public interface MeasurementDAO {

	public void save(Measurement measurement);
	public void update(Measurement measurement);
	public void delete(Measurement measurement);
	public void deleteByCustomerId(Integer customerId);
	public void deleteByMeasurementId(Integer measurementId);
	public Measurement findByCustomerId(Integer customerId);
	public Measurement findByMeasurementId(Integer measurementId);
	public List<Measurement>  findAllByCustomerId(Integer customerId);
	public List<Measurement> findAll();
	public List<Measurement> findByProperty(String propName, Object PropValue);
}
