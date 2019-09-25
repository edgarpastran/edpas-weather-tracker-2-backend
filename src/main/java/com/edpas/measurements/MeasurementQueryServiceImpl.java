package com.edpas.measurements;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementQueryServiceImpl implements MeasurementQueryService {

	@Autowired
	MeasurementRepository repository;
	
	@Override
	public List<Measurement> queryDateRange(ZonedDateTime from, ZonedDateTime to) {		
		return this.repository.findByDates(from, to);
	}

}
