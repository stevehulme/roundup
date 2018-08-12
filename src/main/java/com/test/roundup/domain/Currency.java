package com.test.roundup.domain;

import java.math.BigDecimal;

public class Currency {

    private java.util.Currency currency;

    private BigDecimal minorUnits;

    public java.util.Currency getCurrency() {
        return currency;
    }

    public void setCurrency(java.util.Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getMinorUnits() {
        return minorUnits;
    }

    public void setMinorUnits(BigDecimal minorUnits) {
        this.minorUnits = minorUnits;
    }
}
