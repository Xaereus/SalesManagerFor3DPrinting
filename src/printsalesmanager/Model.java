/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printsalesmanager;

import java.util.ArrayList;


/**
 * A collection of pieces that comprise a model. EX:
 Model legoman = legoleg * 2, legoarm * 2, legobody, legohead
 *
 * @author Xaereus
 */
public class Model{

    //Replace with a Map<Print, Integer> for quantities to be stored in the model instead.
    private final ArrayList<Piece> pieces; //TODO: Replace with getPrints method
    private String name;

    public Model(ArrayList<Piece> pieces, String name){
        this.pieces = pieces;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    /**
     * Calculates the time needed to fully print this model based on the
     * <tt>Print</tt>s that it holds.
     *
     * @return The time necessary to print the entire model.
     */
    public int getTime(){
        int time = 0;
        time = pieces.stream().map((piece) -> piece.getTime()).reduce(time, Integer::sum);
        return time;
    }

}
