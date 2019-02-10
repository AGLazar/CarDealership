package ro.sda.dealership.presentation;

public class CarMenu extends AbstractMenu {

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
                System.out.println("List of cars");
                break;
            case 2:
                System.out.println("Product cars are:");
                break;
            case 3:
                System.out.println("Edit car---");
                break;
            case 4:
                System.out.println("Add a new car here:");
                break;
            case 5:
                System.out.println("Select car to delete");
                break;
            case 0:
                System.out.println("Exiting to main menu");
                break;
            default:
                System.out.println("Invalid option");

        }
    }
}
