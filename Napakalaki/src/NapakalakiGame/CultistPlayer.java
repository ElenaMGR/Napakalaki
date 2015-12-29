package NapakalakiGame;

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
        return 0;
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    private Treasure giveMeATreasure(){
        return null;
    }
    
    
    private boolean CanYouGiveMeATreasure(){
        return true;
    }
    
    public int getTotalCultistPlayers(){
        return 0;
    }
    
    
}
