/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printsalesmanager;

import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author Xaereus
 */
public class Customer{

    private String name;
    private final ArrayList<Order> orders;
    private double balance;

    public Customer(String name, double balance){
        this.name = name;
        this.orders = new ArrayList<>();
        this.balance = balance;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    /**
     *
     * @return An unmodifiable <tt>ArrayList</tt> of this <tt>Customer</tt>'s
     * <tt>Order</tt>s.
     */
    public ArrayList<Order> getOrders(){
        return (ArrayList<Order>)Collections.unmodifiableList(this.orders);
    }

    /**
     * Appends an <tt>Order</tt> onto this <tt>Customer</tt>'s order list.
     *
     * @param order
     */
    public void addOrder(Order order){
        this.orders.add(order);
    }

    /**
     * Removes an <tt>Order</tt> from this <tt>Customer</tt>'s order list.
     *
     * @param order The order to remove from this Customer
     */
    public void delOrder(Order order){
        this.orders.remove(order);
    }

    public double getBalance(){
        return balance;
    }

    /**
     * Sets this <tt>Customer</tt>'s balance to this amount.
     *
     * @param balance Amount to set the balance to. Negative values work.
     */
    public void setBalance(int balance){
        this.balance = balance;
    }

    /**
     * Modifies the balance by the given amount.
     *
     * @param amount The amount to be added or subtracted. Make negative to
     * subtract.
     */
    public void addBalance(int amount){
        this.balance += amount;
    }

}
