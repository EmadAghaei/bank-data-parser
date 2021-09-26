package com.carta.integrations.gtt.bo;

import java.math.BigDecimal;
import java.util.Currency;

public class Transaction {
    private String transactionID;
    private SrcAccount srcAccount;
    private DestAccount dstAccount;
    private String currency;
    private BigDecimal amount;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public SrcAccount getSrcAccount() {
        return srcAccount;
    }

    public void setSrcAccount(SrcAccount srcAccount) {
        this.srcAccount = srcAccount;
    }

    public DestAccount getDstAccount() {
        return dstAccount;
    }

    public void setDstAccount(DestAccount dstAccount) {
        this.dstAccount = dstAccount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
