package dao;

import model.Client;

import java.sql.Connection;

import static model.Client.connectToDatabase;

public class ClientDao {

    public static void main(String[] args) {
        Connection connection = connectToDatabase();
        if (connection != null) {
            System.out.println("Connected to the database!");

        } else {
            System.out.println("Failed to connect to the database.");
        }

        Client client = new Client();
        System.out.println("****************************");
        System.out.println("");
        String paymentMethod = "cash";
        String paymentCode = client.generatePaymentCode(paymentMethod);
        System.out.println("Generated Payment Code: " + paymentCode);
        client.generatePaymentCode("cash"); // or "mobile money"
        client.printTicketInformation(75, 10, "Dakar", "Fatick", "12:00 PM",
                2,"papa saloum","sene","772897342",paymentCode);
        System.out.println("");
        System.out.println("****************************");

    }

}
