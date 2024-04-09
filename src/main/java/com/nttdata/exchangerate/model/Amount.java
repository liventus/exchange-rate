package com.nttdata.exchangerate.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// Clase que representa un monto

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Amount {
    private BigDecimal value;
    private Currency currency;
}
