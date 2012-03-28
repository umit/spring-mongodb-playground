package com.umitunal.domain;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: uunal
 * Date: 3/27/12
 * Time: 2:33 PM
 */
public class ProductComment {

    private Date postedAt;
    private String author;
    private String email;
    private String content;

    public ProductComment() {
    }

    public ProductComment(Date postedAt, String author, String email, String content) {
        this.postedAt = postedAt;
        this.author = author;
        this.email = email;
        this.content = content;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
