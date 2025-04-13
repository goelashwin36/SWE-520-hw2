package controller;

import view.ExpenseTrackerView;

import java.util.List;

import model.AmountFilter;
import model.CategoryFilter;
import model.ExpenseTrackerModel;
import model.Transaction;
import model.TransactionFilter;

public class ExpenseTrackerController {

  private ExpenseTrackerModel model;
  private ExpenseTrackerView view;

  public ExpenseTrackerController(ExpenseTrackerModel model, ExpenseTrackerView view) {
    this.model = model;
    this.view = view;

    // Set up view event handlers
  }

  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = model.getTransactions();

    // Pass to view
    view.refreshTable(transactions);

  }

  public boolean addTransaction(double amount, String category) {
    if (!InputValidation.isValidAmount(amount)) {
      return false;
    }
    if (!InputValidation.isValidCategory(category)) {
      return false;
    }

    Transaction t = new Transaction(amount, category);
    model.addTransaction(t);
    view.getTableModel().addRow(new Object[] { t.getAmount(), t.getCategory(), t.getTimestamp() });
    refresh();
    return true;
  }

  public List<Transaction> applyFilter(String filterType, String value) {
    TransactionFilter filter;

    if (filterType.equalsIgnoreCase("amount")) {
      filter = new AmountFilter();
    } else if (filterType.equalsIgnoreCase("category")) {
      filter = new CategoryFilter();
    } else {
      // In the case of maybe invalid filter type
      return List.of();
    }

    // Applying Input Validation on Filters. If filter value empty then show all transactions.

    if (!(value == null || value.isEmpty())
        && ((filterType.equalsIgnoreCase("amount") && !InputValidation.isValidAmount(Double.parseDouble(value))) ||
            (filterType.equalsIgnoreCase("category") && !InputValidation.isValidCategory(value)))) {
      return List.of();
    }

    return filter.filter(model.getTransactions(), value);
  }

  // Other controller methods
}