/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Elena María Gómez Ríos, Jose Luis Martínez Ortiz
 */
public class Prize {
    private int treasures;
    private int level;
    //Constructor
    public Prize(int treasures, int level){
        this.treasures=treasures;
        this.level=level;
    }
    //Métodos get
    public int getTreasures(){
        return treasures;
    }
    public int getLevel(){
        return level;
    }
    
    //Método que muestra el estado de Prize
    @Override
    public String toString(){
        return "Treasures = " + Integer.toString(treasures) + " , levels = " + Integer.toString(level);
    }
    
}
