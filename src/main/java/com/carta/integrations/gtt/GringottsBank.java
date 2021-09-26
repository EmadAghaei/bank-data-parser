package com.carta.integrations.gtt;

import com.carta.integrations.gtt.bo.DestAccount;
import com.carta.integrations.gtt.bo.SrcAccount;
import com.carta.integrations.gtt.bo.Transaction;
import com.carta.integrations.gtt.bo.TransactionBatch;
import com.carta.integrations.gtt.exception.IntegrationDataFormatException;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.carta.integrations.gtt.util.FileUtil.readTxtFile;

public class GringottsBank {
    private final Logger LOG = Logger.getLogger(String.valueOf(GringottsBank.class));
    private String bankIdentifier = "GTTB";
    private List<TransactionBatch> transactionBatchList = new ArrayList<>();

    public  List<TransactionBatch> prepareReport(String file) throws IntegrationDataFormatException {
        List<String> lines = readTxtFile(file);
        assert lines != null;
        List<TransactionBatch> transactionBatchList = pareData(lines);
        return transactionBatchList;
    }

    private List<TransactionBatch> pareData(List<String> lines) throws IntegrationDataFormatException {

        int i = 0;
        while (i < lines.size()) {
            TransactionBatch transactionBatch = null;
            if(lines.size()<5 || !lines.get(i).strip().startsWith(bankIdentifier)){
                throw new IntegrationDataFormatException(null);
            }
            if (lines.get(i).strip().startsWith(bankIdentifier)) {
                transactionBatch = new TransactionBatch(lines.get(i).strip().substring(0,4),
                        lines.get(i).strip().substring(4));
                i++;
            }

            try {
                while (i < lines.size() && !lines.get(i).strip().startsWith(bankIdentifier)) {
                    Transaction transaction = new Transaction();
                    transaction.setTransactionID(lines.get(i).strip());
                    SrcAccount srcAccount = new SrcAccount(lines.get(i + 1).strip());
//                    srcAccount.increment();
                    transaction.setSrcAccount(srcAccount);
                    transaction.setDstAccount(new DestAccount(lines.get(i + 2).strip()));
                    transaction.setCurrency(lines.get(i + 3).strip().substring(0, 3));
                    transaction.setAmount(new BigDecimal(lines.get(i + 3).strip().substring(3)));
                    transactionBatch.getTransactionList().add(transaction);
                    i = i + 4;
                }
                this.transactionBatchList.add(transactionBatch);
            }catch (Exception exception){
                throw new IntegrationDataFormatException(exception);
            }
        }
        return transactionBatchList;
    }



    public List<TransactionBatch> getTransactionBatchList() {
        return transactionBatchList;
    }

    public void setTransactionBatchList(List<TransactionBatch> transactionBatchList) {
        this.transactionBatchList = transactionBatchList;
    }

}
