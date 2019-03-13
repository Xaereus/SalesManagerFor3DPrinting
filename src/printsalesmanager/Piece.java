/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printsalesmanager;

import java.util.Collections;
import java.util.Map;


/**
 *
 * @author Xaereus
 */
public class Piece{

    private String name;
    private double length; //length describes the meters of filament needed.
    private final boolean custom;
    private final Map<String, Integer> times; // <Name of the section, time taken>
    private final int quantity; //Amount of this piece in a full model
    //Later change amountPrinted to recognize preprinted parts in stock.
    private int amountPrinted; //The amount of this piece completed. Used in isPrinted
    private final Filament filament;

    public Piece(String name, double length, boolean custom, Map<String, Integer> times, int quantity, Filament filament){
        this.name = name;
        this.length = length;
        this.custom = custom;
        this.times = times;
        this.quantity = quantity;
        this.amountPrinted = 0;
        this.filament = filament;
    }

    /**
     * @return the name
     */
    public String getName(){
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @return the length
     */
    public double getLength(){
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(double length){
        this.length = length;
    }

    /**
     * @return the custom
     */
    public boolean isCustom(){
        return custom;
    }

    /**
     * @return the times
     */
    public Map<String, Integer> getTimes(){
        return Collections.unmodifiableMap(times);
    }

    public Integer getTime(){
        int time = 0;
        time = times.values().stream().map((t) -> t).reduce(time, Integer::sum);
        return time;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getAmountPrinted(){
        return amountPrinted;
    }

    public void setAmountPrinted(int amountPrinted){
        this.amountPrinted = amountPrinted;
    }

    /**
     *
     * @return Whether the print is completely printed out.
     */
    public boolean isPrinted(){
        return this.quantity == this.amountPrinted;
    }

    /**
     * Finds the price of this piece.
     *
     * @return the price of the piece.
     */
    public double getPrice(){
        return filament.lengthPrice(this.length); //length;
    }

}
