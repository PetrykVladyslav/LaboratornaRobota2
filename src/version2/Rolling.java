package version2;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Rolling implements Serializable {
    private Map<Reader, Book> rental;
    public Rolling() {
        this.rental = new HashMap<>();
    }
    public void putBook(Reader reader, Book book) {
        rental.put(reader, book);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Книг в прокаті:\n");
        for (Map.Entry<Reader, Book> entry : rental.entrySet()) {
            sb.append(entry.getValue()).append(" (Здано в прокат: ").append(entry.getKey()).append(")\n");
        }
        return sb.toString();
    }
}