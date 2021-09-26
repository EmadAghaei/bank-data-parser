package com.carta.integrations.gtt;

import com.carta.integrations.gtt.bo.Transaction;
import com.carta.integrations.gtt.bo.TransactionBatch;
import com.carta.integrations.gtt.exception.IntegrationDataFormatException;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class ReportPrinter {

    private final static String pathAddress="./src/test/resources/";

    private  MaxAverageWithdrawalSrcAccounnt findMaxAvgWitdrawal(List<TransactionBatch> transactionBatchList){
//        transactionBatchList.stream().flatMap(batch -> batch.getTransactionList().stream()).collect(groupingBy(Transaction :: getSrcAccount))

        return null;

    }
    public static void main(String[] args) {

        try {
            List<TransactionBatch> transactionBatchList= new GringottsBank().prepareReport(pathAddress+"gtt_bank_test.txt");
          MaxAverageWithdrawalSrcAccounnt maxAverageWithdrawalSrcAccounnt =  new ReportPrinter().findMaxAvgWitdrawal(transactionBatchList);
        } catch (IntegrationDataFormatException e) {
            e.printStackTrace();
        }


    }

    private class MaxAverageWithdrawalSrcAccounnt {
        private String srcAccount;
        private String avgAmount;
        private String countOfTransactions;
    }
}
