package version1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LibrarySerializationUtil {
    public static void serialize(Object object, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            out.writeObject(object);
        }
    }
    public static Object deserialize(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            return in.readObject();
        }
    }
}