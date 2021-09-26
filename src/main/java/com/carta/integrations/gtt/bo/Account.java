package com.carta.integrations.gtt.bo;

public abstract class Account {
    private String addressBankID;
    private String accountHolder;
    private String addressAccountID;

    public Account(String srcStr) {
        this.addressBankID = srcStr.substring(0,9);
        this.accountHolder = srcStr.substring(9,11);
        this.addressAccountID = srcStr.substring(11,20);
    }


    public String getBankId() {
        return this.addressBankID;
    }


    public String getAccountHolder() {
        return this.accountHolder;
    }


    public String getAccountID() {
        return this.addressAccountID;
    }

    @Override
    public String toString() {
        return "SrcAccount{" +
                "srcBankID='" + addressBankID + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                ", srcAccountID='" + addressAccountID + '\'' +
                '}';
    }

}
