import java.util.ArrayList;
import java.util.List;

public class Author {

    private String name;
    private List<Book> books;

    public Author(String name)
    {
        this.name = name;
        this.books = new
    ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addBook(String title, double price) {
        Book newBook = new Book(title, this, price);
        books.add(newBook);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void getInfo() {
        System.err.println("Author: " + name);
    for (Book book : books) {
        book.getInfo();
    }
}
}