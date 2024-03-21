package version3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
public class Reader implements Externalizable {
    private String name;
    public Reader() {
    }
    public Reader(String name) {
        this.name = name;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
    }
    @Override
    public String toString() {
        return name;
    }
}