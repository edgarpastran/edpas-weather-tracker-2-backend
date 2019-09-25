package com.edpas.measurements;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementStoreImpl implements MeasurementStore {	
	
	@Autowired
	MeasurementRepository repository;
	
	
	@Override
	public void add(Measurement measurement) {
		this.repository.insert(measurement);	
	}

	@Override
	public Measurement fetch(ZonedDateTime timestamp) {
		return this.repository.find(timestamp);
	}

}
