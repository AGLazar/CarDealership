package ro.sda.dealership.model;

import ro.sda.dealership.model.Car;

public class Stock extends Car{
    private Long quantity;
    private String location;



//    public Stock(Long carId, String brand, String model, Integer price, String equipmentLevel, Car car, Long quantity, String location) {
//        super(carId, brand, model, price, equipmentLevel);
//        this.quantity = quantity;
//        this.location = location;
//    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
