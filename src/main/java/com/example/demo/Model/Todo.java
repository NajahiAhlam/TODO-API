package com.example.demo.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String content;
    private  Boolean done = false ;
    public Todo() {
    }
    public Todo(String content, Boolean done) {
        this.content = content;
        this.done = done;
    }
    public Long getId() {return id;}
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
    public Boolean isDone() {return done;}
    public void setDone(Boolean done) {this.done = done;}
}
