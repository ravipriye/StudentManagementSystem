package result;

import java.sql.*;

public class Database {
    private Connection conn;

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db", "root", "Ravi@1234"
            ); // Replace with your credentials
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public void insertStudent(Student student) {
        try {
            String query = "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, student.getStudentId());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getMath());
            stmt.setInt(4, student.getScience());
            stmt.setInt(5, student.getComputer());
            stmt.setDouble(6, student.getPercentage());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    public ResultSet fetchAllStudents() {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery("SELECT * FROM students");
        } catch (SQLException e) {
            System.out.println("Fetch failed: " + e.getMessage());
            return null;
        }
    }
}
