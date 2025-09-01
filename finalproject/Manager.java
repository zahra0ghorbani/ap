package ap.projects.finalproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Manager implements Serializable {
    private String username;
    private String password;
    private List<Employee> employees;

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
        this.employees = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(String username, String password) {
        employees.add(new Employee(username, password));
        System.out.println("New employee added: " + username);
    }
}
