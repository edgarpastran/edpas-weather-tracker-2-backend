package com.edpas.measurements;

import java.util.List;
import java.time.ZonedDateTime;

public interface MeasurementQueryService {
  List<Measurement> queryDateRange(ZonedDateTime from, ZonedDateTime to);
}
