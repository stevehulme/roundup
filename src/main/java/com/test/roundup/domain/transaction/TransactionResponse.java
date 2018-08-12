package com.test.roundup.domain.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponse {

    @JsonProperty("_embedded")
    private EmbeddedTransactions embeddedTransactions;

    public EmbeddedTransactions getEmbeddedTransactions() {
        return embeddedTransactions;
    }

    public void setEmbeddedTransactions(EmbeddedTransactions embeddedTransactions) {
        this.embeddedTransactions = embeddedTransactions;
    }
}
