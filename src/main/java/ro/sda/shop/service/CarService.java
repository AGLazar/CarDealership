package ro.sda.shop.service;

import ro.sda.shop.model.Car;
import ro.sda.shop.storage.CarDAO;

import java.util.List;

public class CarService {
    private CarDAO carDAO = new CarDAO();

    public List<Car> getAllCars(){
        return carDAO.findAll();
    }

    public Car getCar (Long id){
        return carDAO.findById(id);
    }

    public Car save(Car car){
        Car updatedCar = null;
        if (car.getId() == null){
            updatedCar = carDAO.add(car);
        } else {
            carDAO.update(car);
            updatedCar = car;
        }
        return updatedCar;
    }

    public void delete(Long id){
        carDAO.deleteById(id);
    }
}
