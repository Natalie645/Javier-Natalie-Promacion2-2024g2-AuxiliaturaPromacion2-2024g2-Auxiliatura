public class Main {
    public static void main(String[] args) {
        // Crea un autor
        Author author = new Author("J.K. Rowling");

        // Agrega libros usando el método sobrecargado
        author.addBook("Harry Potter and the Philosopher's Stone", 20.99);
        author.addBook("Harry Potter and the Chamber of Secrets", 25.99);

        // Crea un libro usando el objeto Book y lo agrega al autor
        Book book3 = new Book("Harry Potter and the Prisoner of Azkaban", author, 30.99);
        author.addBook(book3);

        // Muestra la información del autor y sus libros
        author.getInfo();
    }
}