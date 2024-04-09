package com.nttdata.exchangerate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelExternResponse {

  private String result;
  private String documentation;
  @JsonProperty("terms_of_use")
  private String termsOfUse;
  @JsonProperty("time_last_update_unix")
  private long timeLastUpdateUnix;
  @JsonProperty("time_last_update_utc")
  private String timeLastUpdateUtc;
  @JsonProperty("time_next_update_unix")
  private long timeNextUpdateUnix;
  @JsonProperty("time_next_update_utc")
  private String timeNextUpdateUtc;
  @JsonProperty("base_code")
  private String baseCode;
  @JsonProperty("conversion_rates")
  private Map<String, Double> conversionRates;





}






