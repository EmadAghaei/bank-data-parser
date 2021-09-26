package com.carta.integrations.gtt.bo;

public class MaxAverageWithdrawalSrcAccount {
    private String srcAccount;
    private String avgAmount;

    public MaxAverageWithdrawalSrcAccount(String srcAccount, String avgAmount) {
        this.srcAccount = srcAccount;
        this.avgAmount = avgAmount;
    }

    public String getSrcAccount() {
        return srcAccount;
    }

    public void setSrcAccount(String srcAccount) {
        this.srcAccount = srcAccount;
    }

    public String getAvgAmount() {
        return avgAmount;
    }

    public void setAvgAmount(String avgAmount) {
        this.avgAmount = avgAmount;
    }
}
