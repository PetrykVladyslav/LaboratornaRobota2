package version2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Author implements Serializable {
    private transient String name;
    public Author(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(name);
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
    }
}