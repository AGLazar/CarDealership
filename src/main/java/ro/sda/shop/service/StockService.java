package ro.sda.shop.service;

import ro.sda.shop.model.Car;
import ro.sda.shop.model.Stock;
import ro.sda.shop.storage.StockDAO;

public class StockService {
    StockDAO stockDAO = new StockDAO();

    public void addCarToStock(Car car, int quantity, String location){
        Stock stock = stockDAO.findByCarIdAndLocation(car.getId(),location);
        if(stock == null){
            stock = new Stock(car, 2L, location);
        }
        save(stock);
    }

    public Stock save(Stock stock){
        Stock upDatedStock = null;
        if (stock.getId() == null){
            upDatedStock = stockDAO.add(stock);
        } else {
            stockDAO.update(stock);
            upDatedStock = stock;
        }
        return upDatedStock;
    }

    public void addCarToStock(Car car, int quantity){
        addCarToStock(car, quantity, Stock.DEFAULT_LOCATION);
    }

    public boolean isInStock(Car car){
        return isInStock(car, Stock.DEFAULT_LOCATION);
    }

    public boolean isInStock(Car car, String location){
        Stock stock = stockDAO.findByCarIdAndLocation(car.getId(), location);
        if(stock != null && stock.getQuantity() > 0){
            return true;
        } else {
            return false;
        }
    }

    public void deliverFromStock(Car car, String location, int quantity){
        Stock stock = stockDAO.findByCarIdAndLocation(car.getId(), location);
        if(stock != null && stock.getQuantity() >= quantity){
            long newQuantity = stock.getQuantity()- quantity;
            stock.setQuantity(newQuantity);
            save(stock);
        } else {
            throw new NotFoundException("Product not in stock! ");
        }
    }
    public void returnToStock(Car car, String location, int quantity){
        Stock stock = stockDAO.findByCarIdAndLocation(car.getId(), location);
        if(stock != null){
            long newQuantity = stock.getQuantity()+ quantity;
            stock.setQuantity(newQuantity);
            save(stock);
        } else {
            throw new NotFoundException("Not retirned to stock! ");
        }
    }

    public void retrunToStock(Car car){
        returnToStock(car, Stock.DEFAULT_LOCATION, 1);
    }

    public void deliverFromStock(Car car){
        deliverFromStock(car, Stock.DEFAULT_LOCATION,1);
    }
}
