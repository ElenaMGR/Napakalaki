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
        players = new ArrayList();
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
    
    //Decide qué jugador es el siguiente en jugar
    private Player nextPlayer(){
        int next;
        //Player next_player;
        if(currentPlayer.getName().equals("")){ // Si es la primera jugada
           next = (int) (Math.random()*players.size() - 1);
        }else{
            next = 0;
            for(int i=0;i<players.size();i++){
                if(players.get(i).getName().equals(currentPlayer.getName())){
                   next = (i + 1) % (players.size());
                }
            }
            
        }
        Player next_player = players.get(next);
        return next_player;
    }
    
    /* Comprueba si el jugador activo cumple con las reglas del juego
       para poder terminar su turno.
       Devuelve false si el jugador activo no puede pasar de turno y 
       true en caso contrario. Si currentPlayer es null, devuelve true*/
    private boolean nextTurnAllowed(){
        if(currentPlayer == null){
            return true;
        }
        return currentPlayer.validState();
    }
    
    /*Se asigna un enemigo a cada jugador. Esta asignación se hace de forma aleatoria teniendo
    en cuenta que un jugador no puede ser enemigo de sí mismo*/
    private void setEnemies(){
        //Variable para saber si ya está asignado
        boolean asignado = false;
        //Numero del enemigo
        int pos_enemy;
        for(int i=0; i < players.size(); i++){
            while(!asignado){
                //Asigno el numero del enemigo de forma aleatoria
                pos_enemy = (int) (Math.random()*players.size());
                //Si el enemigo no es él mismo
                if(i != pos_enemy){
                    players.get(i).setEnemy(players.get(pos_enemy));
                    asignado = true;
                }
            }
            asignado = false;
        }
        
    }
    
    //Métodos públicos
    public static Napakalaki getInstance(){
        return instance;
    } 
    
    /**
     * Pasa el control al jugador actual para que lleve a cabo el combate con el 
     * monstruo que le ha tocado.
     * @return CombatResult
     */
    public CombatResult developCombat(){
        CombatResult combatResult = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        return combatResult;
    }
    
    /**
     * Elimina los tesoros visibles indicados en la lista de tesoros visibles
     * del jugador. Al eliminar esos tesoros se devuelven al mazo de tesoros.
     * @param treasures 
     */
    public void discardVisibleTreasures ( ArrayList<Treasure> treasures){
        
        for(Treasure treasure:treasures){
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    /**
     * Elimina los tesoros ocultos indicados en la lista de tesoros ocultos
     * del jugador. Al eliminar esos tesoros se devuelven al mazo de tesoros.
     * @param treasures 
     */
    public void discardHiddenTreasures ( ArrayList<Treasure> treasures){
        for(Treasure treasure:treasures){
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    /**
     * Se pide al jugador actual que pase tesoros ocultos a visibles.
     * @param treasures lista de tesoros que pasan de ocultos a visibles.
     */
    public void makeTreasuresVisible ( ArrayList<Treasure> treasures){
        for(Treasure t:treasures){
           currentPlayer.makeTreasureVisible(t);
        }
    }
    
    /**
     * Se encarga de solicitar a CardDealer la inicializacion de los mazos
     * de cartas de Tesoros y de Monstruos, de inicializar los jugadores
     * proporcionandoles un nombre, asignarle a cada jugador su enemigo y de 
     * iniciar el juego con la llamada nextTurn() para pasar al siguiente
     * turno.
     * @param players 
     */
    public void initGame (ArrayList<String> players){
        initPlayers(players);
        setEnemies();      
        dealer.initCards();
        nextTurn();
    }
    
    // Devuelve el jugador actual
    public Player getCurrentPlayer (){     
        return currentPlayer;
    }
    
    // Devuelve el mostrue en juego
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    /**
     * Usa el método nextTurnAllowed(), donde se verifíca si el jugador activo 
     * cumple con las reglas del juego para poder terminar su turno.
     * En caso de que nextTurnAllowed devuelva true, se le solicita a CardDeale el
     * siguiente monstruo al que se enfrentará ese jugador y se actualiza el jugador activo
     * al siguiente jugador.
     * En caso de que el nuevo jugador activo esté muerto, por el combate en su anterior turno o 
     * porque es el primer turno, se inicilian sus tesoros siguiendo las reglas del juego.
     * @return devuelve nextTurnAllowed()
     */
    public Boolean nextTurn(){
        boolean stateOK = nextTurnAllowed();
        boolean dead;
        if (stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            dead = currentPlayer.isDead();
            
            if (dead){
                currentPlayer.initTreasures();
            }
        }
        
        return stateOK;
    }
    
    /* Devuelve true si el parametro resutl es WINGAME, en caso contrario devuelve false */
    public boolean endOfGame (CombatResult result){
        return (result==CombatResult.WINGAME);
    }
    
}
