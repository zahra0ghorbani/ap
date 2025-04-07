package ap.exercises.ex3;

public class Main_EX3_LM_1_1 {
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
        public String major;
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


    public static void main(String[] args) {
        Book book1=new Book("samfoni mordegan","abbas maroofi",1989,360);
        Book book2=new Book("boof koor","sadegh hedayat",1935,420);
        Student student1 = new Student ("zahra","ahmadi","78663625","physics");
        Student student2 = new Student("sahar","akbari","87376342","computer");
    }
}
