package contact;

import java.util.Scanner;
import contact.Contact;
import contact.ContactManager;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();
        String readKeyBoard;

        do {
            createMenu();
            readKeyBoard = input.nextLine();

            try {
                int options = Integer.parseInt(readKeyBoard);

                switch (options) {
                    case 1:
                        // Agregar un nuevo contacto
                        System.out.println("Por favor, agrega un nuevo contacto");
                        System.out.println("Escribe el nombre:");
                        String name = input.nextLine();
                        System.out.println("Escribe el email:");
                        String email = input.nextLine();
                        System.out.println("Escribe la edad:");
                        String ageStr = input.nextLine();
                        try {
                            int age = Integer.parseInt(ageStr);
                            Contact contact = new Contact(name, age, email);
                            contactManager.addContact(contact);
                        } catch (NumberFormatException e) {
                            System.out.println("Edad inválida. Debe ser un número entero.");
                        }
                        break;

                    case 2:
                        // Buscar un contacto por email
                        System.out.println("Para buscar un contacto, pon el email:");
                        email = input.nextLine();
                        Contact result = contactManager.searchContact(email);
                        if (result != null) {
                            result.print();
                        } else {
                            System.out.println("Contacto no encontrado.");
                        }
                        break;

                    case 3:
                        // Eliminar un contacto por email
                        System.out.println("Para eliminar un contacto, pon el email:");
                        email = input.nextLine();
                        contactManager.removeContact(email);
                        break;

                    case 4:
                        // Mostrar todos los contactos
                        contactManager.showAllContacts();
                        break;

                    case 5:
                        // Salir del programa
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida. Por favor, elige una opción válida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
            }

        } while (!readKeyBoard.equals("5"));

        input.close();
    }

    public static void createMenu() {
        System.out.println("1. Agregar Contacto");
        System.out.println("2. Buscar Contacto");
        System.out.println("3. Eliminar Contacto");
        System.out.println("4. Mostrar Contactos");
        System.out.println("5. Salir");
    }
}