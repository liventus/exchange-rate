package com.nttdata.exchangerate.dto;

import java.util.Map;

public class ResponsePostConsulting {
  private String status;

  private String description;

  private ModelExternResponsePair detail;





  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ModelExternResponsePair getDetail() {
    return detail;
  }

  public void setDetail(ModelExternResponsePair detail) {
    this.detail = detail;
  }
}
