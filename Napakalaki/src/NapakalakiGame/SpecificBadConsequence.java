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
        boolean encontrado;
        
        // Hacemos una copia de los tipos en un axuliar jugador
        ArrayList<TreasureKind> jugador = new ArrayList();
        for (Treasure treasure: h){
            jugador.add(treasure.getType());
        }
        
        
        // Si el jugador tiene objetos ocultos
        if(!(h.isEmpty()) ){
               
            // Si son objetos especificos los buscamos y eliminamos    
            for(int i = 0; i< specificHiddenTreasures.size() ; i++){
                encontrado = false;
                for (int j = 0; j< jugador.size() && !encontrado ; j++){
                    if (specificHiddenTreasures.get(i).equals(jugador.get(j))){
                    
                        hidden.add(jugador.get(j));
                        jugador.remove(j);
                        encontrado = true;
                    }
                }
          
                
            }
                
        }
            
        
        // Hacemos una copia de los tipos en un axuliar jugador
        jugador.clear();
        for (Treasure treasure: v){
            jugador.add(treasure.getType());
        }
 
        // Si el jugador no tiene objetos visibles, no los puede perder
        if( !(v.isEmpty()) ){
           
            // Si son objetos especificos los buscamos y eliminamos
            for(int i = 0; i< specificVisibleTreasures.size() ; i++){
                encontrado = false;
                for (int j = 0; j< jugador.size() && !encontrado ; j++){
                    
                    if (specificVisibleTreasures.get(i).equals(jugador.get(j))){
                        visible.add(jugador.get(j));
                        jugador.remove(j);
                        encontrado = true;                 
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
