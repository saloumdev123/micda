package model;

public class Ticket {

    private int id;
    private int seatNumber;
    private int busId;
    private String departureCity;
    private String arrivalCity;
    private String departureTime;
    private Client client;

    public Ticket() {
    }

    public Ticket(int id, int seatNumber, int busId, String departureCity, String arrivalCity, String departureTime, Client client) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.busId = busId;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.client = client;
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

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", seatNumber=" + seatNumber +
                ", busId=" + busId +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", client=" + client +
                '}';
    }
}
