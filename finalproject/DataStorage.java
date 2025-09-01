package ap.projects.finalproject;

import java.io.*;
import java.util.*;

public class DataStorage {
    private static final String FILE_NAME = "library_data.ser";

    public static void saveData(LibrarySystem system) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(system);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static LibrarySystem loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (LibrarySystem) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found. Starting fresh.");
            return new LibrarySystem();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return new LibrarySystem();
        }
    }
}
