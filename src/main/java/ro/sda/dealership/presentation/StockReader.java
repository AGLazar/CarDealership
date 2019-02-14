package ro.sda.dealership.presentation;

import ro.sda.dealership.model.Car;
import ro.sda.dealership.model.Stock;

import java.util.ArrayList;
import java.util.Scanner;

public class StockReader implements ConsoleReader<Stock> {
    public Stock read() {
        Stock stock = new Stock();
        Scanner scanner = new Scanner(System.in);
        System.out.println("CarId: ");
        Long quantity = scanner.nextLong();
        stock.setQuantity(quantity);
        System.out.println("Location: ");
        String address = scanner.nextLine();
        stock.setLocation(address);
        return stock;
    }
}
