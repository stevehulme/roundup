package com.test.roundup.domain.addmoney;

import java.math.BigDecimal;
import java.util.Currency;

public class Amount {

    private Currency currency;

    private BigDecimal minorUnits;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getMinorUnits() {
        return minorUnits;
    }

    public void setMinorUnits(BigDecimal minorUnits) {
        this.minorUnits = minorUnits;
    }
}
