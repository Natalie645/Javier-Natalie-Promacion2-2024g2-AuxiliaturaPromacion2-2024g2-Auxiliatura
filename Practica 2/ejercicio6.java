import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        
        long numerador = 1;
        long denominador = 1;
        
        
        for (int i = 0; i < N; i++) {
            long temp = numerador;
            numerador = denominador;
            denominador = temp + denominador;
        }
        
        
        System.out.println(numerador);
    }
}

