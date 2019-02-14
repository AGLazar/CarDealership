package ro.sda.dealership.presentation;

import ro.sda.dealership.model.Car;

import java.util.List;

public class CarWriter implements ConsoleWriter<Car> {
    public void write(Car value) {
        System.out.println("Id: " + value.getCarId());
        System.out.println("Make: " + value.getMake());
        System.out.println("Model: " + value.getModel());
        System.out.println("Color: " + value.getColor());
    }

    public void writeAll(List<Car> cars){

        if(cars.size() == 0){
            System.out.println("No cars in stock");
        } else {
            System.out.println("Car list");
            for (Car car : cars){
                writeSummary(car);
            }
        }
    }

    private void writeSummary(Car car) {
        System.out.print("**Id: " + car.getCarId());
        System.out.print(" **Make: " + car.getMake());
        System.out.print(" **Model: " + car.getModel());
        System.out.println();
    }
}
