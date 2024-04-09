package com.nttdata.exchangerate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ResponsePostConsulting {
  private String status;

  private String description;

  private ModelExternResponsePair detail;


}
