package version3;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Леся Українка");
        Author author2 = new Author("Ліна Костенко");
        Author author3 = new Author("Михайло Коцюбинський");
        Book book1 = new Book("Лісова Пісня", author1);
        Book book2 = new Book("Маруся Чурай", author2);
        Book book3 = new Book("Intermezzo", author3);
        Bookcase bookcase = new Bookcase();
        bookcase.addBook(book1);
        bookcase.addBook(book2);
        bookcase.addBook(book3);
        System.out.println("Стан книжкової шафи: \n" + bookcase);

        Reader reader1 = new Reader("Ярослав Мудрий");
        Reader reader2 = new Reader("Володимир Великий");
        Rolling rolling = new Rolling();
        rolling.putBook(reader1, book1);
        rolling.putBook(reader2, book2);
        bookcase.removeBook(book1);
        bookcase.removeBook(book2);
        System.out.println("Стан прокату: \n" + rolling);
        System.out.println("Стан книжкової шафи: \n" + bookcase);
        try {
            serializeObject(bookcase, "library_v3.ser");
            serializeObject(rolling, "rental_v3.ser");
            System.out.println("Систему успішно серіалізовано.");
        } catch (IOException e) {
            System.out.println("Помилка під час серіалізації: " + e.getMessage());
        }
        try {
            Bookcase deserializedLibraryShelf = (Bookcase) deserializeObject("library_v3.ser");
            Rolling deserializedRental = (Rolling) deserializeObject("rental_v3.ser");

            System.out.println("Десеріалізована книжкова шафа:");
            System.out.println(deserializedLibraryShelf);

            System.out.println("Десеріалізований прокат:");
            System.out.println(deserializedRental);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка під час десеріалізації: " + e.getMessage());
        }
    }
    private static void serializeObject(Externalizable object, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            out.writeUTF(object.getClass().getName());
            object.writeExternal(out);
        }
    }
    private static Externalizable deserializeObject(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            String className = in.readUTF();
            Class<?> clazz = Class.forName(className);
            Externalizable object = (Externalizable) clazz.getDeclaredConstructor().newInstance();
            object.readExternal(in);
            return object;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new IOException("Помилка під час десеріалізації: " + e.getCause().getMessage());
        }
    }
}