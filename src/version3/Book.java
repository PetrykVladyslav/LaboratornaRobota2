package version3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
public class Book implements Externalizable {
    private String title;
    private Author author;
    public Book() {
    }
    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeObject(author);
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        author = (Author) in.readObject();
    }
    @Override
    public String toString() {
        return "'" + title + "' " + author;
    }
}