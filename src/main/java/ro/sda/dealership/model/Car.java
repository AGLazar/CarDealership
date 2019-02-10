package ro.sda.dealership.model;

public class Car {
    private String carId;
    private String brand;
    private String model;
    private Integer price;
    private String equipmentLevel;

    public Car(String carId, String brand, String model, Integer price, String equipmentLevel) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.equipmentLevel = equipmentLevel;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getEquipmentLevel() {
        return equipmentLevel;
    }

    public void setEquipmentLevel(String equipmentLevel) {
        this.equipmentLevel = equipmentLevel;
    }
}
