package contact;

import java.io.*;
import java.util.*;

public class ContactManager {
    private Map<String, Contact> contacts;
    private static final String FILE_PATH = "contacts.dat";

    public ContactManager() {
        contacts = new HashMap<>();
        loadContacts();
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getEmail(), contact);
        saveContacts();
    }

    public Contact searchContact(String email) {
        return contacts.get(email);
    }

    public void removeContact(String email) {
        contacts.remove(email);
        saveContacts();
    }

    public void showAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contacts.values()) {
                contact.print();
            }
        }
    }

    private void saveContacts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            System.err.println("Error saving contacts: " + e.getMessage());
        }
    }

    private void loadContacts() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                contacts = (Map<String, Contact>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading contacts: " + e.getMessage());
                contacts = new HashMap<>();
            }
        } else {
            contacts = new HashMap<>();
        }
    }
}
