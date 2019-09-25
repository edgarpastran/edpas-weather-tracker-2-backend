package com.edpas.statistics;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Statistic {
  @JsonProperty("min") MIN,
  @JsonProperty("max") MAX,
  @JsonProperty("average") AVERAGE,
  @JsonProperty("count") COUNT,
  @JsonProperty("sum") SUM,
}
