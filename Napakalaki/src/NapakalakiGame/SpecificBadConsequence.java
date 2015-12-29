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
public class SpecificBadConsequence extends BadConsequence{
    // Constructor
    public SpecificBadConsequence(String t, int l, ArrayList<TreasureKind> v,
            ArrayList<TreasureKind> h){
        
        super (t,l,0,0,v, h,false);

    }
    
    @Override
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v,ArrayList<Treasure> h){   
        ArrayList<TreasureKind> hidden = new ArrayList();
        ArrayList<TreasureKind> visible = new ArrayList();
        
        // Si el jugador tiene objetos ocultos
        if(!(h.isEmpty()) ){
            // Si son objetos especificos los buscamos y eliminamos
            for(Treasure treasure: h){
                if(super.getSpecificHiddenTreasures().contains(treasure.getType())){
                        hidden.add(treasure.getType());
                }
            }
                
        }
            
 
        // Si el jugador no tiene objetos visibles, no los puede perder
        if( !(v.isEmpty()) ){
            // Si son objetos especificos los buscamos y eliminamos
            for(Treasure treasure: v){
                if(super.getSpecificVisibleTreasures().contains(treasure.getType())){
                    visible.add(treasure.getType());
                }
            }
        }
        
            
        BadConsequence nuevo = new SpecificBadConsequence(super.getText(), super.getLevels(), visible, hidden);

        return nuevo;
    }
}
