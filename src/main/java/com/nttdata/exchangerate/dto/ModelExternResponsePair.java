package com.nttdata.exchangerate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Map;

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


  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getDocumentation() {
    return documentation;
  }

  public void setDocumentation(String documentation) {
    this.documentation = documentation;
  }

  public String getTermsOfUse() {
    return termsOfUse;
  }

  public void setTermsOfUse(String termsOfUse) {
    this.termsOfUse = termsOfUse;
  }

  public long getTimeLastUpdateUnix() {
    return timeLastUpdateUnix;
  }

  public void setTimeLastUpdateUnix(long timeLastUpdateUnix) {
    this.timeLastUpdateUnix = timeLastUpdateUnix;
  }

  public String getTimeLastUpdateUtc() {
    return timeLastUpdateUtc;
  }

  public void setTimeLastUpdateUtc(String timeLastUpdateUtc) {
    this.timeLastUpdateUtc = timeLastUpdateUtc;
  }

  public long getTimeNextUpdateUnix() {
    return timeNextUpdateUnix;
  }

  public void setTimeNextUpdateUnix(long timeNextUpdateUnix) {
    this.timeNextUpdateUnix = timeNextUpdateUnix;
  }

  public String getTimeNextUpdateUtc() {
    return timeNextUpdateUtc;
  }

  public void setTimeNextUpdateUtc(String timeNextUpdateUtc) {
    this.timeNextUpdateUtc = timeNextUpdateUtc;
  }

  public String getBaseCode() {
    return baseCode;
  }

  public void setBaseCode(String baseCode) {
    this.baseCode = baseCode;
  }

  public String getTargetCode() {
    return targetCode;
  }

  public void setTargetCode(String targetCode) {
    this.targetCode = targetCode;
  }

  public double getConversionRate() {
    return conversionRate;
  }

  public void setConversionRate(double conversionRate) {
    this.conversionRate = conversionRate;
  }

  public double getConversionResult() {
    return conversionResult;
  }

  public void setConversionResult(double conversionResult) {
    this.conversionResult = conversionResult;
  }

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
