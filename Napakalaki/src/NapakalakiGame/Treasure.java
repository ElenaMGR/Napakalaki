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
public class Treasure {
    
    private String name;
    private int bonus; 
    private TreasureKind type;
    
    // Constructores
    public Treasure(String n, int bonus,TreasureKind t){
        name        = n;
        this.bonus  = bonus;
        type        = t;
    }
    
    //Métodos get
    public String getName(){
        return name;
    }
    
    public int getBonus(){
        return bonus;
    }
    
    public TreasureKind getType(){
        return type;
    }  
    
}
