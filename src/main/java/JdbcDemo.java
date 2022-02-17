import java.sql.*;

public class JdbcDemo {

    public static void main(String[] args) {

        System.out.println("JDBC Demo!");
        sellectAllDemo();

    }

    public static void sellectAllDemo(){


        System.out.println("Select Demo mit Jdbc");

        String connectionUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd))

        {
            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement( "Select * from `student`");
            ResultSet rs =  preparedStatement.executeQuery();
            while (rs.next())
            {
               int id = rs.getInt("id");
               String name = rs.getString("name");
               String email = rs.getString("email");

                System.out.println("Student aus der DB: Id: " + id + " | Name: " + name + " | Email: " + email);

            }


        } catch (SQLException e){

            System.out.println("Fehler beim Aufbau der Verbindung zur Datenbank: " + e.getMessage());

        }
    }

}