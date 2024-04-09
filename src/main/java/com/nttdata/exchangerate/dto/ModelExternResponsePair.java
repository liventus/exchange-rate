package com.nttdata.exchangerate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ModelExternResponsePair {

  @JsonProperty("result")
  private String result;
  @JsonProperty("documentation")
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
  @JsonProperty("target_code")
  private String targetCode;
  @JsonProperty("conversion_rate")
  private double conversionRate;
  @JsonProperty("conversion_result")
  private double conversionResult;


  @Override
  public String toString() {
    return "{" +
        "\"result\":\"" + result + '\"' +
        ", \"documentation\":\"" + documentation + '\"' +
        ", \"terms_of_use\":\"" + termsOfUse + '\"' +
        ", \"time_last_update_unix\":" + timeLastUpdateUnix +
        ", \"time_last_update_utc\":\"" + timeLastUpdateUtc + '\"' +
        ", \"time_next_update_unix\":" + timeNextUpdateUnix +
        ", \"time_next_update_utc\":\"" + timeNextUpdateUtc + '\"' +
        ", \"base_code\":\"" + baseCode + '\"' +
        ", \"target_code\":\"" + targetCode + '\"' +
        ", \"conversion_rate\":" + conversionRate +
        ", \"conversion_result\":" + conversionResult +
        '}';
  }
}
