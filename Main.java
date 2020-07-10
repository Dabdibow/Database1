import java.sql.*;

public class Main {

    private static final String url = "jdbc:postgresql://localhost:5432/java_lab_pract_2020";
    private static final String user = "postgres";
    private static final String password = "Vodyvad2001";

    public static Connection openConnection(String url, String user, String password){
        try {
            return DriverManager.getConnection(url,
                    user, password);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) {

        Connection connection = openConnection(url, user, password);

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");

            while(resultSet.next()){
                System.out.println("ID-" + resultSet.getInt("id"));
                System.out.println("First Name-" + resultSet.getString("first_name"));
                System.out.println("Second Name-" + resultSet.getString("second_name"));
                System.out.println("Age-" + resultSet.getInt("age"));
                System.out.println("Group number-" + resultSet.getInt("group_number"));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw  new IllegalArgumentException(e);
        }
    }
}
