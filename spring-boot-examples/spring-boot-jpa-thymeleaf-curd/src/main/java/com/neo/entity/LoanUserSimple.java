package com.neo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Data
public class LoanUserSimple implements Serializable {
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

