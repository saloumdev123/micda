package model;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String phoneNumber;
    private String paymentCode;

    public Client() {
    }

    public Client(int id, String firstName, String lastName, String idNumber, String phoneNumber, String paymentCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.paymentCode = paymentCode;
    }
    public String generatePaymentCode(String paymentMethod) {
        if ("this is for those who pays by cash".equalsIgnoreCase(paymentMethod)) {
            return "cp_" + generateRandomCode();
        } else if ("this is reserved by the mobile money".equalsIgnoreCase(paymentMethod)) {
            return "mp_" + generateRandomCode();
        } else {
            return "unknown_" + generateRandomCode();
        }
    }
    private String generateRandomCode() {

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int codeLength = 8;
        SecureRandom random = new SecureRandom();
        StringBuilder codeBuilder = new StringBuilder(codeLength);
        for (int i = 0; i < codeLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            codeBuilder.append(randomChar);
        }

        return codeBuilder.toString();
    }



    public void printTicketInformation(int seatNumber, int busId, String departureCity,
                                       String arrivalCity, String departureTime,int id, String firstName, String lastName,
                                       String phoneNumber, String paymentCode) {
        System.out.println("Ticket Information:");
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Bus ID: " + busId);
        System.out.println("Departure City: " + departureCity);
        System.out.println("Arrival City: " + arrivalCity);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Client Information:");
        System.out.println("ID: " + id);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Payment Code: " + paymentCode);
    }

    public static Connection connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://your_database_url:3306/micda_db";
            String username = "root";
            String password = "saloum123";
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", paymentCode='" + paymentCode + '\'' +
                '}';
    }

}
