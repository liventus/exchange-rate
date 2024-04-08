package com.nttdata.exchangerate.dto;


import java.math.BigDecimal;
import java.util.Map;

public class ModelExternResponsePair {


    public String result;
    public String documentation;
    public String terms_of_use;
    public int time_last_update_unix;
    public String time_last_update_utc;
    public int time_next_update_unix;
    public String time_next_update_utc;
    public String base_code;
    public String target_code;
    public BigDecimal conversion_rate;
    public BigDecimal conversion_result;

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

  public String getTerms_of_use() {
    return terms_of_use;
  }

  public void setTerms_of_use(String terms_of_use) {
    this.terms_of_use = terms_of_use;
  }

  public int getTime_last_update_unix() {
    return time_last_update_unix;
  }

  public void setTime_last_update_unix(int time_last_update_unix) {
    this.time_last_update_unix = time_last_update_unix;
  }

  public String getTime_last_update_utc() {
    return time_last_update_utc;
  }

  public void setTime_last_update_utc(String time_last_update_utc) {
    this.time_last_update_utc = time_last_update_utc;
  }

  public int getTime_next_update_unix() {
    return time_next_update_unix;
  }

  public void setTime_next_update_unix(int time_next_update_unix) {
    this.time_next_update_unix = time_next_update_unix;
  }

  public String getTime_next_update_utc() {
    return time_next_update_utc;
  }

  public void setTime_next_update_utc(String time_next_update_utc) {
    this.time_next_update_utc = time_next_update_utc;
  }

  public String getBase_code() {
    return base_code;
  }

  public void setBase_code(String base_code) {
    this.base_code = base_code;
  }

  public String getTarget_code() {
    return target_code;
  }

  public void setTarget_code(String target_code) {
    this.target_code = target_code;
  }

  public BigDecimal getConversion_rate() {
    return conversion_rate;
  }

  public void setConversion_rate(BigDecimal conversion_rate) {
    this.conversion_rate = conversion_rate;
  }

  public BigDecimal getConversion_result() {
    return conversion_result;
  }

  public void setConversion_result(BigDecimal conversion_result) {
    this.conversion_result = conversion_result;
  }

  @Override
  public String toString() {
    return "ModelExternResponsePair{" +
        "result='" + result + '\'' +
        ", documentation='" + documentation + '\'' +
        ", terms_of_use='" + terms_of_use + '\'' +
        ", time_last_update_unix=" + time_last_update_unix +
        ", time_last_update_utc='" + time_last_update_utc + '\'' +
        ", time_next_update_unix=" + time_next_update_unix +
        ", time_next_update_utc='" + time_next_update_utc + '\'' +
        ", base_code='" + base_code + '\'' +
        ", target_code='" + target_code + '\'' +
        ", conversion_rate=" + conversion_rate +
        ", conversion_result=" + conversion_result +
        '}';
  }
}
