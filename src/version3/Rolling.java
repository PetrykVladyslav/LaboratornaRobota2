package version3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import java.util.Map;
public class Rolling implements Externalizable {
    private Map<Reader, Book> rental;
    public Rolling() {
        rental = new HashMap<>();
    }
    public void putBook(Reader reader, Book book) {
        rental.put(reader, book);
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(rental.size());
        for (Map.Entry<Reader, Book> entry : rental.entrySet()) {
            out.writeObject(entry.getKey());
            out.writeObject(entry.getValue());
        }
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int size = in.readInt();
        rental = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            Reader reader = (Reader) in.readObject();
            Book book = (Book) in.readObject();
            rental.put(reader, book);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Книг в прокаті:\n");
        for (Map.Entry<Reader, Book> entry : rental.entrySet()) {
            sb.append(entry.getValue()).append(" (Здано в прокат: ").append(entry.getKey()).append(")\n");
        }
        return sb.toString();
    }
}