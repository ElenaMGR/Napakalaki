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
class Player {
    
    static final int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    
    ArrayList<Treasure> hiddenTreasures;
    ArrayList<Treasure> visibleTreasure;
    
    private BadConsequence pendingBadConsequence;
    
    
    public Player(String name){
        this.name=name;
        dead = false;
        canISteal = false;
        
    }
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){
        
    }
    
    private int getCombatLevel(){
        return 1;
    }
    
    private void incrementLevels(int i){
        
    }
    
    private void decrementLevels(int i){
        
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        
    }
    
    private void applyPrize(Monster m){
        
    }
    
    private void applyBadConsequence(Monster m){
        
    }
    
    private boolean canMAkeTreasure(Treasure t){
        return false;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        return 0;
    }
    
    private void dieIfNoTreasures(){
        
    }
    
    public boolean IsDead(){
        return false;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return null;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return null;
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
    
    public boolean validState(){
        return false;
    }
    
    public void initTreasures(){
        
    }
    
    public int getLevels(){
        return 0;
    }
    
    public Treasure stealTreasure(){
        return null;
    }
    
    public void setEnemy(Player enemy){
        
    }
    
    private Treasure giveMeATreasure(){
        return null;
    }
    
    public boolean canISteal(){
        return false;
    }
    
    private boolean canYouGiveMeATreasure(){
        return false;
    }
    
    private void haveStolen(){
        
    }
    
    public void discardAllTreasures(){
        
    }
    
    
    
    
    
    
    
    
}
