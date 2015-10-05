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
public class BadConsequence {
    private String text;            //Representa lo que dice un mal rollo
    private int levels;             //Representa los niveles que se pierden    
    private int nVisibleTreasures;  //Representa el número de tesoros visibles que se pierden
    private int nHiddenTreasures;   //Representa el número de tesoros ocultos que se pierden
    private boolean death;          //Representa un mal rollo de tipo muerte
    
    //Constructores
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text=text;
        this.levels=levels;
        nVisibleTreasures=nVisible;
        nHiddenTreasures=nHidden;
    }
    public BadConsequence(String text, boolean death){
        this.text=text;
        this.death=death;
    }

    //Métodos Get
    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }

    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }

    public boolean isDeath() {
        return death;
    }
    
}
