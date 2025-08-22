package result;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StudentManager manager = new StudentManager();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n1. Add Student\n2. View All Students\n3. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			if (choice == 1) {
				System.out.print("ID: ");
				String id = scanner.nextLine();
				System.out.print("Name: ");
				String name = scanner.nextLine();
				System.out.print("Math Marks: ");
				int math = scanner.nextInt();
				System.out.print("Science Marks: ");
				int science = scanner.nextInt();
				System.out.print("Computer Marks: ");
				int computer = scanner.nextInt();
				manager.addStudent(id, name, math, science, computer);
				System.out.println("Student added successfully!");
			} else if (choice == 2) {
				manager.displayAllStudents();
			} else if (choice == 3) {
				break;
			} else {
				System.out.println("Invalid choice!");
			}
		}

		scanner.close();
	}
}
