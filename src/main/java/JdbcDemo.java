import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDemo {

    public static void main(String[] args) {

        System.out.println("JDBC Demo!");
        sellectAllDemo();

    }

    public static void sellectAllDemo(){


        System.out.println("Select Demo mit Jdbc");

        String sqlSelectAllPersons = "Select * from `student`";
        String connectionUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd))

        {
            System.out.println("Verbindung zur DB hergestellt!");
        } catch (SQLException e){

            System.out.println("Fehler beim Aufbau der Verbindung zur Datenbank: " + e.getMessage());

        }
    }

}