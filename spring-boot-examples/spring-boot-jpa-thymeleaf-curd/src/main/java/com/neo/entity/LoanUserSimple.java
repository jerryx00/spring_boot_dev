package com.neo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class LoanUserSimple implements Serializable {
    private static final long serialVersionUID = 1L;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTelNum() {
        return telNum;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getSex() {
        return sex;
    }

    public String getCity() {
        return city;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    //
    private String name;
    //
    private String telNum;
    //身份证号
    private String idNumber;
    //性别 [1]-男;[2]-女
    private String sex;
    //
    private String city;
    //
    private String location;
    //
    private String email;
}

