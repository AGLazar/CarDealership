package ro.sda.dealership.presentation;

import ro.sda.dealership.model.Stock;

import java.util.List;

public class StockWriter implements ConsoleWriter<Stock>{
    public void write(Stock value) {
        System.out.println("CarId: " + value.getCarId());
        System.out.println("Location: " + value.getLocation());
        System.out.println("Quantity : " + value.getQuantity());
    }

    public void writeAll(List<Stock> stockList){
        if(stockList.size() == 0){
            System.out.println("No cars available.");
        } else {
            System.out.println("Cars list: ");
            for(Stock stock : stockList){
                writeSummary(stock);
            }
        }
    }

    private void writeSummary(Stock stock) {
        System.out.print("CarId: " + stock.getCarId());
        System.out.print("  Location : " + stock.getLocation());
        System.out.println(" Quantity " + stock.getQuantity());
    }

}
