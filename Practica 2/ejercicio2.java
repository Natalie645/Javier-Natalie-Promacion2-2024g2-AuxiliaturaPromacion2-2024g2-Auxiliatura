import java.util.List;
import java.util.ArrayList;

public class ejercicio2 {

    public static void main(String[] args) {
        
        List<String> palabras = new ArrayList<>();
        palabras.add("manzana");
        palabras.add("mesa");
        palabras.add("perro");
        palabras.add("gato");
        palabras.add("Motor");

        
        char letra = 'm';  

        
        int contador = contarPalabrasQueEmpiezanCon(palabras, letra);

       
        System.out.println("Número de palabras que comienzan con '" + letra + "': " + contador);
    }

    
    public static int contarPalabrasQueEmpiezanCon(List<String> palabras, char letra) {
        int contador = 0;
        letra = Character.toLowerCase(letra);  

        for (String palabra : palabras) {
            if (!palabra.isEmpty() && Character.toLowerCase(palabra.charAt(0)) == letra) {
                contador++;
            }
        }

        return contador;
    }
}

