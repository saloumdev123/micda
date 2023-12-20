package dao;

import model.Bus;
import model.Reservation;
import model.Trajet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BusDao {

    public static final String STATUS_BROKEN = "BROKEN";
    public static final String STATUS_FUNCTIONAL = "FUNCTIONAL";

    Bus bus = new Bus();

    public void ajouterBus(Bus bus) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/micda_db", "root","saloum123");
            String sql = "INSERT INTO Bus (bus_id, description, status, capacity, type) VALUES (?,?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,bus.getBus_id());
                preparedStatement.setString(2, bus.getDescription());
                preparedStatement.setString(3, BusDao.STATUS_BROKEN);
                preparedStatement.setInt(4, bus.getCapacity());
                preparedStatement.setString(5, bus.getType());

                preparedStatement.executeUpdate();
                System.out.println("Bus is added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("An error occured when trying to save bus.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

        public void updateBusStatus(int busId, String newStatus) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/micda_db", "root", "saloum123");
                String sql = "UPDATE Bus SET status = ? WHERE bus_id = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, newStatus);
                    preparedStatement.setInt(2, busId);

                    int rowCount = preparedStatement.executeUpdate();

                    if (rowCount > 0) {
                        System.out.println("Bus status updated successfully!");
                    } else {
                        System.out.println("Bus not found or no update needed.");
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                System.err.println("An error occurred when trying to update bus status.");
            }
        }

    public void supprimerBus(int busId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/micda_db", "root", "saloum123");
            String sql = "DELETE FROM Bus WHERE bus_id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, busId);

                int rowCount = preparedStatement.executeUpdate();

                if (rowCount > 0) {
                    System.out.println("Bus deleted successfully!");
                } else {
                    System.out.println("Bus not found or no deletion needed.");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("An error occurred when trying to delete the bus.");
        }
    }

    public class UpdateBusDescriptionExample {

        public static void updateBusDescription(int busId, String newDescription) {
            String tableName = "Bus";
            String columnName = "description";
            String conditionColumn = "bus_id";
            String conditionValue = String.valueOf(busId);

            String url = "jdbc:mysql://localhost:3306/micda_db";
            String username = "root";
            String password = "saloum123";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String sql = "UPDATE " + tableName + " SET " + columnName + " = ? WHERE " + conditionColumn + " = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, newDescription);
                    preparedStatement.setString(2, conditionValue);

                    int rowCount = preparedStatement.executeUpdate();

                    if (rowCount > 0) {
                        System.out.println("Bus description updated successfully!");
                    } else {
                        System.out.println("No rows updated. Check your WHERE clause or bus ID.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error updating bus description in the database.");
            }
        }


    }
    public int getReservedSeatsForTrajet(Trajet trajet) {
        int reservedSeats = 0;
        for (Reservation reservation : trajet.getReservations()) {
            if (reservation.getBus() .equals(this)) {
                reservedSeats++;
            }
        }
        return reservedSeats;
    }
    public int getAvailableSeatsForTrajet(Trajet trajet) {
        int totalSeats = getCapacity();
        int reservedSeats = getReservedSeatsForTrajet(trajet);
        return totalSeats - reservedSeats;
    }




    public static void main(String[] args) {
        Bus nouveauBus = new Bus();
        BusDao busDao = new BusDao();


        busDao.ajouterBus(new Bus(11,"this bus journey from dakar to Fatick", BusDao.STATUS_FUNCTIONAL,75,"dakar dem dik"));
        //busDao.updateBusStatus(232, BusDao.STATUS_FUNCTIONAL);
        //busDao.supprimerBus(202);


       // int busIdToUpdate = 1;
       // String newDescription = "this bus is no longuer ffrom Dakar to Kaolack but Dakar to Zinguenchor";
       // updateBusDescription(232, newDescription);


    }

    private int getCapacity() {
        return bus.getCapacity();
    }
}
