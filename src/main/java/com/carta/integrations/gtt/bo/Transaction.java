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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (transactionID != null ? !transactionID.equals(that.transactionID) : that.transactionID != null)
            return false;
        if (srcAccount != null ? !srcAccount.equals(that.srcAccount) : that.srcAccount != null) return false;
        if (dstAccount != null ? !dstAccount.equals(that.dstAccount) : that.dstAccount != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        return amount != null ? amount.equals(that.amount) : that.amount == null;
    }

    @Override
    public int hashCode() {
        int result = transactionID != null ? transactionID.hashCode() : 0;
        result = 31 * result + (srcAccount != null ? srcAccount.hashCode() : 0);
        result = 31 * result + (dstAccount != null ? dstAccount.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
