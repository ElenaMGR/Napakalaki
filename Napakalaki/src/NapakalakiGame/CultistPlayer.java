package NapakalakiGame;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elena María Gómez Ríos, Jose Luis Martínez Ortiz
 */
public class CultistPlayer extends Player {

    private static int totalCultistPlayers = 0;
    
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c) {
        super(p);
        totalCultistPlayers++;
        myCultistCard = c;
        
    }
    
    @Override
    protected int getCombatLevel(){
        int combatL = super.getCombatLevel();
        combatL += combatL*0.2 + myCultistCard.getGainedLevels() * totalCultistPlayers;
        return combatL;
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    /**
     * Devuelve un tesoro elegido al azar de entre los tesoros visibles del jugador
     * @return el tesoro que se devuelve
     */
    @Override
    protected Treasure giveMeATreasure(){
        Treasure tesoro;
        ArrayList<Treasure> visibleT = super.getVisibleTreasures();
        //Genero un número aletorio
        int num=(int) (Math.random()*visibleT.size());
        //Elijo el tesoro a devolver
        tesoro = visibleT.get(num);
        //Elimino el tesoro
        super.discardVisibleTreasure(tesoro);
        return tesoro;
    }
    
    /**
     * Devuelve true si el jugador tiene tesoros para ser robados por otro 
     * jugador y false en caso contrario.
     * 
     */
    @Override
    protected boolean canYouGiveMeATreasure(){
        return !(super.getVisibleTreasures().isEmpty());
    }
    
    public int getTotalCultistPlayers(){
        return 0;
    }
    
    
}
