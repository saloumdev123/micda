package model;

public class Bus {

    private int bus_id;
    private String description;
    private String status;
    private int capacity;
    private String type;

    public Bus() {
    }

    public Bus(int bus_id, String description, String status, int capacity, String type) {
        this.bus_id = bus_id;
        this.description = description;
        this.status = status;
        this.capacity = capacity;
        this.type = type;
    }

    public int getBus_id() {
        return bus_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + bus_id +
                ", description='" + description + '\'' +
                ", state='" + status + '\'' +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                '}';
    }

    public String getEtat() {
        return null;
    }

    public int getCapacite() {

        return 0;
    }
}
