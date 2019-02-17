package ro.sda.shop.presentation;

import ro.sda.shop.model.Car;
import ro.sda.shop.storage.CarDAO;

import java.util.Scanner;

public class CarMenu extends AbstractMenu {
    CarDAO carDAO = new CarDAO();
    CarReader carReader = new CarReader();
    CarWriter carWriter = new CarWriter();

    protected void displayOptions() {
        System.out.println("1 - View all cars");
        System.out.println("2 - View cars details");
        System.out.println("3 - Edit car");
        System.out.println("4 - Add new car");
        System.out.println("5 - Delete car");
        System.out.println("0 - Exit");
    }

    protected void executeCmd(Integer option) {
        switch (option) {
            case 1:
                carWriter.writeAll(carDAO.findAll());
                break;
            case 2:
                displayCarsDetails();
                break;
            case 3:
                editModel();
                break;
            case 4:
                Car newCar = carReader.read();
                carDAO.add(newCar);
                break;
            case 5:
                System.out.println("Select car to delete");
                Long idOfCarToBeDeleted = new Scanner(System.in).nextLong();
                carDAO.deleteById(idOfCarToBeDeleted);
                break;
            case 0:
                System.out.println("Exiting to main menu");
                break;
            default:
                System.out.println("Invalid option");
        }

    }

    public void displayCarsDetails() {
        System.out.println("Choose client by Id: ");
        Scanner scanner = new Scanner(System.in);
        Long id = scanner.nextLong();
        Car searcherdCar = carDAO.findById(id);
        carWriter.write(searcherdCar);
    }

    public void editModel(){
        System.out.println("Select id to edit: ");
        Long id = new Scanner(System.in).nextLong();
        System.out.println("Enter new model");
        String newModel = new Scanner(System.in).nextLine();
        Car car = carDAO.findById(id);
        car.setModel(newModel);
        carDAO.update(car);
    }
}
