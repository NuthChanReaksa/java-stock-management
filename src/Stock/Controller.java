package Stock;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    Validation validation = new Validation();

    Query query = new Query();
    int pageSize = 2 ;
    // Set the number of rows per page
    public void setPageSize() {
        System.out.print("Enter the number of rows per page: ");
        int newSize = validation.inputIntValidation();
        if (newSize > 0) {
            pageSize = newSize;
            System.out.println("Page size set to " + newSize + " rows.");
        } else {
            System.out.println("Invalid page size. Please enter a positive number.");
        }
    }
    public void printAllStock(){
        System.out.println("===============| Display all product |==============");

        int page = 1;
        while (true){
            CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
            CellStyle cellStyle1 = new CellStyle(CellStyle.HorizontalAlign.left);
            Table table = new Table(5, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.ALL);
            // Title Table / header table
            List<Stock> stockList = query.getAllStocks(page);
            System.out.println("====================| Current Page: |" +page);
            table.addCell("ID", cellStyle);
            table.addCell("NAME", cellStyle);
            table.addCell("UNIT-PRICE", cellStyle);
            table.addCell("QUANTITY", cellStyle);
            table.addCell("IMPORTED DATE", cellStyle);

            int startRow = (page - 1) * pageSize;
            int endRow = Math.min(startRow + pageSize, stockList.size());

            for (int i = startRow; i < endRow; i++){
                table.addCell(stockList.get(i).getId()+"", cellStyle1);
                table.addCell(stockList.get(i).getName()+"", cellStyle1);
                table.addCell(stockList.get(i).getQty()+"", cellStyle1);
                table.addCell(stockList.get(i).getUnitPrice()+"", cellStyle1);
                table.addCell(stockList.get(i).getImportDate()+"", cellStyle1);
            }
            System.out.println(table.render());
            System.out.println("<-First(1)------------ Previous(2)---------(3)Next----------(4)Last---");
            System.out.println("<------------------------------GoTo(5)-------------------------------->");
            System.out.print("-> Press any key(Integer) to exit : ");
            int opt = validation.inputIntValidation();
            switch (opt){
                case 1:
                    page = 1;
                    break;
                case 2:
                    if (page > 1) {
                        page--;
                    }
                    break;

                case 3:
                    int nextPage = page + 1;
                    int maxPage = (stockList.size() + pageSize - 1) / pageSize; // Calculate the maximum page
                    if (nextPage <= maxPage) {
                        page = nextPage;
                    } else {
                        System.out.println("No more pages available.");
                    }
                    break;
                case 4:
                    // Set the page to the last page
                    page = (stockList.size() + pageSize - 1) / pageSize;
                    break;
                case 5:
                    System.out.print("Enter the page number: ");
                    int pageNumber = validation.inputIntValidation();
                    if (pageNumber >= 1) {
                        page = pageNumber;
                    } else {
                        System.out.println("Invalid page number. Please enter a positive number.");
                    }
                    break;
                default:
                    System.out.println("Back to the main menu...");
            }
            if (opt > 5 || opt < 1){
                break;
            }
        }

    }
    public void displayStockWithCustomPageSize() {

        setPageSize(); // Call the method to set the page size
        printAllStock(); // Display stock data using the set page size
    }

    public void  writeProduct(){
        System.out.println("==================| Write product to stock |=======================");
        query.writeStock();
    }
    public void readProductById(){
        System.out.println("==================| Read product in stock |=======================");
        query.readProductById();
    }
    public void  readProduct(){
        System.out.println("==================| Read product to stock |=======================");
        query.writeStock();
    }


    public void updateStockProduct(){
        System.out.println("==================| Update stock's name|=======================");
        query.updateStockProduct();
    }
    public void updateStockQty(){
        System.out.println("==================| Update stock's quantity|=======================");
        query.updateStockQty();
    }
    public void deleteById(){
        System.out.println("==================| Insert stock out product|=======================");
        query.deleteById();
    }
    public void searchStockByProduct(){
        System.out.println("===============| Search stock By product |===============");
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table = new Table(5, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.ALL);
        table.addCell("ID", cellStyle);
        table.addCell("TITLE", cellStyle);
        table.addCell("QUANTITY", cellStyle);
        table.addCell("CATEGORY", cellStyle);
        table.addCell("PRICE", cellStyle);

        for(Stock stock:query.searchStockByProduct()){
            table.addCell(stock.getId()+"");
            table.addCell(stock.getName());
            table.addCell(stock.getUnitPrice()+"");
            table.addCell(stock.getQty()+"");
            table.addCell(stock.getImportDate()+"");
        }
        System.out.println(table.render());
    }

}
