package com.carta.integrations.gtt;

import com.carta.integrations.gtt.bo.MaxAverageWithdrawalSrcAccount;
import com.carta.integrations.gtt.bo.SrcAccount;
import com.carta.integrations.gtt.bo.Transaction;
import com.carta.integrations.gtt.bo.TransactionBatch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;

public class TransactionManipulator {

    public List<MaxAverageWithdrawalSrcAccount> findMaxAvgWitdrawal(List<TransactionBatch> transactionBatchList) {
        List<MaxAverageWithdrawalSrcAccount> result = new ArrayList<>();
        Collector<BigDecimal, BigDecimal[], BigDecimal> bigDecimalAvgCollector = getBigDecimalBigDecimalCollector();
        Map<SrcAccount, BigDecimal> map = transactionBatchList.stream().flatMap(batch -> batch.getTransactionList().stream()).
                collect(Collectors.groupingBy(Transaction::getSrcAccount,           mapping(Transaction::getAmount, bigDecimalAvgCollector)));

        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(entry -> {
            if (result.size() == 0) {
                result.add(new MaxAverageWithdrawalSrcAccount(entry.getKey().toString(), entry.getValue().toString()));
            } else if (entry.getValue().toString().equals(result.get(0).getAvgAmount())) {
                result.add(new MaxAverageWithdrawalSrcAccount(entry.getKey().toString(), entry.getValue().toString()));
            }
        });

        return result;

    }

    private Collector<BigDecimal, BigDecimal[], BigDecimal> getBigDecimalBigDecimalCollector() {
        Collector<BigDecimal, BigDecimal[], BigDecimal> bigDecimalAvgCollector = Collector.of(
                () -> new BigDecimal[]{BigDecimal.ZERO, BigDecimal.ZERO},
                (pair, val) -> {
                    pair[0] = pair[0].add(val);
                    pair[1] = pair[1].add(BigDecimal.ONE);
                },
                (pair1, pair2) -> new BigDecimal[]{pair1[0].add(pair2[0]), pair1[1].add(pair2[1])},
                (pair) -> pair[0].divide(pair[1], 2, RoundingMode.HALF_UP)
        );
        return bigDecimalAvgCollector;
    }
}
