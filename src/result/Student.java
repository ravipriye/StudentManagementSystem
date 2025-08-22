package result;

public class Student {
	private String studentId;
	private String name;
	private int math;
	private int science;
	private int computer;
	private double percentage;

	public Student(String studentId, String name, int math, int science, int computer) {
		this.studentId = studentId;
		this.name = name;
		this.math = math;
		this.science = science;
		this.computer = computer;
		this.percentage = calculatePercentage();
	}

	private double calculatePercentage() {
		int total = math + science + computer;
		return Math.round((total / 300.0) * 10000.0) / 100.0;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public int getMath() {
		return math;
	}

	public int getScience() {
		return science;
	}

	public int getComputer() {
		return computer;
	}

	public double getPercentage() {
		return percentage;
	}
}
