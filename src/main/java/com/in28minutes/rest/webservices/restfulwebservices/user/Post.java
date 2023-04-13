package com.in28minutes.rest.webservices.restfulwebservices.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Optional;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer Id;

    @Size(min = 10)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return Id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
