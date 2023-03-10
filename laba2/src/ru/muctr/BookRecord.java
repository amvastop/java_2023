package ru.muctr;

public record BookRecord(String title, int numberPage, Author author) implements Comparable<BookRecord> {
    public BookRecord {
        if (numberPage > 0) {
            System.out.println("ljk;yj ,snm ,jkmit yekz");

        }
    }

    @Override
    public int compareTo(BookRecord o) {
        return this.title.compareTo(o.title);
    }
}
