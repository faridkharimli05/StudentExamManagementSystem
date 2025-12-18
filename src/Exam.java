public class Exam {

    private String subject;
    private Double score;


    public Exam(String subject, Double score) {
        this.subject = subject;
        this.score = score;
    }




    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "subject='" + subject + '\'' +
                ", score=" + score +
                '}';
    }


    public boolean isPassed(){
        return score >= 50;
    }


}
