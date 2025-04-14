package model;

import java.util.List;
import java.util.stream.Collectors;

public class AmountFilter implements TransactionFilter {
    @Override
    public List<Transaction> filter(List<Transaction> transactions, String amount) {
        try {
            if (amount == null || amount.isEmpty()) {
                return transactions;
            }

            return transactions.stream()
                    .filter(transaction -> transaction.getAmount() == Double.parseDouble(amount))
                    .collect(Collectors.toList());

        } catch (NumberFormatException e) {
            return List.of();
        }
    }
}
