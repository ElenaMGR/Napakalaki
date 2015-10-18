/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

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
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    //Constructores
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text=text;
        this.levels=levels;
        nVisibleTreasures=nVisible;
        nHiddenTreasures=nHidden;
        death=false;
        specificHiddenTreasures=null;
        specificVisibleTreasures=null;
    }
    public BadConsequence(String text, boolean death){
        this.text=text;
        this.death=death;
        specificHiddenTreasures=null;
        specificVisibleTreasures=null;
        nVisibleTreasures=0;
        nHiddenTreasures=0;
        levels=0;
    }
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden){
        this.text=text;
        this.levels=levels;
        specificHiddenTreasures=tHidden;
        specificVisibleTreasures=tVisible;
        nVisibleTreasures=specificVisibleTreasures.size();
        nHiddenTreasures=specificHiddenTreasures.size();
        death=false;
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
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    //Método que muestra el estado de BadConsequence
    @Override
    public String toString(){
        return "Text = " + text + " , levels = " + Integer.toString(levels) + " , nVisibleTreasures = " +
                Integer.toString(nVisibleTreasures) + " , nHiddenTreasures = " + Integer.toString(nHiddenTreasures) +
                " , death = " + Boolean.toString(death) + " , specificHiddenTreasures = " +
                specificHiddenTreasures + " , specificVisibleTreasures = " +
                specificVisibleTreasures;
    }
}
