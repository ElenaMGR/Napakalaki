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
    private BadConsequence bc;
    private Prize price;

    //Constructor
    public Monster(String name, int level, BadConsequence bc, Prize price) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.bc = bc;
        this.price = price;
    }

    //Métodos get
    public String getName() {
        return name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    //Métodos
    @Override
    public String toString() {
        return "Name = " + name + " CombatLevel = " + Integer.toString(combatLevel)
                + " Pride :" + price.toString() + " BadConsequence =" + bc.toString();
    }
}
