package ro.sda.shop.model;

import java.util.List;

public class Car extends Entity{
    private Long Id;
    private String make;
    private String model;
    private Integer price;
    private String color;
    private String transmission;
    private String bodyType;
    private String driveType;
    private Integer driveCapacity;
    public List<Car> carList;
    public Car(){

    }
    @Override
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public Integer getDriveCapacity() {
        return driveCapacity;
    }

    public void setDriveCapacity(Integer driveCapacity) {
        this.driveCapacity = driveCapacity;
    }


}
