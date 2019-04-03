/*
Each user's profile
 */

package com.project.library.entities;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "enabled")
    private int enabled;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "contact_preference")
    private String contactPreference;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "balance")
    private BigDecimal balance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<BorrowedBook> borrowedBookList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reviewId.user", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Review> reviewList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ReservedBook> reservedBookList;

    // Constructors

    public User(){
    }

    public User(@NotNull String username, @NotNull String password, @NotNull int enabled, String email, String phone, String contactPreference, String firstName, String lastName, BigDecimal balance, List<BorrowedBook> borrowedBookList, List<Review> reviewList, List<ReservedBook> reservedBookList) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        this.phone = phone;
        this.contactPreference = contactPreference;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.borrowedBookList = borrowedBookList;
        this.reviewList = reviewList;
        this.reservedBookList = reservedBookList;
    }

    // Getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactPreference() {
        return contactPreference;
    }

    public void setContactPreference(String contactPreference) {
        this.contactPreference = contactPreference;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<ReservedBook> getReservedBookList() {
        return reservedBookList;
    }

    public void setReservedBookList(List<ReservedBook> reservedBookList) {
        this.reservedBookList = reservedBookList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", contactPreference='" + contactPreference + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", balance=" + balance +
                ", borrowedBookList=" + borrowedBookList +
                ", reviewList=" + reviewList +
                ", reservedBookList=" + reservedBookList +
                '}';
    }
}
