package result;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManager {
	private Database db;

	public StudentManager() {
		db = new Database();
	}

	public void addStudent(String id, String name, int math, int science, int computer) {
		Student student = new Student(id, name, math, science, computer);
		db.insertStudent(student);
	}

	public void displayAllStudents() {
		ResultSet rs = db.fetchAllStudents();
		try {
			while (rs != null && rs.next()) {
				System.out.println("ID: " + rs.getString("student_id") + ", Name: " + rs.getString("name") + ", Math: "
						+ rs.getInt("math") + ", Science: " + rs.getInt("science") + ", Computer: "
						+ rs.getInt("computer") + ", Percentage: " + rs.getDouble("percentage") + "%");
			}
		} catch (SQLException e) {
			System.out.println("Display failed: " + e.getMessage());
		}
	}
}
