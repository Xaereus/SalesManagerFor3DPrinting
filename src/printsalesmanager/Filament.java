/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printsalesmanager;

import java.awt.Color;


/**
 * Stores the temperature the material melts at, the name, price per kilo, and
 * diameter in mm. EX:
 * Name = Amazon Basics Red PLA,
 * Material = PLA,
 * Price = 20,
 * Diameter = 1.75,
 * Color = RED
 *
 * @author Xaereus
 */
public class Filament{

    // TODO: Make automatically query a URL to gather the information, such as the price.
    private final String name;
    private final Material material;
    private double price; // $ per kg
    private final double diameter; // mm
    private final Color color;

    public Filament(String name, Material material, double price, double diameter, Color color){
        this.name = name;
        this.material = material;
        this.price = price;
        this.diameter = diameter;
        this.color = color;
    }

    public String getName(){
        return name;
    }

    public Material getMaterial(){
        return material;
    }

    public double getDiameter(){
        return diameter;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public Color getColor(){
        return color;
    }

    /**
     * Finds the price of a given length of this <tt>Filament</tt> in meters.
     *
     * @param meters The amount of meters of filament to find the price of.
     *
     * @return The price of the amount of meters given for this filament.
     */
    public double lengthPrice(double meters){
        return material.lengthKilos(meters) * this.price;
    }

}
