// package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import org.junit.After;

import controller.ExpenseTrackerController;
import model.ExpenseTrackerModel;
import model.Transaction;
import view.ExpenseTrackerView;


public class TestExample {
  
  private ExpenseTrackerModel model;
  private ExpenseTrackerView view;
  private ExpenseTrackerController controller;

  // Setup
  @Before
  public void setup() {
    model = new ExpenseTrackerModel();
    view = new ExpenseTrackerView();
    controller = new ExpenseTrackerController(model, view);
  }

  // Cleanup
  @After
  public void teardown() {
      model = null;
      view = null;
      controller = null;
  }

    public double getTotalCost() {
        double totalCost = 0.0;
        List<Transaction> allTransactions = model.getTransactions(); // Using the model's getTransactions method
        for (Transaction transaction : allTransactions) {
            totalCost += transaction.getAmount();
        }
        return totalCost;
    }
    


    @Test
    public void testAddTransaction() {
        // Pre-condition: List of transactions is empty
        assertEquals(0, model.getTransactions().size());
    
        // Perform the action: Add a transaction
        assertTrue(controller.addTransaction(50.00, "food"));
    
        // Post-condition: List of transactions contains one transaction
        assertEquals(1, model.getTransactions().size());
    
        // Check the contents of the list
        // Post-condition: Total cost is updated
        assertEquals(50.00, getTotalCost(), 0.01);
    }


    @Test
    public void testRemoveTransaction() {
        // Pre-condition: List of transactions is empty
        assertEquals(0, model.getTransactions().size());
    
        // Perform the action: Add and remove a transaction
        Transaction addedTransaction = new Transaction(50.00, "Groceries");
        model.addTransaction(addedTransaction);
    
        // Pre-condition: List of transactions contains one transaction
        assertEquals(1, model.getTransactions().size());
    
        // Perform the action: Remove the transaction
        model.removeTransaction(addedTransaction);
    
        // Post-condition: List of transactions is empty
        List<Transaction> transactions = model.getTransactions();
        assertEquals(0, transactions.size());
    
        // Check the total cost after removing the transaction
        double totalCost = getTotalCost();
        assertEquals(0.00, totalCost, 0.01);
    }

    @Test
    public void testInvalidInputHandling() {
        // Pre-condition: List of transactions is empty
        assertEquals(0, model.getTransactions().size());
        
        // Perform the action: Add a transaction with an invalid amount
        controller.addTransaction(-50.00, "food");

        // Post-condition: Error message is displayed
        assertTrue(view.isVisible());
        
        // Post-condition: List of transactions is empty
        List<Transaction> transactions = model.getTransactions();
        assertEquals(0, transactions.size());

        // Post-condition: Total cost is unchanged
        double totalCost = getTotalCost();
        assertEquals(0.00, totalCost, 0.01);
    }

    @Test
    public void testFilterByAmount(){
        // Pre-condition: List of transactions is empty
        assertEquals(0, model.getTransactions().size());
        
        // Perform the action: Add transactions with different amounts
        controller.addTransaction(50.00, "food");
        controller.addTransaction(90.00, "other");
        controller.addTransaction(90.00, "food");

        // Perform the action: Apply an amount filter
        List<Transaction> filtered = controller.applyFilter("amount", "90");

        // Post-condition: Only transactions matching amount are returned
        assertEquals(2, filtered.size());

    }

    @Test
    public void testFilterByCategory(){
        // Pre-condition: List of transactions is empty
        assertEquals(0, model.getTransactions().size());
        
        // Perform the action: Add transactions with different categories
        controller.addTransaction(50.00, "food");
        controller.addTransaction(90.00, "other");
        controller.addTransaction(90.00, "food");

        // Perform the action: Apply a category filter
        List<Transaction> filtered = controller.applyFilter("category", "other");

        // Post-condition: Only transactions matching category are returned
        assertEquals(1, filtered.size());
    }
    
}