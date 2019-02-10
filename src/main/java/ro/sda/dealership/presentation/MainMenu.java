package ro.sda.dealership.presentation;

public class MainMenu extends AbstractMenu {


    protected void displayOptions() {
        System.out.println("1 - Car");
        System.out.println("2 - Clients");
        System.out.println("3 - Orders");
        System.out.println("0 - Exit");

    }

    protected void executeCmd(Integer option) {
        switch (option) {
            case 1:
                System.out.println("Car menu");
                CarMenu productMenu = new CarMenu();
                productMenu.displayMenu();
                break;
            case 2:
                System.out.println("Clients menu");
                Clients client = new Clients();
                client.displayMenu();
                break;
            case 3:
                System.out.println("Order menu");
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid Option");
        }
    }

}
