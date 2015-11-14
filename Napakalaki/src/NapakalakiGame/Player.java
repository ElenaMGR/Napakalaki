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
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){
        
    }
    
    private int getCombatLevel(){
        return level;
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
    
    private boolean canMakeTreasureVisible(Treasure t){
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
    
    public boolean validState(){
        return false;
    }
    
    public void initTreasures(){
        
    }
    
    public int getLevels(){
        return level;
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
