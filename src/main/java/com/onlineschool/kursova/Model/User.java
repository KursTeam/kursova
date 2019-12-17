package com.onlineschool.kursova.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Table for users from site
 */
@Entity
public class User {

    public User(int user_id, String user_name, int role_id, int age,String password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.role_id = role_id;
        Age = age;
        this.password = password;
    }



    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int user_id;

    /**
     * 
     */
    public String user_name;

    /**
     * 
     */
    public int role_id;

    /**
     * 
     */
    public int Age;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String password;
}