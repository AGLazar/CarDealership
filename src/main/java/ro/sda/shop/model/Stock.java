package ro.sda.shop.model;

public class Stock extends Entity{
    public static final String DEFAULT_LOCATION = "Oradea";
    private Car car;
    private Long quantity;
    private String location;
    private Long id;

    public Stock (){

    }

    public Stock(Car car, Long quantity, String location) {
        this.car = car;
        this.quantity = quantity;
        this.location = location;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = car.getId();
    }

    public Car getCar(){
        return car;
    }

    public void setCar(Car car){
        this.car = car;
    }

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
