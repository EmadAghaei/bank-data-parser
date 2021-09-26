package com.carta.integrations.gtt;

import com.carta.integrations.gtt.bo.MaxAverageWithdrawalSrcAccount;
import com.carta.integrations.gtt.bo.TransactionBatch;
import com.carta.integrations.gtt.exception.IntegrationDataFormatException;

import java.util.List;

public class GttReportPrinter {

    private final static String pathAddress = "./src/test/resources/";
    private final static List<String> fileNameList = List.of("gtt_bank_data1.txt", "gringotts_5b36864e-8089-40f7-8d3d-25c14715656d.txt");

    public static void main(String[] args) {

        fileNameList.forEach(fileName -> {
            List<TransactionBatch> transactionBatchList = null;
            try {
                transactionBatchList = new GringottsBank().prepareReport(pathAddress + fileName);
                List<MaxAverageWithdrawalSrcAccount> maxAverageList = new TransactionManipulator().findMaxAvgWitdrawal(transactionBatchList);
                for (MaxAverageWithdrawalSrcAccount maxAvgSource : maxAverageList) {
                    StringBuilder reportStr = new StringBuilder("Account: ");
                    reportStr.append(maxAvgSource.getSrcAccount()).append("has maximum transfer amount of: ").append(maxAvgSource.getAvgAmount());
                    System.out.println(reportStr);
                }
            } catch (IntegrationDataFormatException e) {
                e.printStackTrace();
            }
        });

    }
}
