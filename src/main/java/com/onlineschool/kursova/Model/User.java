package com.onlineschool.kursova.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Table for users from site
 */
@Table(name="users")
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="PERSON_SEQ", sequenceName="PERSON_SEQ",allocationSize=1)
    public int user_id;

    @Column(name="name")
    public String name;

    //   @Column(name = "role")
    @ManyToOne
    @JoinColumn(name="role_id", nullable=true)
    public Roles roles;

    @Column(name="age")
    public int age;

    @ManyToMany(mappedBy = "user")
    private Set<Subject> subjects = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
    public void setSubject(Subject subjects) {
        this.subjects.add(subjects);
    }



    public User( String name,String password, int age,Roles role) {

        this.name = name;
        this.age = age;
        this.password = password;
        this.roles=role;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return name;
    }

    public void setUser_name(String user_name) {
        this.name = user_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String password;

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                ", age=" + age +
                ", subjects=" + subjects +
                ", password='" + password + '\'' +
                '}';
    }

    public void setRole(String name, int id) {
        this.roles.name = name;
        this.roles.role_id=id;
    }
}