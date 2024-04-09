package com.nttdata.exchangerate.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValorMemory {

  private String timeNextUpdateUtc;
  private String baseCode;
  private String codeConvert;
  private String conversionRates;
  private String timeNextUpdateUnix;


}
