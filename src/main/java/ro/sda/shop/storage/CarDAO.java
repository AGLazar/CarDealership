package ro.sda.shop.storage;

import ro.sda.shop.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDAO extends GenericDAO<Car> {
    private static List<Car> cars = new ArrayList<>();
    @Override
    protected List<Car> getItems() {
        return cars;
    }
}
