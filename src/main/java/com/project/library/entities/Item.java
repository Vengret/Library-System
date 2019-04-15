/*
Tracks individual items
**** Not to be confused with Book entity that tracks each copy of a book
* As of now, our only items are books, but that may be expanded in the future
* Used to be a Title object. Item seems more appropriate for future expansions
 */

package com.project.library.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
public class Item{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "cover")
    private String cover;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = {CascadeType.ALL})
    private List<Book> bookList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = {CascadeType.ALL})
    private List<BorrowedBook> borrowedBookList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reviewId.item", cascade = {CascadeType.ALL})
    private List<Review> reviewList;

    public Item(){}

    public Item(String cover, String title, String author, String genre, List<Book> bookList, List<BorrowedBook> borrowedBookList, List<Review> reviewList) {
        this.cover = cover;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookList = bookList;
        this.borrowedBookList = borrowedBookList;
        this.reviewList = reviewList;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<BorrowedBook> getBorrowedBookList() {
        return borrowedBookList;
    }

    public void setBorrowedBookList(List<BorrowedBook> borrowedBookList) {
        this.borrowedBookList = borrowedBookList;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", bookList=" + bookList +
                ", borrowedBookList=" + borrowedBookList +
                ", reviewList=" + reviewList +
                '}';
    }
}
