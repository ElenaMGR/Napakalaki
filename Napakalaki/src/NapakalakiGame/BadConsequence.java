/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Elena María Gómez Ríos, Jose Luis Martínez Ortiz
 */
public abstract class BadConsequence {
    
    static final int MAXTREASURES = 10;
    
    private String text;            //Representa lo que dice un mal rollo
    private int levels;             //Representa los niveles que se pierden    
 
    //Constructores
    public BadConsequence (String t, int l){
        text=t;
        levels=l;
    }
    

    //Métodos Get
    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }


    
    /**
     * Actualiza el mal rollo para que el tesoro visible t no forme parte del mismo.
     * @param t Tesoro que se elimina.
     */
    public abstract void substracVisibleTreasure(Treasure t);
    
    /**
     * Actualiza el mal rollo para que el tesoro oculto t no forme parte del mismo.
     * @param t tesoro que se elimine
     */
    public abstract void substracHiddenTreasure(Treasure t);
    
    
    /**
     * Devuelve true cuando el mal rollo que tiene que cumplir el jugador está 
     * vacío, eso significa que el conjunto de atributos del mal rollo indica
     * que no se pierden tesoros.
     * @return true si esta vacio, false en caso contrario.
     */
    public abstract boolean isEmpty();
    
    /**
     * Ajusta el mal rollo de un monstruo a la posibilidad del jugador que tiene
     * que cumplirlo.
     * @param v lista de tesoros visibles del jugador
     * @param h lista de tesoros ocultos del jugador.
     * @return 
     */
    public abstract BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v,ArrayList<Treasure> h);
    
    /**
     * Método que muestra el estado de BadConsequence
     * @return un string con el estado.
     */
    @Override
    public String toString(){
        return "BadConsequence = " + text +"\n" +
                "   levels = " + Integer.toString(levels) + "\n";
    }
}
