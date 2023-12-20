package model;

import java.util.List;

public class Reservation {

    private int id;
    private int seatNumber;
    private Client client;
    private Trajet trajet;
    private String paymentInformation;
    private String status;

    private Bus bus;



    public Reservation(int id, int seatNumber, Bus bus, Client client, Trajet trajet, String paymentInformation, String status) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.client = client;
        this.trajet = trajet;
        this.paymentInformation = paymentInformation;
        this.status = status;
        this.bus=bus;
    }


    public Object getBus() {
        return bus;
    }

    public static boolean isSeatAlreadyReserved(List<Reservation> reservations, int seatNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getSeatNumber() == seatNumber) {
                return true;
            }
        }
        return false;
    }
    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Client getClient() {
        return client;
    }

    public boolean setClient(Client client) {
        this.client = client;
        return false;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public String getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(String paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", seatNumber=" + seatNumber +
                ", client=" + client +
                ", trajet=" + trajet +
                ", paymentInformation='" + paymentInformation + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
