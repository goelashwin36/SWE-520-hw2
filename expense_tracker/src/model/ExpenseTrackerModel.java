package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpenseTrackerModel {

  // Using private final to ensure encapsulation
  private final List<Transaction> transactions;

  public ExpenseTrackerModel() {
    transactions = new ArrayList<>();
  }

  public void addTransaction(Transaction t) {
    transactions.add(t);
  }

  public void removeTransaction(Transaction t) {
    transactions.remove(t);
  }

  public List<Transaction> getTransactions() {
    // Ensuring immutability in Get Transactions
    return Collections.unmodifiableList(new ArrayList<>(transactions));
  }

}