/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author Elena María Gómez Ríos, Jose Luis Martínez Ortiz
 */
public class Prize {
    private int treasures;
    private int levels;
    
    //Constructor
    public Prize(int t, int l){
        treasures=t;
        levels=l;
    }
    
    //Métodos get
    public int getTreasures(){
        return treasures;
    }
    public int getLevels(){
        return levels;
    }
    
    //Método que muestra el estado de Prize
    @Override
    public String toString(){
        return "Treasures = " + Integer.toString(treasures) + " , levels = " + Integer.toString(levels);
    }
    
}
