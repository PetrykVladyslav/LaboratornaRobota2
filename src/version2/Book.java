package version2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class Book implements Serializable {
    private transient String title;
    private transient Author author;
    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }
    @Override
    public String toString() {
        return "'" + title + "' " + author;
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(title);
        out.writeObject(author);
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        author = (Author) in.readObject();
    }
}