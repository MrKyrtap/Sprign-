package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by PatrykGrudnik on 12.03.2017.
 */
@Entity
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String title;

    public int getId() {
        return id;
    }

    public Name() {
    }

    public Name(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
