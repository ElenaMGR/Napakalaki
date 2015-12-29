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
    // Constructor
    public NumericBadConsequence(String t, int l, int nVisible, int nHidden){
        super (t,l,nVisible,nHidden,new ArrayList(), new ArrayList(),false);
       
    }
    
    @Override
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v,ArrayList<Treasure> h){   
        int nHidden=0, nVisible=0;
        
        // Si el jugador tiene objetos ocultos
        if(!(h.isEmpty()) ){
          // Si el jugador tiene objetos ocultos, quitamos los que no posea
            int nHiddenT = super.getNHiddenTreasures();
            if(nHiddenT > 0){ // Si es un numero lo ajustamos
                if(nHiddenT > h.size()){
                    nHidden = h.size();
                }else{
                    nHidden = nHiddenT;
                }
            } 
        }
        
        
        // Si el jugador no tiene objetos visibles, no los puede perder
        if( !(v.isEmpty()) ){
            // Si el jugador tiene objetos ocultos, quitamos los que no posea
            int nVisibleT = super.getNHiddenTreasures();
            if(nVisibleT > 0){ // Si es un numero lo ajustamos
                if(nVisibleT > v.size()){
                    nVisible = v.size();
                }else{
                    nVisible= nVisibleT;
                }     
            }      
        }
        
        BadConsequence nuevo = new NumericBadConsequence(super.getText(), super.getLevels(), nHidden, nVisible);
        return nuevo;
    }
}
