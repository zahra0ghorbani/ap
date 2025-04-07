package ap.exercises.ex3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main_EX3_LM_1_2 {


    static class Book {
        private String title;
        private String author;
        private int year;
        private int pageCount;


        public Book(String title, String author, int year, int pageCount) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.pageCount = pageCount;
        }


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }
    }


    static class Student {
        private String firstName;
        private String lastName;
        private String id;
        private String major;


        public Student(String firstName, String lastName, String id, String major) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
            this.major = major;
        }


        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }
    }


    public static void saveBooks(Book[] books, String fileName) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        for (Book book : books) {
            writer.println(book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getPageCount());
        }
        writer.close();
    }


    public static void saveStudents(Student[] students, String fileName) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        for (Student student : students) {
            writer.println(student.getFirstName() + "," + student.getLastName() + "," + student.getId() + "," + student.getMajor());
        }
        writer.close();
    }

    public static void main(String[] args) {

        Book book1 = new Book("Samfoni Mordegan", "Abbas Maroofi", 1989, 360);
        Book book2 = new Book("Boof Koor", "Sadegh Hedayat", 1935, 420);
        Book book3 = new Book("hardo darnahayat mimirand", "som body", 1989, 360);
        Book book4 = new Book("why", "shafagh", 1989, 360);

        Student student1 = new Student("Zahra", "Ahmadi", "78663625", "Physics");
        Student student2 = new Student("Sahar", "Akbari", "87376342", "Computer");
        Student student3 = new Student("ali", "samady", "244333625", "chemistry");


        Book[] books = { book1, book2 , book3 , book4 };
        Student[] students = { student1, student2, student3 };

        try {

            saveBooks(books, "books.txt");
            System.out.println("Books have been saved to 'books.txt'.");


            saveStudents(students, "students.txt");
            System.out.println("Students have been saved to 'students.txt'.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving data.");
            e.printStackTrace();
        }
    }
}
