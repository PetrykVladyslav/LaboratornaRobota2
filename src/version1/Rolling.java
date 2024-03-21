package version1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class Rolling implements Serializable{
    private Map<Reader, Book> selectedBooks;
    public Rolling() {
        selectedBooks = new HashMap<>();
    }
    public void takeBook(Reader reader, Book book) {
        selectedBooks.put(reader, book);
    }
    public void returnBook(Reader reader) {
        selectedBooks.remove(reader);
    }
    @Override
    public String toString() {
        return "Прокат{" +
                "вибраніКниги=" + selectedBooks +
                '}';
    }
}