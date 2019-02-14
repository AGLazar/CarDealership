package ro.sda.dealership.storage;

import ro.sda.dealership.model.Client;
import ro.sda.dealership.model.Stock;

import java.util.ArrayList;
import java.util.List;

public class StockDAO implements GenericDAO<Stock>{
    private List<Stock> stockList = new ArrayList<Stock>();

    public List<Stock> findAll() {
        return stockList;
    }

    public Stock findById(Long id){
        for(Stock stock : stockList){
            if (stock.getCarId().equals(id)){
                return stock;
            }
        }
        return null;
    }

    public void update(Stock stock){
        delete(stock);
        add(stock);
    }

    public Stock add(Stock stock){
        if(stock.getCarId() == null){
            stock.setQuantity(generateNewCarId());
        }
        stockList.add(stock);
        return stock;
    }


    public void delete(Stock stock){
        deleteById(stock.getCarId());
    }

    public void deleteById(Long id){
        Stock deletedCar = null;
        for(Stock stock : stockList){
            if(stock.getCarId().equals(id)){
                deletedCar = stock;
            }
        }
        stockList.remove(deletedCar);
    }

    private Long generateNewCarId() {
        return findNewCardId() + 1;
    }

    private Long findNewCardId() {
        Long max = -1L;
        for(Stock stock : stockList){
            if (max < stock.getCarId()){
                  max = stock.getCarId();
            }
        }
        return max;
    }
}
