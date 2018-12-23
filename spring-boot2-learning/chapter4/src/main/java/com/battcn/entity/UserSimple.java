package com.battcn.entity;

/**
 * @author Levin
 * @since 2018/5/7 0007
 */
public class UserSimple {

    private Long id;
    private String username;


    // TODO  省略get set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public UserSimple() {
    }

    public UserSimple(String username) {
        this.username = username;
    }

    public UserSimple(Long id, String username) {
        this.id = id;
        this.username = username;
    }

}
