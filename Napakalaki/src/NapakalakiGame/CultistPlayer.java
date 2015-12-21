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

    private static final int totalCultistPlayers =0;
    
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c) {
        super(p.getName());
    }
    
    protected int getCombatLevel(){
        return 0;
    }
    
    protected int getOponentLevel(){
        return 0;
    }
    
    protected boolean shouldConvert(){
        return true;
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
