package com.nttdata.exchangerate.dto;

import java.util.Map;

public class ResponsePostConsulting {
  private String status;

  private String description;

  private Map<String,Object> detail;

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

  public Map<String, Object> getDetail() {
    return detail;
  }

  public void setDetail(Map<String, Object> detail) {
    this.detail = detail;
  }

  @Override
  public String toString() {
    return "ResponsePostConsulting{" +
        "status='" + status + '\'' +
        ", description='" + description + '\'' +
        ", detail=" + detail +
        '}';
  }
}
