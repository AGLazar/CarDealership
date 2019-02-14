package ro.sda.dealership.presentation;

public class MainMenu extends AbstractMenu {


    protected void displayOptions() {
        System.out.println("1 - Cars");
        System.out.println("2 - Clients");
        System.out.println("3 - Orders");
        System.out.println("4 - Stock");
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
                ClientMenu clientMenu = new ClientMenu();
                clientMenu.displayMenu();
                break;
            case 3:
                System.out.println("Order menu");
                OrderMenu orderMenu = new OrderMenu();
                orderMenu.displayMenu();
                break;
            case 4:
                System.out.println("Stock menu");
                StockMenu stockMenu = new StockMenu();
                stockMenu.displayMenu();
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid Option");
        }
    }

}
