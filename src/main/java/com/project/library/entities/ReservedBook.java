package com.project.library.entities;

import javax.persistence.*;

@Entity
@Table(name = "reserved_books")
public class ReservedBook {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "book_id")
    private Book book;

    // Contructors
    public ReservedBook(){}

    public ReservedBook(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    // Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "ReservedBook{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                '}';
    }
}
