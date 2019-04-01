/*
Started as a simple join table, but added date field
The date field allows the user to see a complete history even if they've borrowed the same book multiple times
 */

package com.project.library.entities;

import javax.persistence.*;

@Entity
@Table(name = "borrowed_book")
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "item_id")
    private Item item;

    // should change to Date data type
    @Column(name = "date")
    private String date;


    // Constructors

    public BorrowedBook(){}

    public BorrowedBook(User user, Item item, String date) {
        this.user = user;
        this.item = item;
        this.date = date;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
                "id=" + id +
                ", user=" + user +
                ", item=" + item +
                ", date='" + date + '\'' +
                '}';
    }
}
