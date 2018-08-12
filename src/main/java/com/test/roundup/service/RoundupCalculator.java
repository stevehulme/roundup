package com.test.roundup.service;

import com.test.roundup.domain.transaction.Transaction;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class RoundupCalculator {

    public BigDecimal calculate(List<Transaction> transactions) {
        return transactions.stream().map(this::getRoundupAmount).filter(bigDecimal -> bigDecimal.compareTo(BigDecimal.ZERO) > 0).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getRoundupAmount(Transaction transaction) {
        BigDecimal amount = transaction.getAmount();
        return amount.setScale(0, RoundingMode.UP).subtract(amount);
    }
}
