package ro.sda.dealership.presentation;

import ro.sda.dealership.model.Stock;
import ro.sda.dealership.storage.ClientDAO;
import ro.sda.dealership.storage.StockDAO;

import java.util.Scanner;

public class StockMenu extends AbstractMenu {
    StockDAO stockDAO = new StockDAO();
    StockReader reader = new StockReader();
    StockWriter writer = new StockWriter();

    protected void displayOptions() {
        System.out.println("1 - View all car stock");
        System.out.println("2 - View car stock details");
        System.out.println("3 - Edit stock");
        System.out.println("4 - Add new car in stock");
        System.out.println("5 - Delete car from stock");
        System.out.println("0 - Exit");
    }

    protected void executeCmd(Integer option) {
        switch (option) {
            case 1:
                writer.writeAll(stockDAO.findAll());
                break;
            case 2:
                displayStockDetails();
                break;
            case 3:
                editAddress();
                break;
            case 4:
                Stock newStock = reader.read();
                stockDAO.add(newStock);
                break;
            case 5:
                System.out.println("Select stock to delete");
                Long id = new Scanner(System.in).nextLong();
                stockDAO.deleteById(id);
                break;
            case 0:
                System.out.println("Exiting to main menu");
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private void editAddress() {
        System.out.println("Select stock to edit ");
        Long id = new Scanner(System.in).nextLong();
        System.out.println("Enter new address: ");
        String location = new Scanner(System.in).nextLine();
        Stock stock = stockDAO.findById(id);
        stock.setLocation(location);
        stockDAO.update(stock);
    }

    private void displayStockDetails() {
        System.out.println("Choose stock by Id: ");
        Scanner scanner = new Scanner(System.in);
        Long id = scanner.nextLong();
        Stock searchedStock = stockDAO.findById(id);
        writer.write(searchedStock);
    }
}
