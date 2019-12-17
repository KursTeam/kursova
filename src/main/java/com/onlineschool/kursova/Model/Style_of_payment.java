package com.onlineschool.kursova.Model;

/**
 * 
 */
public class Style_of_payment {

    /**
     * Default constructor
     */
    public Style_of_payment() {
    }

    /**
     * 
     */
    public int pay_id;

    /**
     * 
     */
    public double Amount;

    /**
     * 
     */
    public int role_id;

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
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
}