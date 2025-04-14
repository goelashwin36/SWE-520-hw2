package model;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryFilter implements TransactionFilter {
    @Override
    public List<Transaction> filter(List<Transaction> transactions, String category) {
        try {
            if (category == null || category.isEmpty()) {
                return transactions;
            }

            return transactions.stream()
                    .filter(transaction -> transaction.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());

        } catch (NumberFormatException e) {
            return List.of();
        }
    }
}
