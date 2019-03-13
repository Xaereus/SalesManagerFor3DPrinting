/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printsalesmanager;

import java.util.Date;


/**
 *
 * @author Xaereus
 */
public class Order{

    private Date dateOrdered, datePrinted, dateGiven, datePaid;

    // Might remove the customer name. Keeping it would allow for using the 
    // orders to sort the table, rather than searching through the customers.
    private String customer;
    private final Model product;
    private final int quantity; //Amount of this print

    public Order(Date dateOrdered, String customer, Model product, int quantity){
        this.dateOrdered = dateOrdered;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public Date getDateOrdered(){
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered){
        this.dateOrdered = dateOrdered;
    }

    public Date getDatePrinted(){
        return datePrinted;
    }

    public void setDatePrinted(Date datePrinted){
        this.datePrinted = datePrinted;
    }

    public Date getDateGiven(){
        return dateGiven;
    }

    public void setDateGiven(Date dateGiven){
        this.dateGiven = dateGiven;
    }

    public Date getDatePaid(){
        return datePaid;
    }

    public void setDatePaid(Date datePaid){
        this.datePaid = datePaid;
    }

    public String getCustomer(){
        return customer;
    }

    public void setCustomer(String customer){
        this.customer = customer;
    }

}
