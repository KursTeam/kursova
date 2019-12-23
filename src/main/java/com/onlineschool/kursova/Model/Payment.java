package com.onlineschool.kursova.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * 
 */
@Entity
@Table(name="payments")
public class Payment {

    /**
     * Default constructor
     */
    public Payment() {
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    /**
     * 
     */
    @Id
    public int pay_id;

    /**
     * 
     */
    public int user_id;

    /**
     * 
     */
    public double Amount;

    /**
     * 
     */
    public int role_id;

    /**
     * 
     */
    public Date Date;

}