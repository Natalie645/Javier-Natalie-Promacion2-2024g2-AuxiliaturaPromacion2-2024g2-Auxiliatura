import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] original = new int[N][N];
        int[][] rotated = new int[N][N];
        
    
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                original[i][j] = sc.nextInt();
            }
        }
        
        int rotaciones = 0;
        
        while (rotaciones < 4) {
            
            if (esIgual(original, rotated)) {
                break;
            }
            
            
            rotated = rotar90Grados(rotated);
            rotaciones++;
        }
        
        System.out.println(rotaciones);
    }
    
    
    public static int[][] rotar90Grados(int[][] matriz) {
        int N = matriz.length;
        int[][] nuevaMatriz = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nuevaMatriz[j][N - 1 - i] = matriz[i][j];
            }
        }
        return nuevaMatriz;
    }
    
    
    public static boolean esIgual(int[][] matriz1, int[][] matriz2) {
        int N = matriz1.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matriz1[i][j] != matriz2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}


//para hacer los ejemplos haz de esta manera
/*
   3
   2 3 4
   2 3 4
   2 1 3 
 
 */
//use matrices
