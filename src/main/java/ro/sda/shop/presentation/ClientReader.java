package ro.sda.shop.presentation;

import ro.sda.shop.model.Client;

import java.util.Scanner;

public class ClientReader implements ConsoleReader<Client> {
    public Client read() {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Adress: ");
        String address = scanner.nextLine();
        client.setName(name);
        client.setAdress(address);
        return client;
    }
}
