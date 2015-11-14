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
    
    //Devuelve el número de niveles ganados proporcionados por su buen rollo
    public int getLevelsGained(){
        return prize.getLevels();
    }
    
    //Devuelve el número de tesoros ganados proporcionados por su buen rollo
    public int getTreasuresGained(){
        return prize.getTreasures();
    }

    //Método que muestra el estado de Monster
    @Override
    public String toString() {
        return "Name = " + name + " --- CombatLevel = " + Integer.toString(combatLevel)
                + " --- Prize =" + prize.toString() + " --- BadConsequence =" + badConsequence.toString();
    }
}
