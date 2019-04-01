/*
This class is used in conjunction with Review class.
Because review class has an composite primary key, it will use @EmbeddedId annotation
That embedded id will point to this entity
 */

package com.project.library.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReviewId implements Serializable {
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "item_id")
    private Item item;


    // Constructors

    public ReviewId(){}

    public ReviewId(User user, Item item) {
        this.user = user;
        this.item = item;
    }

    // Getters and setters


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

    @Override
    public String toString() {
        return "ReviewId{" +
                "user=" + user +
                ", item=" + item +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewId reviewId = (ReviewId) o;
        return Objects.equals(user, reviewId.user) &&
                Objects.equals(item, reviewId.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, item);
    }
}
