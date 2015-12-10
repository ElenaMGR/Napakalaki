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
        nVisibleTreasures=MAXTREASURES;
        nHiddenTreasures=MAXTREASURES;
        levels=Player.MAXLEVEL;
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
    
    
    /**
     * Actualiza el mal rollo para que el tesoro visible t no forme parte del mismo.
     * @param t Tesoro que se elimina.
     */
    public void substracVisibleTreasure(Treasure t){
        if(nVisibleTreasures != 0){ // Si es un numero se reduce en 1
            nVisibleTreasures--;
        }else{ // Si es un tesoro especifico se elimina
            specificVisibleTreasures.remove(t.getType());
        }
    }
    
    /**
     * Actualiza el mal rollo para que el tesoro oculto t no forme parte del mismo.
     * @param t tesoro que se elimine
     */
    public void substracHiddenTreasure(Treasure t){
        if(nHiddenTreasures != 0){ // Si es un numero se reduce en 1
            nHiddenTreasures--;
        }else{ // Si es un tesoro especifico se elimina
            specificHiddenTreasures.remove(t.getType());
        }
    }
    
    
    /**
     * Devuelve true cuando el mal rollo que tiene que cumplir el jugador está 
     * vacío, eso significa que el conjunto de atributos del mal rollo indica
     * que no se pierden tesoros.
     * @return true si esta vacio, false en caso contrario.
     */
    public boolean isEmpty(){
        boolean vacio = false;
        if((nVisibleTreasures==0) && (nHiddenTreasures==0) && 
                (specificHiddenTreasures.isEmpty()) && (specificVisibleTreasures.isEmpty())){
            vacio=true;
        }
        return vacio;
    }
    
    /**
     * Ajusta el mal rollo de un monstruo a la posibilidad del jugador que tiene
     * que cumplirlo.
     * @param v lista de tesoros visibles del jugador
     * @param h lista de tesoros ocultos del jugador.
     * @return 
     */
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v,ArrayList<Treasure> h){      
        // Si el jugador no tiene objetos ocultos, no los puede perder
        if(h.isEmpty()){
            specificHiddenTreasures.clear();
            nHiddenTreasures = 0;
        }else{  // Si el jugador tiene objetos ocultos, quitamos los que no posea
            if(nHiddenTreasures > 0){ // Si es un numero lo ajustamos
                if(nHiddenTreasures > h.size()){
                    nHiddenTreasures = h.size();
                }
                
            }else{ // Si son objetos especificos los buscamos y eliminamos
                ArrayList<TreasureKind> aux = new ArrayList();
                for(Treasure treasure: h){
                    if(specificHiddenTreasures.contains(treasure.getType())){
                        aux.add(treasure.getType());
                    }
                }
                specificHiddenTreasures.clear();
                specificHiddenTreasures=aux;
            }
            
        }
        
        
        // Si el jugador no tiene objetos visibles, no los puede perder
        if( v.isEmpty() ){
            specificVisibleTreasures.clear();
            nVisibleTreasures = 0;
        }else{  // Si el jugador tiene objetos ocultos, quitamos los que no posea
            if(nVisibleTreasures > 0){ // Si es un numero lo ajustamos
                if(nVisibleTreasures > v.size()){
                    nVisibleTreasures = v.size();
                }
                
            }else{ // Si son objetos especificos los buscamos y eliminamos
                ArrayList<TreasureKind> aux = new ArrayList();
                for(Treasure treasure: v){
                    if(specificVisibleTreasures.contains(treasure.getType())){
                        aux.add(treasure.getType());
                    }
                }
                specificVisibleTreasures.clear();
                specificVisibleTreasures=aux;
            }
            
        }
        
        return this;
    }
    
    /**
     * Método que muestra el estado de BadConsequence
     * @return un string con el estado.
     */
    @Override
    public String toString(){
        return "BadConsequence = " + text +"\n" +
                "   levels = " + Integer.toString(levels) + "   death = " + Boolean.toString(death)+"\n"+
                "   nVisibleTreasures = " +Integer.toString(nVisibleTreasures) + "  nHiddenTreasures = " + Integer.toString(nHiddenTreasures) +"\n"+
                "   specificVisibleTreasures = " + specificVisibleTreasures + "   specificHiddenTreasures = " + specificHiddenTreasures+"\n";
    }
}
