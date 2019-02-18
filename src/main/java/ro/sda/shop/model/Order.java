package ro.sda.shop.model;


import java.sql.Timestamp;
import java.util.List;

public class Order extends Entity{
    private Car car;
    private Client client;
    private int price;
    private String orderDetails;
    private String agent;
    private List<Car> orderedCar;
    private Timestamp timestamp;
    private Double finalPrice;
    private OrderedStatus status;

    public List<Car> getOrderedCar() {
        return orderedCar;
    }

    public void setOrderedCar(List<Car> orderedCar) {
        this.orderedCar = orderedCar;
    }

    public OrderedStatus getStatus() {
        return status;
    }

    public void setStatus(OrderedStatus status) {
        this.status = status;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }



    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
