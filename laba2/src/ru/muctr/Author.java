package ru.muctr;

import java.util.Objects;

public class Author {
    String name;

    public Author(String name)
    {
        this.name = name;
    }
    public String toString()
    {
        return name;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return name.equals(author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
