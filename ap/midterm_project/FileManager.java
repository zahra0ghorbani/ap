package ap.midterm_project;

import java.io.*;


public class FileManager {

    private static final String LIBRARY_FILE = "library_data.ser";

    public static Library loadLibraryData() {
        Library library = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(LIBRARY_FILE))) {
            library = (Library) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Library data file not found. Creating a new library.");
            library = new Library("My Library");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading library data: " + e.getMessage());
            library = new Library("My Library");
        }
        return library;
    }

    public static void saveLibraryData(Library library) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(LIBRARY_FILE))) {
            oos.writeObject(library);
        } catch (IOException e) {
            System.out.println("Error saving library data: " + e.getMessage());
        }
    }
}
