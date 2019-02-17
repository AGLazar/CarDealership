package ro.sda.shop.presentation;

import ro.sda.shop.model.Stock;
import ro.sda.shop.storage.CarDAO;
import ro.sda.shop.storage.StockDAO;

import java.util.Scanner;

public class StockMenu extends AbstractMenu {
    StockDAO stockDAO = new StockDAO();
    CarDAO carDAO = new CarDAO();
    StockReader stockReader = new StockReader();
    StockWriter stockWriter = new StockWriter();

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
                stockWriter.writeAll(stockDAO.findAll());
                break;
            case 2:
                displayStockDetails();
                break;
            case 3:
                editQuantity();
                break;
            case 4:
                Stock newStock = stockReader.read();
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

    private void editQuantity() {
        System.out.println("Select stock quantity to edit by location: ");
        String location = new Scanner(System.in).nextLine();
        System.out.println("Select stock quantity from" + location + "to edit by id: ");
        Long id = new Scanner(System.in).nextLong();
        System.out.println("Enter new quantity: ");
        Long quantity = new Scanner(System.in).nextLong();
        Stock stock = stockDAO.findById(id);
        stock.setQuantity(quantity);
        stockDAO.update(stock);
    }

    private void displayStockDetails() {
        System.out.println("Choose stock by Id: ");
        Scanner scanner = new Scanner(System.in);
        Long id = scanner.nextLong();
        Stock searchedStock = stockDAO.findById(id);
        stockWriter.write(searchedStock);
    }
}
