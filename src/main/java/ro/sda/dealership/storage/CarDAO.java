package ro.sda.dealership.storage;

import ro.sda.dealership.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDAO implements GenericDAO<Car> {
    private List<Car> cars = new ArrayList<Car>();

    public List<Car> findAll() {
        return cars;
    }

    public Car findById(Long carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    public void update(Car car) {
        delete(car);
        add(car);
    }

    public Car add(Car car) {
        if (car.getCarId() == null) {
            car.setCarId(generateNewId());
        }
        if (validateMake(car)) {
            cars.add(car);
        }
        return car;
    }

    public void delete(Car car) {
        deleteById(car.getCarId());
    }

    public void deleteById(Long id) {
        Car deletedCar = null;
        for (Car car : cars) {
            if (car.getCarId().equals(id)) {
                deletedCar = car;
            }
            cars.remove(deletedCar);
        }
    }

    private Long generateNewId() {
        return findMaxId() + 1;
    }

    private Long findMaxId() {
        Long max = -1L;
        for (Car car : cars) {
            if (max < car.getCarId()) {
                max = car.getCarId();
            }
        }
        return max;
    }

    private boolean validateMake(Car car) {
        ArrayList<String> listOfMakesInTheShop = new ArrayList<String>();
        listOfMakesInTheShop.add("DACIA");
        listOfMakesInTheShop.add("BMW");
        listOfMakesInTheShop.add("MERCEDES");
        listOfMakesInTheShop.add("AUDI");
        listOfMakesInTheShop.add("MAZDA");
        listOfMakesInTheShop.add("RENAULT");
        listOfMakesInTheShop.add("FIAT");
        listOfMakesInTheShop.add("OPEL");
        if (listOfMakesInTheShop.contains(car.getMake())) {
            return true;
        }
        return false;
    }
}
