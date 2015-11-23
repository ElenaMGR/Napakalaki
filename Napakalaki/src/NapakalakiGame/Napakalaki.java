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
    private Monster currentMonster;
    private CardDealer dealer;
    
    //El constructor privado asegura que no se puede instancia
    //desde otras clases
    private Napakalaki(){
        currentPlayer = new Player("");
       //players = null;
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
        int next;
        //Player next_player;
        if(currentPlayer.getName().equals("")){ // Si es la primera jugada
           next = (int) (Math.random()*players.size() - 1);
        }else{
            next = 0;
            for(int i=0;i<players.size();i++){
                if(players.get(i).getName().equals(currentPlayer.getName())){
                   next = (i + 1) % (players.size()- 1);
                }
            }
        }
        Player next_players = players.get(next);
        return next_players;
    }
    
    // Comprueba si el jugador activo cumple con las reglas del juego para poder terminar su turno
    private Boolean nextTurnAllowed(){
        return currentPlayer.validState();
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
    
    // Devuelve el jugador actual
    public Player getCurrentPlayer (){     
        return currentPlayer;
    }
    
    // Devuelve el mostrue en juego
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public Boolean nextTurn(){
        return true;
    }
    
    public Boolean endOfGame (CombatResult result){
        return true;
    }
    
}
