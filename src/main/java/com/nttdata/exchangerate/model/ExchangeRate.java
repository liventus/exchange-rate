package com.nttdata.exchangerate.model;
import java.math.BigDecimal;



public class ExchangeRate {
    private Currency fromCurrency;
    private Currency toCurrency;
    private BigDecimal amount;


    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
            "fromCurrency=" + fromCurrency +
            ", toCurrency=" + toCurrency +
            ", rate=" + amount +
            '}';
    }
}