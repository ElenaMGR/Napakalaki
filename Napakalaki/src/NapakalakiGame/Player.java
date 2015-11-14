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
public class Player {
    
    static final int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasure;
    
    private BadConsequence pendingBadConsequence;
    
    private Player enemy;
    
    
    public Player(String name){
        this.name=name;
        level=0;
        dead = true;
        canISteal = true;
        hiddenTreasures = new ArrayList();
        visibleTreasure = new ArrayList();
        pendingBadConsequence = null;
        enemy = null;
    }
    
    // Devuelve el nombre del jugador;
    public String getName(){
        return name;
    }
    
   // Devuelve la vida al jugador, modificando el atributo correspondiente
    private void bringToLife(){
        dead = false;
    }
    
    // Devuelve el nivel de combate del jugador. Que viene dado por
    // su nivel más los bonus que le proporcionan los tesoros que
    // tenga equipados
    private int getCombatLevel(){
        int combatLevel=level;
        for(Treasure ht : hiddenTreasures) {
            combatLevel += ht.getBonus();
        }
        return combatLevel;
    }
    
    // Incrementa el nivel del jugador en i niveles
    private void incrementLevels(int i){
        level += i;
    }
    
    // Decrementa el nivel del jugador en i niveles
    private void decrementLevels(int i){
        level -= i;
    }
    
    // Asigna el mal rollo al jugador
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m){
        
    }
    
    private void applyBadConsequence(Monster m){
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        return false;
    }
    
    // Devuelve el número de tesoros visibles de tipo tKind que tiene el jugador
    private int howManyVisibleTreasures(TreasureKind tKind){
        int numero=0;
        for (Treasure vt : visibleTreasure) {
            if(vt.getType() == tKind)
                numero++;
        }
        return numero;
    }
    
    // Cambia el estado de jugador a muerto, modificando el correspondiente
    // atributo. 
    private void dieIfNoTreasures(){
        if( hiddenTreasures.isEmpty() && visibleTreasure.isEmpty())
            dead = true;
    }
    
    // Devuelve true si el jugador está muerto, false en caso contrario
    public boolean isDead(){  
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasure;
    }
    
    public CombatResult combat(Monster m){
        CombatResult cr;
        return null;
    }
    
    public void makeTreasureVisible(Treasure t){
        
    }
    
    public void discardVisibleTreasure(Treasure t){
        
    }
    
    public void discardHiddenTreasure(Treasure t){
        
    }
    
    // Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir
    // y no tiene más de 4 tesoros  ocultos, y false en caso contrario.
    public boolean validState(){
        boolean state=false;
        if(pendingBadConsequence.isEmpty() && !(hiddenTreasures.size() > 4) )
            state = true;
        return state;
    }
    
    public void initTreasures(){
        
    }
    
    // Devuelve el nivel del jugador
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){
        return null;
    }
    
    // Asigna valor al atributo que referencia al enemigo del jugador
    public void setEnemy(Player enemy){
        this.enemy=enemy;
    }
    
    private Treasure giveMeATreasure(){
        return null;
    }
    
    // Indica si el jugador ha robado antes o no un tesoro a su enemigo.
    public boolean canISteal(){
        return canISteal;
    }
    
    // Devuelve true si el jugador tiene tesoros para ser robados
    // por otro jugador y false en caso contrario.
    private boolean canYouGiveMeATreasure(){
        boolean numTreasure=false;
        if(!hiddenTreasures.isEmpty())
            numTreasure=true;
        return numTreasure;
    }
    
    // Cambia el atributo canISteal a false cuando el jugador roba un tesoro
    private void haveStolen(){
        canISteal= false;
    }
    
    public void discardAllTreasures(){
        
    }
        
    
}
