package model;

import java.util.List;

public class AmountFilter implements TransactionFilter {
    @Override
    public List<Transaction> filter(List<Transaction> transactions, String amount) {
        try {
            if (amount == null || amount.isEmpty()) {
                return transactions;
            }

            return transactions.stream()
                    .filter(transaction -> transaction.getAmount() == Double.parseDouble(amount))
                    .toList();

        } catch (NumberFormatException e) {
            return List.of();
        }
    }
}
