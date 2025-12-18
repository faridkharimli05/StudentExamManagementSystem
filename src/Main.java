import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentService service = new StudentService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("====== STUDENT EXAM MANAGEMENT SYSTEM ======");
            System.out.println("1. Add student");
            System.out.println("2. Add exam to student");
            System.out.println("3. Show all students");
            System.out.println("4. Show pass/fail status");
            System.out.println("5. Show top student");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    Student student = new Student(id, name);
                    service.addStudent(student);
                    System.out.println("Student added successfully!");
                }

                case 2 -> {
                    System.out.print("Enter student ID to add exam: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();
                    Student s = service.findStudentById(studentId);
                    if (s == null) {
                        System.out.println("Student not found!");
                        break;
                    }
                    System.out.print("Enter subject name: ");
                    String subject = scanner.nextLine();
                    System.out.print("Enter score (0-100): ");
                    int score = scanner.nextInt();
                    scanner.nextLine();
                    Exam exam = new Exam(subject, (double) score);
                    s.addExam(exam);
                    System.out.println("Exam added successfully!");
                }

                case 3 -> {
                    ArrayList<Student> students = service.getStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        for (Student st : students) {
                            System.out.println(st);
                        }
                    }
                }

                case 4 -> {
                    ArrayList<Student> students = service.getStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        service.printStudentsWithStatus();
                    }
                }

                case 5 -> {
                    Student top = service.findTopStudent();
                    if (top == null) {
                        System.out.println("No top student found!");
                    } else {
                        System.out.println("Top student:\n" + top);
                    }
                }

                case 0 -> {
                    System.out.println("Exiting program.");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
