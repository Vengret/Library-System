/*
Book entity tracks each individual book
For example, if the library has 5 copies of the same book, there will be one item and five books creating a ManyToOne relationship
 */


package com.project.library.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book implements Serializable {
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = {CascadeType.ALL})
    private List<ReservedBook> reservedBookList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = {CascadeType.ALL})
    private List<CheckedOutBook> checkedOutBooks;

    // Constructors

    public Book(){}

    public Book(Item item, String status, String due_date, List<ReservedBook> reservedBookList, List<CheckedOutBook> checkedOutBooks) {
        this.item = item;
        this.status = status;
        this.due_date = due_date;
        this.reservedBookList = reservedBookList;
        this.checkedOutBooks = checkedOutBooks;
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

    public List<ReservedBook> getReservedBookList() {
        return reservedBookList;
    }

    public void setReservedBookList(List<ReservedBook> reservedBookList) {
        this.reservedBookList = reservedBookList;
    }

    public List<CheckedOutBook> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void setCheckedOutBooks(List<CheckedOutBook> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", item=" + item +
                ", status='" + status + '\'' +
                ", due_date='" + due_date + '\'' +
                ", reservedBookList=" + reservedBookList +
                ", checkedOutBooks=" + checkedOutBooks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(item, book.item) &&
                Objects.equals(status, book.status) &&
                Objects.equals(due_date, book.due_date) &&
                Objects.equals(reservedBookList, book.reservedBookList) &&
                Objects.equals(checkedOutBooks, book.checkedOutBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, status, due_date, reservedBookList, checkedOutBooks);
    }
}
