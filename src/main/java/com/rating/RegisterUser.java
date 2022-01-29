package com.rating;

import javax.persistence.*;
import java.io.*;

@Entity(name = "et_user")
@Table(name = "et_user")
public class RegisterUser{

    @Id
    /* IDENTITY is used because I used SERIAL in postgreSQL database. */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @Column(name = "user_username")
    private String username;

    @Column(name = "user_password")
    private String password;

    public RegisterUser() {
        super();
    }

    /* Constructor*/
    public RegisterUser(String name, String surname, String username, String password){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    /* Getters and setters*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
