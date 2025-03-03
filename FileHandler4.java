import java.io.*;
import java.util.*;

public class FileHandler4 {
    private static final String FILE_PATH = "contacts.txt";

    public static void saveContacts(List<Contact> contacts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            System.out.println("❌ Error saving contacts.");
        }
    }

    public static List<Contact> loadContacts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Contact>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
