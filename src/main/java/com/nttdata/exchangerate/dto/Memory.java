package com.nttdata.exchangerate.dto;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Memory {
  @Id
  private String clave;

  @Column(length = 5000)
  private String valor;


}
