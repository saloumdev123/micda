package model;

import java.util.ArrayList;
import java.util.List;

public class Trajet {
    private int trajet_id;
    private Bus bus;
    private String departure_city;
    private String arrival_city;
    private String departure_date;
    private String departure_time;
    private ArrayList<Reservation> reservations;

    public Trajet() {
    }

    public Trajet(int trajet_id, Bus bus, String departure_city, String arrival_city, String departure_date, String departure_time, ArrayList<Reservation> reservations) {
        this.trajet_id = trajet_id;
        this.bus = bus;
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.reservations = reservations;
    }

    public List<Client> getClientsForGivenTrajet() {
        List<Client> reservedClients = new ArrayList<>();
        for (Reservation reservation : reservations) {
            reservedClients.add(reservation.getClient());
        }
        return reservedClients;
    }

    public void cancelReservation(Reservation reservation) {
        if (reservations.contains(reservation)) {
            reservations.remove(reservation);
            System.out.println("Reservation canceled successfully.");
        } else {
            System.out.println("Reservation not found.");
        }
    }
    public int getTrajet_id() {
        return trajet_id;
    }

    public void setTrajet_id(int trajet_id) {
        this.trajet_id = trajet_id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Trajet{" +
                "trajet_id=" + trajet_id +
                ", bus=" + bus +
                ", departure_city='" + departure_city + '\'' +
                ", arrival_city='" + arrival_city + '\'' +
                ", departure_date='" + departure_date + '\'' +
                ", departure_time='" + departure_time + '\'' +
                ", reservations=" + reservations +
                '}';
    }
}
