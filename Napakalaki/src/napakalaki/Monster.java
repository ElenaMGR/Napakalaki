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

    //Constructor
    public Monster(String name, int combatLevel) {    
        this.name = name;
        this.combatLevel = combatLevel;
    }

    //Métodos get
    public String getName() {
        return name;
    }
    public int getCombatLevel(){
        return combatLevel;
    }
}
