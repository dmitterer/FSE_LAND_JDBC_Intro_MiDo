import java.sql.*;

public class JdbcDemo {

    public static void main(String[] args) {

        System.out.println("JDBC Demo!");
        selectAllDemo();
       // insertStudentDemo("David Föger", "da.foeg@gmail.com");
        //selectAllDemo();
       // updateStudentDemo(3, "Harry Potter", "harry.potter@gmx.net");
        selectAllDemo();
       // deleteStudentDemo(4);
        selectAllDemo();
       findAllByNameLike("%D%");


    }

    private static void findAllByNameLike(String pattern)
    {
        System.out.println("Find all by Name Demo mit Jdbc");

        String connectionUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd))

        {
            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement( "Select * from `student` where `student`.`name` LIKE ?");
            preparedStatement.setString(1,"%"+pattern+"%");
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


    public static void deleteStudentDemo(int studentId)
    {

        System.out.println("Delete Demo mit Jdbc");

        String connectionUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd))

        {
            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "DELETE FROM `student` WHERE `student`.`id` = ?");

            try
            {

                preparedStatement.setInt(1, studentId);
                int rowAffected = preparedStatement.executeUpdate();
                System.out.println("Anzahl der gelöschten Datensätze: " + rowAffected);

            }catch (SQLException ex)
            {

                System.out.println("Fehler im SQL-Delete Statement: " + ex.getMessage());

            }

        } catch (SQLException e){

            System.out.println("Fehler beim Aufbau der Verbindung zur Datenbank: " + e.getMessage());

        }

    }


    public static void updateStudentDemo( int id, String neuerName, String neueEMail)
    {
        System.out.println("Update Demo mit Jdbc");

        String connectionUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd))

        {
            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE `student` SET `name` = ? , `email` = ? WHERE `student`.`id` = ?");

            try
            {

                preparedStatement.setInt(3, id);
                preparedStatement.setString(1, neuerName);
                preparedStatement.setString(2,neueEMail);
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println("Anzahl der aktualisierten Datensätze: " + affectedRows);
            }catch (SQLException ex)
            {

                System.out.println("Fehler im SQL-Update Statement: " + ex.getMessage());

            }

        } catch (SQLException e){

            System.out.println("Fehler beim Aufbau der Verbindung zur Datenbank: " + e.getMessage());

        }

    }


    public static void insertStudentDemo(String name, String email){

        System.out.println("Insert Demo mit Jdbc");

        String connectionUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd))

        {
            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, ?, ?)");

            try
            {

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                int rowAffected = preparedStatement.executeUpdate();
                System.out.println(rowAffected + " Datensätze eingefügt");


            }catch (SQLException ex)
            {

                System.out.println("Fehler im SQL-Insert Statement: " + ex.getMessage());

            }

        } catch (SQLException e){

            System.out.println("Fehler beim Aufbau der Verbindung zur Datenbank: " + e.getMessage());

        }

    }

    public static void selectAllDemo(){


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