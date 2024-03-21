package version2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Іван Котляревський");
        Author author2 = new Author("Григорій Сковорода");
        Author author3 = new Author("Григір Тютюник");
        Book book1 = new Book("Енеїда", author1);
        Book book2 = new Book("Бджола та шершень", author2);
        Book book3 = new Book("Климко", author3);
        Bookcase bookcase = new Bookcase();
        bookcase.addBook(book1);
        bookcase.addBook(book2);
        bookcase.addBook(book3);
        System.out.println("Стан книжкової шафи: \n" + bookcase);
        Reader reader1 = new Reader("Михайло Михайлюк");
        Reader reader2 = new Reader("Святослав Іванчук");
        Rolling rolling = new Rolling();
        rolling.putBook(reader1, book1);
        rolling.putBook(reader2, book2);
        bookcase.removeBook(book1);
        bookcase.removeBook(book2);
        System.out.println("Стан прокату: \n" + rolling);
        System.out.println("Стан книжкової шафи: \n" + bookcase);
        try {
            serializeObject(bookcase, "library_v2.ser");
            serializeObject(rolling, "rental_v2.ser");
            System.out.println("Систему успішно серіалізовано.");
        } catch (IOException e) {
            System.out.println("Помилка під час серіалізації: " + e.getMessage());
        }

        try {
            Bookcase deserializedLibraryShelf = (Bookcase) deserializeObject("library_v2.ser");
            Rolling deserializedRental = (Rolling) deserializeObject("rental_v2.ser");

            System.out.println("Десеріалізована книжкова шафа:");
            System.out.println(deserializedLibraryShelf);

            System.out.println("Десеріалізований прокат:");
            System.out.println(deserializedRental);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка під час десеріалізації: " + e.getMessage());
        }
    }
    private static void serializeObject(Serializable object, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            out.writeObject(object);
        }
    }
    private static Object deserializeObject(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            return in.readObject();
        }
    }
}