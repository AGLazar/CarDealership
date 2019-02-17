package ro.sda.shop.storage;

import ro.sda.shop.model.Stock;

import java.util.ArrayList;
import java.util.List;

public class StockDAO extends GenericDAO<Stock>{
    private List<Stock> stocks = new ArrayList<>();

    @Override
    protected List<Stock> getItems() {
        return stocks;
    }

    public Stock findByCarIdAndLocation(Long id, String location){
        for (Stock stock : getItems()) {
            if(stock.getCar().getId() == id && stock.getLocation().equals(location)){
                return stock;
            }
        }
        return null;
    }
}
