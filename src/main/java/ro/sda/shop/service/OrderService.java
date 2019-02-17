package ro.sda.shop.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import ro.sda.shop.model.*;
import ro.sda.shop.storage.OrderDAO;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();
    private StockService stockService = new StockService();
    public List<Order> getAllOrders(){
        return orderDAO.findAll();
    }

    public List<Order> getOrdersForClient(Long clientId){
        return orderDAO.findAllByClientId(clientId);
    }

    public List<Order> getOrdersBetweenDates(Timestamp start, Timestamp stop){
        return orderDAO.fiindAllBetweenDates(start, stop);
    }

    private Double computePrice(List<Car> cars){
        Double total = 0.D;
        for (Car car : cars){
            total+= car.getPrice();
        }
        return total;
    }

    public void placeOrder(Client client, List<Car> cars){
        Order order = new Order();
        if(areAllProductsInStock(cars)){
            order.setClient(client);
            order.setOrderedCar(cars);
            order.setFinalPrice(computePrice(cars));
            order.setTimestamp(new Timestamp(new Date().getTime() * 1000000));
            order.setStatus(OrderedStatus.PLACED);
            save(order);
        } else {
            throw new CarNotInStockException("Car isn't available");
        }
    }

    public void acceptOrder(Order order){
        order.setStatus(OrderedStatus.ACCEPTED);
        save(order);
    }

    public void deliverOrder(Order order){
        order.setStatus(OrderedStatus.DELIVERED);
        save(order);
    }

    public void payOrder(Order order){
        order.setStatus(OrderedStatus.PAYED);
        save(order);
    }

    public void cancelOrder(Order order){
        switch (order.getStatus()){
            case PLACED:
            case ACCEPTED:
            case DELIVERED:
                returnToStock(order);
                break;
            case PAYED:
                returnToStock(order);
                returnMoney(order);
                break;
        }
        order.setStatus(OrderedStatus.CANCELED);
        save(order);
    }

    private void returnMoney(Order order){
        //Restituim banii clientului
    }

    private void returnToStock(Order order){
        for(Car car : order.getOrderedCar()){
            stockService.retrunToStock(car);
        }
    }

    private boolean areAllProductsInStock(List<Car> cars){
        for (Car car : cars){
            if (!stockService.isInStock(car)){
                return false;
            }
        }
        return true;
    }

    public Order save(Order order){
        Order updatedOrder = null;
        if(order.getId() == null){
            updatedOrder = orderDAO.add(order);
        } else {
            orderDAO.update(order);
            updatedOrder = order;
        }
        return updatedOrder;
    }
}
