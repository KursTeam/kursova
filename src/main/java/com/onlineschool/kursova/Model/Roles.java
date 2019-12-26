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
    public Roles(String name) {
        this.name=name;
    }
    @OneToMany( mappedBy ="roles" ,cascade = CascadeType.ALL)
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
    @Column(name = "name")
    public String name;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }
}