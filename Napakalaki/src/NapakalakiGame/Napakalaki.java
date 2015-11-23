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
public class Napakalaki {
    
    private static final Napakalaki instance = new Napakalaki();
    
    //Atributos de referencia
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer;
    
    //El constructor privado asegura que no se puede instancia
    //desde otras clases
    private Napakalaki(){ 
        currentPlayer = null;
        players = null;
        dealer = CardDealer.getInstace();
    }
    
    
    //Métodos privados
    
    /* Inicializa el array de jugadores, creando tantos jugadores como
       elementos hay en names
    */
    private void initPlayers (ArrayList<String> names){
        for (int i=0; i<names.size(); i++)
            players.add(new Player(names.get(i)));
    }
    
    private Player nextPlayer(){
        return players.get(0);
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
        CombatResult combatResult = null;
        return combatResult;
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
        return currentPlayer;
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
