package com.nttdata.exchangerate.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeRate {
    private Currency fromCurrency;
    private Currency toCurrency;
    private BigDecimal amount;
}