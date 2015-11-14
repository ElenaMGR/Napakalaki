/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import static java.lang.Math.random;

/**
 *
 * @author Elena María Gómez Ríos, Jose Luis Martínez Ortiz
 */
public class Dice {
    
    private static final Dice instance = new Dice();
    
    // El constructor privado asegura que no se puede instanciar
    // desde otras clases
    private Dice(){}
    
    public static Dice getInstance(){
        return instance;
    }
    
    //Genera un número aleatorio entre 1 y 6 
    public int nextNumber(){
        return (int) (random()*6 + 1);
    }
}
