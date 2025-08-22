package ap.projects.finalproject;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String studentId;
    private String username;
    private String password;
    private List<BorrowRequest> borrowRequests;

    public Student(String name, String studentId, String username, String password) {
        this.name = name;
        this.studentId = studentId;
        this.username = username;
        this.password = password;
        this.borrowRequests = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public void addBorrowRequest(BorrowRequest request) { borrowRequests.add(request); }
    public List<BorrowRequest> getBorrowRequests() { return borrowRequests; }

    @Override
    public String toString() {
        return "Name: " + name +
                " | Student ID: " + studentId +
                " | Username: " + username;
    }
}
