package com.hr.tmapp.service;

import java.util.List;

import com.hr.tmapp.domain.Measurement;


public interface MeasurementService {

	
	public void insertMeasurement(Measurement m);
	public Measurement getMeasurementByCustomerId(Integer customerId);
	public Measurement getMeasurementByMeasurementId(Integer measurementId);
	public List<Measurement> getAllMeasurement(Integer userId);
	public void updateMeasurement(Measurement m);
	public void deleteMeasurement (Integer measurementId);
	List<Measurement> getAllMeasurementByCustomerId(Integer customerId);
	public void deleteAll(Integer[] measurementId);
	public List<Measurement> searchMeasurement(Integer customerId, String freeText);
	public void update(Measurement measurement);
	
	
}
