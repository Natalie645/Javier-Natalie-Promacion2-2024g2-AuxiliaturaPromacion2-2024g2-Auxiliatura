import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        
        int tiempoTotal = K - (N - 1); 
        int tiempoPorDiscurso = tiempoTotal / N; 
        
        // Imprime el resultado
        System.out.println(tiempoPorDiscurso);
        
        sc.close();
    }
}
