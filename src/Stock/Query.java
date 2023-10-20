package Stock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Query {
    Validation validation = new Validation();
    Scanner input = new Scanner(System.in);
    static int totalRow = 3;
    static int page = 1;

//      Display all product
private List<Stock> stockList = new ArrayList<>(); // Store stock data in a list
    // Display all product
    public List<Stock> getAllStocks(int page) {
        // Simply return the stock list
        return stockList;
    }

//    Write product to list
    public void writeStock(){
        System.out.println("Write name of product to stock : ");
        String name = input.nextLine();
        System.out.println("Write price of product to stock : ");
        int unitPrice = validation.inputIntValidation();
        System.out.println("Write quantity of product to stock : ");
        int qty = validation.inputIntValidation();
        System.out.println("Write date here : ");
        String importDate = input.nextLine();
        int nextId = stockList.size() + 1;
        stockList.add(new Stock(nextId, name, qty, unitPrice, importDate));

        System.out.println("Insert stock successfully!");
      }
    public void readProductById() {
        System.out.print("Enter the ID of the product you want to read: ");
        int id = validation.inputIntValidation();

        Stock stockToRead = findStockById(id);

        if (stockToRead != null) {
            System.out.println("Product ID: " + stockToRead.getId());
            System.out.println("Product Name: " + stockToRead.getName());
            System.out.println("Unit Price: " + stockToRead.getUnitPrice());
            System.out.println("Quantity: " + stockToRead.getQty());
            System.out.println("Imported Date: " + stockToRead.getImportDate());
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }




    public void updateStockProduct() {
        System.out.print("-> Input new stock's product: ");
        String product = input.nextLine();
        System.out.print("-> Input stock's ID to update: ");
        int id = validation.inputIntValidation();

        Stock stockToUpdate = findStockById(id);

        if (stockToUpdate != null) {
            stockToUpdate.setName(product);
            System.out.println("Update stock's product successfully!");
        } else {
            System.out.println("Stock with ID " + id + " not found.");
        }
    }

    public void updateStockQty() {
        System.out.print("-> Input new stock's quantity: ");
        int qty = validation.inputIntValidation();
        System.out.print("-> Input stock's ID to update: ");
        int id = validation.inputIntValidation();

        Stock stockToUpdate = findStockById(id);

        if (stockToUpdate != null) {
            stockToUpdate.setQty(qty);
            System.out.println("Update stock's quantity successfully!");
        } else {
            System.out.println("Stock with ID " + id + " not found.");
        }
    }

    // Helper method to find a stock by its ID
    public void deleteById() {
        System.out.print("Input Stock's ID: ");
        int id = validation.inputIntValidation();

        Stock stockToDelete = findStockById(id);

        if (stockToDelete != null) {
            String productName = stockToDelete.getName();
            stockList.remove(stockToDelete);
            System.out.println("Deleting Stock: " + productName);
            System.out.println("Delete Stock ID: " + id + " Successfully!");
        } else {
            System.out.println("There is no Stock ID: " + id);
        }
    }

    public List<Stock> searchStockByProduct() {
        List<Stock> results = new ArrayList<>();
        System.out.print("Input stock's Product: ");
        String search = input.nextLine();

        for (Stock stock : stockList) {
            if (stock.getName().equalsIgnoreCase(search)) {
                results.add(stock);
            }else {
                System.out.println("--> No Result!!! ");
            }
        }

        return results;
    }

    // Helper method to find a stock by its ID
    private Stock findStockById(int id) {
        for (Stock stock : stockList) {
            if (stock.getId() == id) {
                return stock;
            }
        }
        return null; // Stock with the given ID not found
    }



}








//    Read Product
//    Update product in list
//    Delete product in list
//    Search product
//    Go to
//    Set row
//    Help




