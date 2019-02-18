package ro.sda.shop.presentation;

import ro.sda.shop.model.Car;

import java.util.List;

public class CarWriter implements ConsoleWriter<Car> {
    public void write(Car value) {
        System.out.println("Id: " + value.getId());
        System.out.println("Make: " + value.getMake());
        System.out.println("Model: " + value.getModel());
        System.out.println("Color: " + value.getColor());
        System.out.println("Price: " + value.getPrice());
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
        System.out.print("**Id: " + car.getId());
        System.out.print(" **Make: " + car.getMake());
        System.out.print(" **Model: " + car.getModel());
        System.out.println(" **Color: " + car.getColor());
        System.out.println(" **Price: " + car.getPrice());
        System.out.println();
    }
}
