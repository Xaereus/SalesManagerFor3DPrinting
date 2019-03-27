/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printsalesmanager;

import java.util.ArrayList;
import static printsalesmanager.MainWindow.DATAMAN;


/**
 *
 * @author Xaereus
 */
public class Customer{

    private String name;
    private double balance;

    public Customer(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
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

    /**
     * Gets all the orders for this customer.
     *
     * @return An ArrayList of orders
     */
    public ArrayList<Order> getOrders(){
        ArrayList<Order> o = new ArrayList<>();
        DATAMAN.getOrders().stream().filter((order) -> {
            return order.getCustomer().equals(getName());
        }).forEachOrdered((order) -> {
            o.add(order);
        });

        return o;
    }

}
