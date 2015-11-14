/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Elena María Gómez Ríos, Jose Luis Martínez Ortiz
 */
public class Napakalaki {
    
    private static final Napakalaki instance = new Napakalaki();
    
    //El constructor privado asegura que no se puede instancia
    //desde otras clases
    private Napakalaki(){ }
    
    
    //Métodos privados
    private void initPlayers (String[] names){
        
    }
    
    private Player nextPlayer(){
        Player p = new Player();
        return p;
    }
    
    private Boolean nextTurnAllowed(){
        return true;
    }
    
    private void setEnemies(){
        
    }
    
    //Métodos públicos
    public static Napakalaki getInstance(){
        return instance;
    } 
    
    public CombatResult developCombat(){
        CombatResult cr = null;
        return cr;
    }
    
    public void discardVisibleTreasures ( ArrayList<Treasure> treasures){
        
    }
    
    public void discardHiddenTreasures ( ArrayList<Treasure> treasures){
        
    }
    
    public void makeTreasuresVisible ( ArrayList<Treasure> treasures){
        
    }
    
    public void initGame (String[] players){
        
    }
    
    public Player getCurrentPlayer (){
        Player p = new Player();
        return p;
    }
       
    public Monster getCurrentMonster(){
        Monster m = null;
        return m;
    }
    
    public Boolean nextTurn(){
        return true;
    }
    
    public Boolean endOfGame (CombatResult result){
        return true;
    }
    
}
