package com.onlineschool.kursova.Model;


import javax.persistence.*;

@Entity
@Table(name="AuthenticationUserInfo")
public class AuthenticationUserInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="PERSON_SEQ")
    @SequenceGenerator(name="PERSON_SEQ", sequenceName="PERSON_SEQ",allocationSize=1)
    private int user_id;
    @Column(name = "name")
    private String name;
    private String password;
    private String role;
    private int age;
    public AuthenticationUserInfo() {
    }
    public AuthenticationUserInfo(String name, String password, String role) {
        this.name=name;
        this.password=password;
        this.role=role;
    }

    @Override
    public String toString() {
        return "AuthenticationUserInfo{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
