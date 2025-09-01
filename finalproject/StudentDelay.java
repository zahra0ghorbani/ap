package ap.projects.finalproject;

public class StudentDelay {
    private Student student;
    private int delayDays;

    public StudentDelay(Student student, int delayDays) {
        this.student = student;
        this.delayDays = delayDays;
    }

    public Student getStudent() {
        return student;
    }

    public int getDelayDays() {
        return delayDays;
    }
}

