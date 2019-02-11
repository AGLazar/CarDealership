package ro.sda.dealership.model;

import ro.sda.dealership.model.Car;

public class Stock {
    private int aviableStock;
    private String warehouse;
    private Car car;

    public int getAviableStock() {
        return aviableStock;
    }

    public void setAviableStock(int aviableStock) {
        this.aviableStock = aviableStock;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Stock(int aviableStock, String warehouse) {
        this.aviableStock = aviableStock;
        this.warehouse = warehouse;
    }
}
