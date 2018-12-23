package com.neo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class UserSimple {
    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }
}
