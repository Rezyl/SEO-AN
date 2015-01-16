package com.ppro.spring.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 6.11.14
 */
@Entity
@Table (name = "user_table")
public class UserTable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userID;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
