package com.carta.integrations.gtt.bo;

import java.util.ArrayList;
import java.util.List;

public class TransactionBatch {
    private List<Transaction> transactionList;
    private String bankIdentifier;
    private String batchID;

//    public TransactionBatch(String transactionBatchID, String transactionID,
//                            String srcAccount, String destAccount, String amount) {
//        this.bankIdentifier = transactionBatchID.substring(3);
//        this.batchID = transactionBatchID.substring(3,transactionBatchID.length()-1);
//    }

    public TransactionBatch(String bankIdentifier, String batchID) {
        this.bankIdentifier = bankIdentifier;
        this.batchID = batchID;
        transactionList = new ArrayList<>();
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public String getBankIdentifier() {
        return bankIdentifier;
    }

    public void setBankIdentifier(String bankIdentifier) {
        this.bankIdentifier = bankIdentifier;
    }

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }
}
