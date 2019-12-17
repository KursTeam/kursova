package com.onlineschool.kursova.Model;

import java.util.Date;

/**
 * 
 */
public class Subject {

    /**
     * Default constructor
     */
    public Subject() {
    }

    /**
     * 
     */
    public int sub_id;

    /**
     * 
     */
    public String Name;

    /**
     * 
     */
    public Date Date;

    /**
     * 
     */
    public int group_id;

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
}