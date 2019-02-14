package ro.sda.dealership.model;

public class Car {
    private Long carId;
    private String make;
    private String model;
    private Integer price;
    private String color;
    private String transmission;
    private String bodyType;
    private String driveType;
    private Integer driveCapacity;

    public Car(Long carId, String make, String model, Integer price, String color, String transmission, String bodyType, String driveType, Integer driveCapacity) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.price = price;
        this.color = color;
        this.transmission = transmission;
        this.bodyType = bodyType;
        this.driveType = driveType;
        this.driveCapacity = driveCapacity;
    }

    public Car(){

    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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
