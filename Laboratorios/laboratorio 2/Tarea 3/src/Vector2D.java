public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D sumar(Vector2D v) {
        return new Vector2D(this.x + v.x, this.y + v.y);
    }

    public Vector2D restar(Vector2D v) {
        return new Vector2D(this.x - v.x, this.y - v.y);
    }

    public Vector2D multiplicar(double escalar) {
        return new Vector2D(this.x * escalar, this.y * escalar);
    }

    public Vector2D dividir(double escalar) {
        if (escalar != 0) {
            return new Vector2D(this.x / escalar, this.y / escalar);
        } else {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public static void main(String[] args) {

        Vector2D a = new Vector2D(2, 3);
        Vector2D b = new Vector2D(4, 1);

        Vector2D suma = a.sumar(b);
        Vector2D resta = a.restar(b);

        Vector2D multiplicacionEscalar = a.multiplicar(2);
        Vector2D divisionEscalar = a.dividir(2);

        System.out.println("Suma de a y b: " + suma);
        System.out.println("Resta de a y b: " + resta);
        System.out.println("Multiplicación de a por 2: " + multiplicacionEscalar);
        System.out.println("División de a por 2: " + divisionEscalar);
    }
}