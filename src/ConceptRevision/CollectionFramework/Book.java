package ConceptRevision.CollectionFramework;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private int id;
    private String bookName;
    private String author;

    Book(int id,String name,String author){
        this.id = id;
        this.bookName = name;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return this.getId() < o.getId()?1 : (this.getId() > o.getId())? -1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(bookName, book.bookName) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, author);
    }
}
