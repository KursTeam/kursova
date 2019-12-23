package com.onlineschool.kursova.Model;

import javax.persistence.*;
import java.util.Set;

/**
 * 
 */
@Entity
@Table(name="roles")
public class Roles {

    /**
     * Default constructor
     */
    public Roles() {
    }
    @OneToMany(cascade = CascadeType.ALL)
    private Set<User> users;
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="PERSON_SEQ", sequenceName="PERSON_SEQ",allocationSize=1)
    public int role_id;

    /**
     * 
     */
    @Column(name = "role_name")
    public String Name;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}