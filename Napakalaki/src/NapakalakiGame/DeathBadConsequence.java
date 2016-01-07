/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import static NapakalakiGame.BadConsequence.MAXTREASURES;

/**
 *
 * @author Elena María Gómez Ríos, Jose Luis Martínez Ortiz
 */
public class DeathBadConsequence extends NumericBadConsequence {
    
    
    // Constructor
    public DeathBadConsequence(String t){

        super (t,Player.MAXLEVEL,MAXTREASURES,MAXTREASURES);
        
    }
    
}
