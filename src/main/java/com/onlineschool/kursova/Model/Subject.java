package com.onlineschool.kursova.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
@Entity
@Table(name="subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="PERSON_SEQ", sequenceName="PERSON_SEQ",allocationSize=1)
    public int sub_id;

    public String name;

    public Date date;

    @ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.EAGER)
    @JoinTable(
            name = "Subject_User",
            joinColumns = { @JoinColumn(name = "subjecr_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    public Set<User> user= new HashSet<>();

    public Subject() {
    }

    public Subject(String name, Date date) {
        this.name=name;
        this.date=date;
    }

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}