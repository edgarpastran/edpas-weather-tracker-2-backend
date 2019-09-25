package com.edpas.statistics;

import java.util.List;

import com.edpas.measurements.Measurement;

public interface MeasurementAggregator {
  List<AggregateResult> analyze(List<Measurement> measurements, List<String> metrics, List<Statistic> stats);
}
