/*
This object is used both for creating and deleting books. This gets passed to the form.
 */

package com.project.library.entities.FormObjects;

public class BookFormObject {
    int itemId; // an actual itemId when adding books, and bookID when removing books
    int numBooks; // not used when removing books

    public BookFormObject(){}

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getNumBooks() {
        return numBooks;
    }

    public void setNumBooks(int numBooks) {
        this.numBooks = numBooks;
    }
}
