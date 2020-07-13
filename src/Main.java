import entities.Student;
import repositories.StudentsRepository;
import repositories.StudentsRepositoryJdbcImpl;

import java.sql.*;
import java.util.List;

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

    public static void main(String[] args) throws SQLException {

        Connection connection = openConnection(url, user, password);
        StudentsRepository studentsRepository = new StudentsRepositoryJdbcImpl(connection);
        System.out.println(studentsRepository.findById(2L));
        connection.close();
    }
}