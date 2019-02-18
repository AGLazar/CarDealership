package ro.sda.shop.presentation;

import ro.sda.shop.model.Car;
import ro.sda.shop.model.Client;
import ro.sda.shop.model.Order;
import ro.sda.shop.storage.CarDAO;
import ro.sda.shop.storage.ClientDAO;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderReader implements ConsoleReader<Order> {
    private ClientDAO clientDAO = new ClientDAO();
    private CarDAO carDAO = new CarDAO();

    public Order read() {
        if (carDAO.findAll().isEmpty() || clientDAO.findAll().isEmpty()) {
            return null;
        }
        Order order = new Order();
        new ClientWriter().writeAll(clientDAO.findAll());
        String inpMessage = "Client ID";
        String invalMessage = "Invalid client Id. Please, retry!";
        Client selectedClient = clientDAO.findById(ConsoleUtil.readLong(inpMessage, invalMessage));
        while (selectedClient == null) {
            System.out.print("Client not found. Select again: ");
            selectedClient = clientDAO.findById(ConsoleUtil.readLong(inpMessage, invalMessage));
        }
        new CarWriter().writeAll(carDAO.findAll());
        String inputMessage = "Number of cars";
        String invalidMessage = "Invalid number. Please, retry!";
        Long noOfCars = ConsoleUtil.readLong(inputMessage, invalidMessage);
        while (noOfCars <= 0) {
            System.out.print("Incorrect number. Insert again: ");
            noOfCars = ConsoleUtil.readLong(inputMessage, invalidMessage);
        }
        List<Car> listOfCars = getCars(noOfCars);
        System.out.print("Actual price: ");
        Double actualPrice = ConsoleUtil.getPrice();
        order.setClient(selectedClient);
        order.setOrderedCar(listOfCars);
        order.setFinalPrice(actualPrice);
        order.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        return order;
    }

    private List<Car> getCars(Long noOfItems) {
        List<Car> listOfCars = new ArrayList<>();
        for (int i = 0; i < noOfItems;){
            //@sdatrainers - if you read this, beer is on us!!!!!!
            System.out.print("Car #" + (i + 1) + ": ");
            String inpMessage = "Car ID";
            String invalMessage = "Invalid car Id. Please, retry!";
            Car car = carDAO.findById(ConsoleUtil.readLong(inpMessage, invalMessage));
            if(car != null) {
                listOfCars.add(car);
                i++;
            }
        }
        return listOfCars;
    }

    public void setOrderToClient(Order order) {
        Client client = order.getClient();
        List<Order> orders = client.getOrders();
        orders.add(order);
        client.setOrders(orders);
    }
}