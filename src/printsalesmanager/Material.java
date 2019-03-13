/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printsalesmanager;


/**
 *
 * @author Xaereus
 */
public class Material{

    private final String name;
    private final int temp; // in Celsius
    private final double metersPerKilo;

    public Material(String name, int temp, double metersPerKilo){
        this.name = name;
        this.temp = temp;
        this.metersPerKilo = metersPerKilo;
    }

    public String getName(){
        return name;
    }

    public int getTemp(){
        return temp;
    }

    public double getMetersPerKilo(){
        return metersPerKilo;
    }

    /**
     * Finds the weight of a given length of this <tt>Material</tt>.
     *
     * @param length The length of this <tt>Material</tt> in meters.
     *
     * @return The weight of the given length.
     */
    public double lengthKilos(double length){
        return metersPerKilo / length;
    }

}
