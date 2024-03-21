package version1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Bookcase implements Serializable {
    private List<Book> books;
    public Bookcase() {
        books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBook(Book book) {
        books.remove(book);
    }
    public List<Book> getBooks() {
        return books;
    }
    @Override
    public String toString() {
        return "КнижковаШафа{" +
                "книги=" + books +
                '}';
    }
}