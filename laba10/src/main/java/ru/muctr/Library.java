package ru.muctr;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@Entity
@Table(name = "libraries")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber")
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List<Worker> workers;

    @ManyToMany()
    @JoinTable(
            name = "libraries_books",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")

    )
    private List<Book> Books;

    public Library(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "Prepod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}