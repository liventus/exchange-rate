package com.nttdata.exchangerate.dto;



import jakarta.persistence.*;




@Entity
public class Memory {
  @Id
  private String clave;
  private String valor;

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }
}
