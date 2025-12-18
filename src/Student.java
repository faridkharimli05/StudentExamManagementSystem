import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private ArrayList<Exam> exams;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.exams = new ArrayList<>();
    }

    public Student() {
        this.exams = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exams=" + exams +
                " ,calculateAverageScore=" + calculateAverageScore() +
                " ,hasPassedAllExams=" + hasPassedAllExams() +
                " }";
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    public double calculateAverageScore() {
        if (exams.isEmpty()) return 0;
        double total = 0;
        for (Exam e : exams) {
            total += e.getScore();
        }
        return total / exams.size();
    }

    public boolean hasPassedAllExams() {
        if (exams.isEmpty()) return false;
        for (Exam exam : exams) {
            if (!exam.isPassed()) return false;
        }
        return true;
    }

    public boolean isPassed() {
        return calculateAverageScore() >= 60 && hasPassedAllExams();
    }
}
