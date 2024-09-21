import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ejercicio1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una fecha por ejemplo 4 de junio, 2004");
        String fechaEntrada = scanner.nextLine();
        
        try {
            String fechaFormateada = convertirFecha(fechaEntrada);
            System.out.println("Salida: " + fechaFormateada);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static String convertirFecha(String fecha) throws IllegalArgumentException {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("d 'de' MMMM, yyyy");
        SimpleDateFormat formatoSalida = new SimpleDateFormat("d / MM / yyyy");
        
        try {
            Date fechaConvertida = formatoEntrada.parse(fecha);
            return formatoSalida.format(fechaConvertida);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Fecha inválida o formato incorrecto.");
        }
    }
}

