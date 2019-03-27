/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printsalesmanager;

import java.util.Calendar;


/**
 *
 * @author Xaereus
 */
public class Order{

    private Calendar dateOrdered, datePrinted, dateGiven, datePaid;

    private String customer;
    private String model;
    private String name;

    private int quantity; //Amount of this print

    /**
     *
     * @param dateOrdered
     * @param customer
     * @param model
     * @param quantity
     * @param name
     */
    public Order(Calendar dateOrdered, String customer, String model, int quantity, String name){
        this.dateOrdered = dateOrdered;
        this.customer = customer;
        this.model = model;
        this.quantity = quantity;
        this.name = name;
    }

    public Calendar getDateOrdered(){
        return dateOrdered;
    }

    public void setDateOrdered(Calendar dateOrdered){
        this.dateOrdered = dateOrdered;
    }

    public Calendar getDatePrinted(){
        return datePrinted;
    }

    public void setDatePrinted(Calendar datePrinted){
        this.datePrinted = datePrinted;
    }

    public Calendar getDateGiven(){
        return dateGiven;
    }

    public void setDateGiven(Calendar dateGiven){
        this.dateGiven = dateGiven;
    }

    public Calendar getDatePaid(){
        return datePaid;
    }

    public void setDatePaid(Calendar datePaid){
        this.datePaid = datePaid;
    }

    public String getCustomer(){
        return customer;
    }

    public void setCustomer(String customer){
        this.customer = customer;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getProfit(){
        return "WIP";
    }

}
