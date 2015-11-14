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
public class Monster {

    // Variables 
    private String name;
    private int combatLevel;
    private BadConsequence badConsequence;
    private Prize prize;

    //Constructor
    public Monster(String n, int l, BadConsequence b, Prize p) {
        name = n;
        combatLevel = l;
        badConsequence = b;
        prize = p;
    }

    //Métodos get
    public String getName() {
        return name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return badConsequence;
    }
    
    public int getLevelsGainad(){
        return prize.getLevels();// se arregla cuando se actualice la clase Prize
    }
    
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }

    //Método que muestra el estado de Monster
    @Override
    public String toString() {
        return "Name = " + name + " --- CombatLevel = " + Integer.toString(combatLevel)
                + " --- Pride =" + prize.toString() + " --- BadConsequence =" + badConsequence.toString();
    }
}
