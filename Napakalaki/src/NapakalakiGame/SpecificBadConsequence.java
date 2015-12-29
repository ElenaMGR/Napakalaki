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
    
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    // Constructor
    public SpecificBadConsequence(String t, int l, ArrayList<TreasureKind> v,
            ArrayList<TreasureKind> h){
        
        super (t,l);
        specificVisibleTreasures = v;
        specificHiddenTreasures = h;
    }
    
    // Métodos get y set
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    
    
    @Override
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v,ArrayList<Treasure> h){   
        ArrayList<TreasureKind> hidden = new ArrayList();
        ArrayList<TreasureKind> visible = new ArrayList();
        
        int ntesoros;
        
        // Si el jugador tiene objetos ocultos
        if(!(h.isEmpty()) ){
            ntesoros = specificHiddenTreasures.size();
            // Si son objetos especificos los buscamos y eliminamos
            for(Treasure treasure: h){
               
                if(ntesoros > 0){ // Todavia quedan tesoros en el mal rollo
                    
                    if(specificHiddenTreasures.contains(treasure.getType())){
                        hidden.add(treasure.getType());
                        ntesoros--;
                    }
                }
                
            }
                
        }
            
 
        // Si el jugador no tiene objetos visibles, no los puede perder
        if( !(v.isEmpty()) ){
            ntesoros = specificVisibleTreasures.size();
            // Si son objetos especificos los buscamos y eliminamos
            for(Treasure treasure: v){
                
                if(ntesoros > 0){ // Todavia quedan tesoros en el mal rollo
                    
                    if(specificVisibleTreasures.contains(treasure.getType())){
                        visible.add(treasure.getType());
                        ntesoros--;
                    }
                }
            }
        }
        
            
        BadConsequence nuevo = new SpecificBadConsequence(super.getText(), super.getLevels(), visible, hidden);

        return nuevo;
    }
    
    @Override
    public void substracHiddenTreasure(Treasure t){
        //Si es un tesoro especifico se elimina
        specificHiddenTreasures.remove(t.getType());
    }
    
    @Override
    public void substracVisibleTreasure(Treasure t){
        //Si es un tesoro especifico se elimina
        specificVisibleTreasures.remove(t.getType());
    }
    
    @Override
    public boolean isEmpty(){
        boolean vacio = false;
        if((specificHiddenTreasures.isEmpty()) && (specificVisibleTreasures.isEmpty())){
            vacio=true;
        }
        return vacio;
    }
    
    /**
     * Método que muestra el estado de BadConsequence
     * @return un string con el estado.
     */
    @Override
    public String toString(){
        return super.toString()+ 
            "   specificVisibleTreasures = " + specificVisibleTreasures + "   specificHiddenTreasures = " + specificHiddenTreasures+"\n";
    }
}
