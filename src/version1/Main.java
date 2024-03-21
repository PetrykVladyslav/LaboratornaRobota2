package version1;

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Тарас", "Шевченко");
        Author author2 = new Author("Іван", "Франко");
        Author author3 = new Author("Олександр", "Довженко");
        Book book1 = new Book("Катерина", author1);
        Book book2 = new Book("Захар Беркут",author2);
        Book book3 = new Book("Зачарована Десна",author3);
        Bookcase bookcase = new Bookcase();
        bookcase.addBook(book1);
        bookcase.addBook(book2);
        bookcase.addBook(book3);
        System.out.println("Стан книжкової шафи:" + bookcase);
        Reader reader1 = new Reader("Петро", "Петренко");
        Reader reader2 = new Reader("Сергій", "Дорошенко");
        Rolling rolling = new Rolling();
        rolling.takeBook(reader1, book1);
        rolling.takeBook(reader2, book2);
        bookcase.removeBook(book1);
        bookcase.removeBook(book2);
        System.out.println("Стан прокату:" + rolling);
        System.out.println("Стан книжкової шафи:" + bookcase);
        try {
            LibrarySerializationUtil.serialize(bookcase, "library.ser");
            LibrarySerializationUtil.serialize(rolling, "rental.ser");
            System.out.println("Систему успішно серіалізовано.");
        } catch (IOException e) {
            System.out.println("Помилка під час серіалізації: " + e.getMessage());
        }

        try {
            Bookcase deserializedBookcase = (Bookcase) LibrarySerializationUtil.deserialize("library.ser");
            Rolling deserializedRolling = (Rolling) LibrarySerializationUtil.deserialize("rental.ser");
            System.out.println("Десеріалізована книжкова шафа:");
            System.out.println(deserializedBookcase);
            System.out.println("Десеріалізований прокат:");
            System.out.println(deserializedRolling);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка під час десеріалізації: " + e.getMessage());
        }
    }
}