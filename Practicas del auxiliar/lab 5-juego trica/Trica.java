import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Trica {
    private static ArrayList<String> mazo = new ArrayList<>();
    private static ArrayList<String> manoJugador1 = new ArrayList<>();
    private static ArrayList<String> manoJugador2 = new ArrayList<>();

    public static void main(String[] args) {
        inicializarMazo();
        repartirCartas();

        System.out.println("¡Bienvenidos al juego de Trica de Cartas!");
        Scanner scanner = new Scanner(System.in);

        boolean jugando = true;
        while (jugando) {
            System.out.println("\nTurno del Jugador 1");
            imprimirMano(manoJugador1);
            jugarTurno(manoJugador1, scanner);

            if (verificarTrica(manoJugador1)) {
                System.out.println("¡Jugador 1 formó una Trica! ¡Ganó el juego!");
                break;
            }

            System.out.println("\nTurno del Jugador 2");
            imprimirMano(manoJugador2);
            jugarTurno(manoJugador2, scanner);

            if (verificarTrica(manoJugador2)) {
                System.out.println("¡Jugador 2 formó una Trica! ¡Ganó el juego!");
                break;
            }

            if (mazo.isEmpty()) {
                System.out.println("El mazo se ha terminado. ¡Es un empate!");
                jugando = false;
            }
        }

        scanner.close();
    }

    private static void inicializarMazo() {
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String palo : palos) {
            for (String valor : valores) {
                mazo.add(valor + " de " + palo);
            }
        }

        Collections.shuffle(mazo);
    }

    private static void repartirCartas() {
        for (int i = 0; i < 6; i++) {
            manoJugador1.add(mazo.remove(0));
            manoJugador2.add(mazo.remove(0));
        }
    }

    private static void imprimirMano(ArrayList<String> mano) {
        System.out.println("Tu mano: ");
        for (int i = 0; i < mano.size(); i++) {
            System.out.println((i + 1) + ". " + mano.get(i));
        }
    }

    private static void jugarTurno(ArrayList<String> mano, Scanner scanner) {
        System.out.println("Selecciona una carta para descartar (1-" + mano.size() + "): ");
        int cartaADescartar = scanner.nextInt() - 1;

        if (cartaADescartar < 0 || cartaADescartar >= mano.size()) {
            System.out.println("Selección inválida. Pierdes el turno.");
            return;
        }

        String descartada = mano.remove(cartaADescartar);
        System.out.println("Has descartado: " + descartada);

        if (!mazo.isEmpty()) {
            String nuevaCarta = mazo.remove(0);
            mano.add(nuevaCarta);
            System.out.println("Has robado: " + nuevaCarta);
        } else {
            System.out.println("El mazo está vacío. No puedes robar.");
        }
    }

    private static boolean verificarTrica(ArrayList<String> mano) {
        ArrayList<String> valores = new ArrayList<>();
        for (String carta : mano) {
            valores.add(carta.split(" ")[0]);
        }

        for (String valor : valores) {
            int count = 0;
            for (String v : valores) {
                if (v.equals(valor)) {
                    count++;
                }
            }
            if (count >= 3) {
                return true; 
            }
        }

        return false;
    }
}
