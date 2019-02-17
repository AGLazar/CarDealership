package ro.sda.shop.presentation;

import ro.sda.shop.model.Car;
import ro.sda.shop.model.Stock;
import ro.sda.shop.storage.CarDAO;

import java.util.List;
import java.util.Scanner;

public class StockReader implements ConsoleReader<Stock> {

    public Stock read() {
        Stock stock = new Stock();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Location: ");
        String address = scanner.nextLine();
        stock.setLocation(address);
        System.out.print("Quantity: ");
        Long quantity = scanner.nextLong();
        stock.setQuantity(quantity);
        return stock;
    }
}
