package Order;

import model.Car;

public class Order {
    private Car car;
    private String client;
    private int price;
    private String orderDetails;
    private String agent;

    public Order( String client, int price, String orderDetails, String agent) {
        this.client = client;
        this.price = price;
        this.orderDetails = orderDetails;
        this.agent = agent;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
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
