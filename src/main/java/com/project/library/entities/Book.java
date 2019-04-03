/*
Book entity tracks each individual book
For example, if the library has 5 copies of the same book, there will be one title and five books creating a ManyToOne relationship
 */


package com.project.library.entities;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "item_id")
    private Item item;

    // checked-in, reserved, in-stock. etc.
    // may be worth creating a status enum
    @Column(name = "status")
    private String status;

    // currently in string format, but should change to official Date datatype
    @Column(name = "due_date")
    private String due_date;

    // tracks condition of book
    // may be worth creating a condition enum
    @Column(name = "condition")
    private String condition;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ReservedBook> reservedBookList;

    // Constructors

    public Book(){}

    public Book(Item item, String status, String due_date, String condition, List<ReservedBook> reservedBookList) {
        this.item = item;
        this.status = status;
        this.due_date = due_date;
        this.condition = condition;
        this.reservedBookList = reservedBookList;
    }

    // getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<ReservedBook> getReservedBookList() {
        return reservedBookList;
    }

    public void setReservedBookList(List<ReservedBook> reservedBookList) {
        this.reservedBookList = reservedBookList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", item=" + item +
                ", status='" + status + '\'' +
                ", due_date='" + due_date + '\'' +
                ", condition='" + condition + '\'' +
                ", reservedBookList=" + reservedBookList +
                '}';
    }
}
