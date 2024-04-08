package com.nttdata.exchangerate.dto;

public class ValorMemory {

  private String timeNextUpdateUtc;
  private String baseCode;
  private String codeConvert;
  private String conversionRates;

  private String timeNextUpdateUnix;

  public String getTimeNextUpdateUnix() {
    return timeNextUpdateUnix;
  }

  public void setTimeNextUpdateUnix(String timeNextUpdateUnix) {
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

  public String getCodeConvert() {
    return codeConvert;
  }

  public void setCodeConvert(String codeConvert) {
    this.codeConvert = codeConvert;
  }

  public String getConversionRates() {
    return conversionRates;
  }

  public void setConversionRates(String conversionRates) {
    this.conversionRates = conversionRates;
  }

  @Override
  public String toString() {
    return "{" +
        "timeNextUpdateUtc='" + timeNextUpdateUtc + '\'' +
        ", baseCode='" + baseCode + '\'' +
        ", codeConvert='" + codeConvert + '\'' +
        ", conversionRates='" + conversionRates + '\'' +
        ", timeNextUpdateUnix='" + timeNextUpdateUnix + '\'' +
        '}';
  }
}
