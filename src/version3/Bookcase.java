package version3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
public class Bookcase implements Externalizable {
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
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(books.size());
        for (Book book : books) {
            out.writeObject(book);
        }
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int size = in.readInt();
        books = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Book book = (Book) in.readObject();
            books.add(book);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Книг на полиці:\n");
        for (Book book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }
}