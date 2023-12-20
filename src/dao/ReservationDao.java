package dao;

import model.Bus;
import model.Client;
import model.Reservation;
import model.Trajet;

public class ReservationDao {

    public static void main(String[] args) {
        Reservation reservation = new Reservation();
        Bus bus = new Bus();
        Client client = new Client();

        System.out.println();  reservation.setBus(bus);
        System.out.println( reservation.setClient(new Client(client.getId(),
                client.getFirstName(), client.getLastName(),
                client.getPhoneNumber(), client.getPaymentCode(),
                client.generatePaymentCode(""))));
        System.out.println(reservation.getId());
        System.out.println(reservation.getSeatNumber());
        System.out.println( reservation.getStatus());
        System.out.println(reservation.getTrajet());
    }
}
