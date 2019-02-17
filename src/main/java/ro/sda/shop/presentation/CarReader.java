package ro.sda.shop.presentation;

import ro.sda.shop.model.Car;
import java.util.Scanner;

public class CarReader implements ConsoleReader<Car> {

    public Car read() {
        Car car = new Car();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        car.setMake(make);
        car.setModel(model);
        return car;
    }
}
