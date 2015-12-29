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
public class NumericBadConsequence extends BadConsequence {
    
    private int nVisibleTreasures;  //Representa el número de tesoros visibles que se pierden
    private int nHiddenTreasures;   //Representa el número de tesoros ocultos que se pierden
    
    
    // Constructor
    public NumericBadConsequence(String t, int l, int nVisible, int nHidden){
        super (t,l);
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    
    // Métodos get y set
    
    public int getNVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getNHiddenTreasures() {
        return nHiddenTreasures;
    }
    
    
    
    @Override
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v,ArrayList<Treasure> h){   
        int nHidden=0, nVisible=0;
        
        // Si el jugador tiene objetos ocultos
        if(!(h.isEmpty()) ){
          // Si el jugador tiene objetos ocultos, quitamos los que no posea
            if(nHiddenTreasures > 0){ // Si es un numero lo ajustamos
                if(nHiddenTreasures > h.size()){
                    nHidden = h.size();
                }else{
                    nHidden = nHiddenTreasures;
                }
            } 
        }
        
        
        // Si el jugador no tiene objetos visibles, no los puede perder
        if( !(v.isEmpty()) ){
            // Si el jugador tiene objetos ocultos, quitamos los que no posea
            if(nVisibleTreasures > 0){ // Si es un numero lo ajustamos
                if(nVisibleTreasures > v.size()){
                    nVisible = v.size();
                }else{
                    nVisible= nVisibleTreasures;
                }     
            }      
        }
        
        BadConsequence nuevo = new NumericBadConsequence(super.getText(), super.getLevels(), nHidden, nVisible);
        return nuevo;
    }
    
    @Override
    public void substracHiddenTreasure(Treasure t){
        // Si es un numero se reduce en 1
        nHiddenTreasures--;
 
    }
    
    
    @Override
    public void substracVisibleTreasure(Treasure t){
        // Si es un numero se reduce en 1
        nVisibleTreasures--;
 
    }
    
    @Override
    public boolean isEmpty(){
        boolean vacio = false;
        if((nVisibleTreasures==0) && (nHiddenTreasures==0)){
            vacio=true;
        }
        return vacio;
    }
    
    @Override
    public String toString(){
        return super.toString()+ 
            "   nVisibleTreasures = " +Integer.toString(nVisibleTreasures) + "  nHiddenTreasures = " + Integer.toString(nHiddenTreasures) +"\n";
              
    }
    
}
