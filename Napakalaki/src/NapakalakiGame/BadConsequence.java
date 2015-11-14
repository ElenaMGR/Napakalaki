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
public class BadConsequence {
    
    static final int MAXTREASURES = 10;
    
    private String text;            //Representa lo que dice un mal rollo
    private int levels;             //Representa los niveles que se pierden    
    private int nVisibleTreasures;  //Representa el número de tesoros visibles que se pierden
    private int nHiddenTreasures;   //Representa el número de tesoros ocultos que se pierden
    private boolean death;          //Representa un mal rollo de tipo muerte
    
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    //Constructores
    public BadConsequence(String t, int l, int nVisible, int nHidden){
        text=t;
        levels=l;
        nVisibleTreasures=nVisible;
        nHiddenTreasures=nHidden;
        death=false;
        specificHiddenTreasures=new ArrayList();
        specificVisibleTreasures=new ArrayList();
    }
    public BadConsequence(String t, boolean death){
        text=t;
        this.death=death;
        specificHiddenTreasures=new ArrayList();
        specificVisibleTreasures=new ArrayList();
        nVisibleTreasures=0;
        nHiddenTreasures=0;
        levels=0;
    }
    public BadConsequence(String t, int l, ArrayList<TreasureKind> v,
            ArrayList<TreasureKind> h){
        text=t;
        levels=l;
        specificHiddenTreasures=h;
        specificVisibleTreasures=v;
        nVisibleTreasures=0;
        nHiddenTreasures=0;
        death=false;
    }

    //Métodos Get
    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }

    public int getNVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getNHiddenTreasures() {
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
    
    public void substracVisibleTreasure(Treasure t){}
    
    public void substracHiddenTreasure(Treasure t){}
    
    
    //Devuelve true cuando el mal rollo que tiene que cumplir el jugador está 
    //vacío, eso significa que el conjunto de atributos del mal rollo indica 
    //que no se pierden tesoros
    public boolean isEmpty(){
        boolean vacio = false;
        if(!death && (levels==0) && (nVisibleTreasures==0) && (nHiddenTreasures==0) && 
                (specificHiddenTreasures.isEmpty()) && (specificVisibleTreasures.isEmpty())){
            vacio=true;
        }
        return vacio;
    }
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v,ArrayList<Treasure> h){     
        return null;
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
