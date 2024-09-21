import java.util.Random;
import java.util.Scanner;

public class ejercicio3 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        int contadorBotines = 0;
        
        System.out.println("Bienvenido al sistema de botín de Borderlands!");
        
        while (continuar) {
            System.out.println("Has derrotado a un enemigo. Generando botín...");
            Botin botin = generarBotin();
            contadorBotines++;
            mostrarBotin(botin);
            
            System.out.print("¿Quieres seguir enfrentándote a más enemigos? (s/n): ");
            String respuesta = scanner.nextLine();
            
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
                System.out.println("Gracias por jugar. Total de botines obtenidos: " + contadorBotines);
            }
        }
        
        scanner.close();
    }

    public static Botin generarBotin() {
        Random random = new Random();
        
        String[] tipos = {"Arma", "Escudo", "Modificador"};
        String tipo = tipos[random.nextInt(tipos.length)];
        
        String[] rarezas = {"Común", "Poco Común", "Raro", "Épico", "Legendario"};
        String rareza = rarezas[random.nextInt(rarezas.length)];
        
        int atributo1 = random.nextInt(100) + 1; // Entre 1 y 100
        int atributo2 = random.nextInt(100) + 1;
        int atributo3 = random.nextInt(100) + 1;
        
        return new Botin(tipo, rareza, atributo1, atributo2, atributo3);
    }
    
    public static void mostrarBotin(Botin botin) {
        System.out.println("Has recibido un botín!");
        System.out.println("Tipo: " + botin.tipo);
        System.out.println("Rareza: " + botin.rareza);
        System.out.println("Atributo 1: " + botin.atributo1);
        System.out.println("Atributo 2: " + botin.atributo2);
        System.out.println("Atributo 3: " + botin.atributo3);
        System.out.println("-------------------------------");
    }
}

class Botin {
    String tipo;
    String rareza;
    int atributo1;
    int atributo2;
    int atributo3;

    public Botin(String tipo, String rareza, int atributo1, int atributo2, int atributo3) {
        this.tipo = tipo;
        this.rareza = rareza;
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
        this.atributo3 = atributo3;
    }
}
