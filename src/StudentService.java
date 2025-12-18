import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students;

    public StudentService(ArrayList<Student> students) {
        this.students = students;
    }

    public StudentService() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) return student;
        }
        return null;
    }

    public Student findTopStudent() {
        Student topStudent = null;
        double highestAverage = 0;
        for (Student s : students) {
            if (!s.getExams().isEmpty() && s.calculateAverageScore() > highestAverage) {
                highestAverage = s.calculateAverageScore();
                topStudent = s;
            }
        }
        return topStudent;
    }

    public void printStudentsWithStatus() {
        for (Student student : students) {
            System.out.println(student.getName() + "  " + (student.isPassed() ? "PASS" : "FAIL"));
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
