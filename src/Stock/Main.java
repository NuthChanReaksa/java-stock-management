package Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Query query = new Query();
        Validation validation = new Validation();
        Controller controller = new Controller();
        Stock stock = new Stock();
        List<Stock> stockList = new ArrayList<>();
        String opt;

        System.out.println("*====================================================================================*");
        System.out.println("*====================================================================================*\n"+
                "*   ██████╗███████╗████████╗ █████╗ ██████╗          ██╗ █████╗ ██╗   ██╗ █████╗     * \n" +
                "*  ██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗         ██║██╔══██╗██║   ██║██╔══██╗    *\n" +
                "*  ██║     ███████╗   ██║   ███████║██║  ██║         ██║███████║██║   ██║███████║    *\n" +
                "*  ██║     ╚════██║   ██║   ██╔══██║██║  ██║    ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║    *\n" +
                "*  ╚██████╗███████║   ██║   ██║  ██║██████╔╝    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║    *\n" +
                "*   ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝      ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝    *\n" +
                "*====================================================================================*");


        List<String> welcomeMenu = new ArrayList<>(List.of("*)Display","W)rite","R)ead","U)pdate","D)elete","S)earch","Se)t row","H)elp","E)xit"));

        do {
            System.out.println(" =============================| STOCK MANAGEMENT SYSTEM |=============================");
            RenderTable.renderMenu(welcomeMenu);
//          input option
            System.out.print("Command -> ");
            opt = input.nextLine();
            switch (opt) {
                case "*": {
//               1) First , 2) Previous, 3)Last, 4)Next, 5) Goto,  In here!!
                 controller.printAllStock();
                    break;
                }
                case "W","w","productName-unitPrice-qty":
                 {
                    controller.writeProduct();
                    break;
                }
                case "R", "r": {
                    controller.readProductById();
                    break;
                }


                case "U","u" :
                {
                    int updateOpt;
                    do {
                        System.out.println("--------------| List Menu Of Update |---------------");
                        System.out.println("1- Update Stock's Product: ");
                        System.out.println("2- Update Stock's Quantity: ");
                        System.out.println("3- Back to Main option: ");
                        System.out.println("_______________________________________");
                        System.out.print("-> Choose  options above(1-2): ");
                        updateOpt = validation.inputIntValidation();
                        switch (updateOpt) {
                            case 1: {
                                controller.updateStockProduct();
                                break;
                            }
                            case 2: {
                                controller.updateStockQty();
                                break;
                            }
                        }

                    } while (updateOpt != 3);
                    break;
                }
                case "D","d","d#proId" :
                {
                    controller.deleteById();
                    break;
                }

                case "S","s":
                {
                    controller.searchStockByProduct();
                    break;
                }

                case "Se","se":
                {
                    controller.displayStockWithCustomPageSize();
                    break;
                }
                case "H","h":
                {
                    System.out.println("!=======================| Here Are The Document Of Key |==================!");
                    System.out.println("! 1.press *: Display all record of product                                !");
                    System.out.println("! 2.press w : Write new product                                           !");
                    System.out.println("!   press w-> productName-unitPrice-qty : shortcut for add new product    !");
                    System.out.println("! 3.press r : read content any content                                    !");
                    System.out.println("!   press r#proId : shortCut for read product by ID                       ! ");
                    System.out.println("! 4.press u : Update Data                                                 !");
                    System.out.println("! 5.press d : Delete Data                                                 !");
                    System.out.println("!   press d#proId : shortcut for delete product by Id                     !");
                    System.out.println("! 6.press 1 : Display First page                                          !");
                    System.out.println("! 7.press 2 : Display Previous page                                       !");
                    System.out.println("! 8.press 3 : Display Next Page                                           !");
                    System.out.println("! 9.press 4 : Display Last page                                           !");
                    System.out.println("! 10.press 5 : Go to page                                                 !");
                    System.out.println("! 11.press s : Search product by name                                     !");
                    System.out.println("! 12.press h : Help, Show all document.                                   !");
                    System.out.println("!=========================================================================!");
                    break;
                }

                default:
                            System.out.println("Invalid option. Please select a valid option.");
                            break;
                }
        }while (!opt.equals("E")) ;


    }
}