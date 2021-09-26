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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (addressBankID != null ? !addressBankID.equals(account.addressBankID) : account.addressBankID != null)
            return false;
        if (accountHolder != null ? !accountHolder.equals(account.accountHolder) : account.accountHolder != null)
            return false;
        return addressAccountID != null ? addressAccountID.equals(account.addressAccountID) : account.addressAccountID == null;
    }

    @Override
    public int hashCode() {
        int result = addressBankID != null ? addressBankID.hashCode() : 0;
        result = 31 * result + (accountHolder != null ? accountHolder.hashCode() : 0);
        result = 31 * result + (addressAccountID != null ? addressAccountID.hashCode() : 0);
        return result;
    }
}
