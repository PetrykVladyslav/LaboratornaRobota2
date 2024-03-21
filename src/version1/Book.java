package version1;

import java.io.Serializable;
public class Book implements Serializable {
    private String name;
    private Author author;
    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "'" + name + "' " + author.toString();
    }
}