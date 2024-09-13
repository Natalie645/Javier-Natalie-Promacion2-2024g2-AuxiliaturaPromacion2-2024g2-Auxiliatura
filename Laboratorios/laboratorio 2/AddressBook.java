package laboratorio;

import java.io.*;
import java.util.HashMap;

public class AddressBook {
    private HashMap<String, Contact> contacts;
    private static final String FILE_NAME = "contacts.ser"; // Nombre del archivo para la persistencia

    public AddressBook() {
        this.contacts = new HashMap<>();
        loadContacts(); // Cargar los contactos al iniciar
    }

    // Método para añadir contacto
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getEmail())) {
            System.out.println("A contact with this email already exists.");
        } else {
            contacts.put(contact.getEmail(), contact);
            System.out.println("Contact added successfully.");
            storeContacts(); // Guardar cambios en el archivo
        }
    }

    // Método para ver todos los contactos
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("The address book is empty.");
        } else {
            for (Contact contact : contacts.values()) {
                System.out.println(contact);
            }
        }
    }

    // Método para buscar contacto
    public Contact searchContact(String email) {
        Contact contact = contacts.get(email);
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("Contact not found.");
        }
        return contact;
    }

    // Método para eliminar contacto
    public boolean deleteContact(String email) {
        Contact removedContact = contacts.remove(email);
        if (removedContact != null) {
            System.out.println("Contact deleted.");
            storeContacts(); // Guardar cambios en el archivo
            return true;
        } else {
            System.out.println("No contact found with the provided email.");
            return false;
        }
    }

    // Método para guardar los contactos en un archivo
    public void storeContacts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(contacts);
            System.out.println("Contacts saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    // Método para cargar los contactos desde un archivo
    public void loadContacts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            contacts = (HashMap<String, Contact>) ois.readObject();
            System.out.println("Contacts loaded from file.");
        } catch (FileNotFoundException e) {
            System.out.println("No saved contacts found. Starting with an empty address book.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }
}