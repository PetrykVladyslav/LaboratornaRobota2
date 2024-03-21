package version2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Bookcase implements Serializable {
    private List<Book> books;
    public Bookcase() {
        this.books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBook(Book book) {
        books.remove(book);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Книг на полиці:\n");
        for (Book book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }
}