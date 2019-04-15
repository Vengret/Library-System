/*
This object is used just to capture data from the review form because html is only passing ints and strings when I need a float value
 */

package com.project.library.entities.FormObjects;

public class ReviewFormObject {
    private int value;
    private String content;

    public ReviewFormObject(){}

    public ReviewFormObject(int value, String content) {
        this.value = value;
        this.content = content;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
