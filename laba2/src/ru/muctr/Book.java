package ru.muctr;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private String title;
    private int numberPage;
    private Author author;

    public void setTitle(String title) {
        title = Character.toUpperCase(title.charAt(0)) + title.substring(1);
        this.title = title;

    }

    public void setNumberPage(int numberPage) throws Exception {
        if (numberPage >= 0) {
            this.numberPage = numberPage;
        }
        else{
            throw new Exception("количество страниц не может быть отрицательным");
        }
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public String getTitle() {
        return title;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public Author getAuthor() {
        return author;
    }

    public Book(String title, int numberPage, Author author)
    {
        this.title = title;
        this.numberPage = numberPage;
        this.author = author;
    }
    @Override
    public String toString()
    {
        return String.format("имя книги %s, количетво страниц %d, автор  %s", title, numberPage, author.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }
}
