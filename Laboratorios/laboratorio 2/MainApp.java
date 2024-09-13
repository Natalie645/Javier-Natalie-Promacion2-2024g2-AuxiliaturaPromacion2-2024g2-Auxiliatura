package laboratorio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        try (Scanner scanner = new Scanner(System.in)) {
            Integer option;

            do {
                showMenu(); // Mostrar el menú
                try {
                    option = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    switch (option) {
                        case 1:
                            System.out.print("Enter name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter email: ");
                            String email = scanner.nextLine();
                            System.out.print("Enter age: ");
                            int age = scanner.nextInt();
                            scanner.nextLine(); // Limpiar buffer
                            System.out.print("Enter phone number: ");
                            String phone = scanner.nextLine();
                            Contact contact = new Contact(name, email, age, phone);
                            addressBook.addContact(contact);
                            System.out.println("Contact added successfully.");
                            break;
                        case 2:
                            addressBook.viewContacts();
                            break;
                        case 3:
                            System.out.print("Enter the email of the contact to search: ");
                            email = scanner.nextLine();
                            addressBook.searchContact(email);
                            break;
                        case 4:
                            System.out.print("Enter the email of the contact to delete: ");
                            email = scanner.nextLine();
                            addressBook.deleteContact(email);
                            System.out.println("Contact deleted successfully.");
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Limpiar buffer después del error
                    option = -1; // Para evitar salir del loop en caso de error
                }
            } while (option == null || option != 5);
        }
    }

    // Método para mostrar el menú
    private static void showMenu() {
        System.out.println("\n** Contact Address Book **");
        System.out.println("1. Add contact");
        System.out.println("2. View contacts");
        System.out.println("3. Search for contact");
        System.out.println("4. Delete contact");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
    }
}