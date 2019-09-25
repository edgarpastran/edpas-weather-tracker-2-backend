package com.edpas.measurements;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MeasurementRepository {

	private List<Measurement> data = new ArrayList<Measurement>();
	
	public void insert(Measurement measurement) {
		if (measurement != null) {
			this.data.add(measurement);
		}
	}
	
	public Measurement find(ZonedDateTime timestamp) {
		Measurement measurement = null;
		if (timestamp !=  null) {			
			for (Measurement m: this.data) {
				if (m.getTimestamp().isEqual(timestamp)) {
					measurement = m;
					break;
				}
			}
		}		
		return measurement;
	}
	
	public List<Measurement> findByDates(ZonedDateTime from, ZonedDateTime to) {
		List<Measurement> list = new ArrayList<Measurement>();				
		for (Measurement m: this.data) {
			if ((m.getTimestamp().isEqual(from) || m.getTimestamp().isAfter(from)) && (m.getTimestamp().isBefore(to))) {
				list.add(m);
			}
		}		
		return list;
	}
	
}
