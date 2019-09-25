package com.edpas.statistics;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.edpas.measurements.Measurement;

@Service
public class MeasurementAggregatorImpl implements MeasurementAggregator {

	@Override
	public List<AggregateResult> analyze(List<Measurement> measurements, List<String> metrics, List<Statistic> stats) {
		List<AggregateResult> list = new ArrayList<AggregateResult>();
		
		Map<String, List<Double>> valuesByMetric = new HashMap<String, List<Double>>();		
		for (String metric: metrics) {
			List<Double> values = measurements.stream().filter(m -> m.getMetrics().containsKey(metric)).map(m -> m.getMetric(metric)).collect(Collectors.toList());
			if (values.size() > 0) {
				valuesByMetric.put(metric, values);
			}
		}
		
		for (Entry<String, List<Double>> entry: valuesByMetric.entrySet()) {		
			DoubleSummaryStatistics statistics = entry.getValue().stream().mapToDouble((x) -> x).summaryStatistics();
			for(Statistic statistic: stats) {
				double value = 0;
				if (statistic.equals(Statistic.MIN)) {
					value = statistics.getMin();
				}
				else if (statistic.equals(Statistic.MAX)) {
					value = statistics.getMax();
				}
				else if (statistic.equals(Statistic.AVERAGE)) {
					value = statistics.getAverage();
					value = Math.round(value * 100.0)/100.0;
				}
				else if (statistic.equals(Statistic.COUNT)) {
					value = statistics.getCount();
				}
				else if (statistic.equals(Statistic.SUM)) {
					value = statistics.getSum();
				}				
				AggregateResult result = new AggregateResult(entry.getKey(), statistic, value);
				list.add(result);
			}
		}
		return list;
	}

}
