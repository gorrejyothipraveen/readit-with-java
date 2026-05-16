package com.tw.domain.repositories;

import org.springframework.stereotype.Repository;import java.util.Objects;

@Repository
public class Post {

    private final String author;
    private final String title;
    private final String date;
    private final String content;

    public Post(String author, String title, String date, String content) {
        this.author = author;
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(author, post.author) && Objects.equals(title, post.title) && Objects.equals(date, post.date) && Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, date, content);
    }
}
