package com.test.roundup.service;

import com.test.roundup.domain.transaction.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoundupService {

    private final RetrieveTransactionsService retrieveTransactionsService;

    private final CreateSavingsGoalService createSavingsGoalService;

    private final PutSavingsService putSavingsService;

    private final RoundupCalculator roundupCalculator;

    public RoundupService(RetrieveTransactionsService retrieveTransactionsService,
                          CreateSavingsGoalService createSavingsGoalService,
                          PutSavingsService putSavingsService,
                          RoundupCalculator roundupCalculator) {
        this.retrieveTransactionsService = retrieveTransactionsService;
        this.createSavingsGoalService = createSavingsGoalService;
        this.putSavingsService = putSavingsService;
        this.roundupCalculator = roundupCalculator;
    }

    public String roundup() {
        List<Transaction> transactions = retrieveTransactionsService.getTransactions();
        BigDecimal roundedupAmount = roundupCalculator.calculate(transactions);
        String savingsGoalUUID = createSavingsGoalService.createSavingsGoal();
        putSavingsService.putSavings(savingsGoalUUID, roundedupAmount);

        return savingsGoalUUID;
    }
}
