package ap.projects.finalproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentManager implements Serializable {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }


    public void registerStudent(String name, String studentId, String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("This username already exists. Choose a different username.");
            return;
        }
        students.add(new Student(name, studentId, username, password));
        System.out.println("Student registration completed successfully.");
    }

    public Student authenticateStudent(String username, String password) {
        return students.stream()
                .filter(s -> s.getUsername().equals(username) && s.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    private boolean isUsernameTaken(String username) {
        return students.stream().anyMatch(s -> s.getUsername().equals(username));
    }

    public int getStudentCount() { return students.size(); }
}
