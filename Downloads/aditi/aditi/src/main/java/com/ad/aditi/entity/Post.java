package com.ad.aditi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post", uniqueConstraints = {@UniqueConstraint(columnNames = {"posts"})})
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(name = "posts", nullable = false)
    String Title;
    @Column(name = "description", nullable = false)
    String description;
    @Column(name = "content", nullable = false)
    String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post() {
        super();
        this.id = id;
        this.Title = Title;
        this.description = description;
        this.content = content;
    }

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval =
            true)
    private Set<Comment> comments = new HashSet<>();
}


