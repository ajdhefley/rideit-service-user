package com.github.ajdhefley.rideit.services.user.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="userid", nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer userId;

    @Column(name="username", nullable=false)
    private String username;

    @Column(name="password", nullable=false)
    private String password;

    public Integer getUserId() {
        return this.userId;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

}
