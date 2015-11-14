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
public class CardDealer {
    
    private static final CardDealer instance = new CardDealer();
    
    //Atributos de referencia
    ArrayList<Monster> unusedMonsters;
    ArrayList<Monster> usedMonsters;
    ArrayList<Treasure> unusedTreasures;
    ArrayList<Treasure> usedTreasures;
    
    //El constructor privado asegura que no se puede instanciar
    //desde otras clases
    private CardDealer () {}
    
    public static CardDealer getInstace(){
        return instance;
    }
    
    //Métodos privados
    private void initTreasureCardDeck() {
        
    }
    
    private void initMonsterCardDeck() {
        
    }
    
    private void shuffleTreasures(){
        
    }
    
    private void shuffleMonster(){
        
    }
    
    //Métodos públicos
    public Treasure nextTreasure(){
        return usedTreasures.get(0);
    }
    
    public Monster nextMonster(){
        return usedMonsters.get(0);
    }
    
    public void giveTreasureBack(Treasure t){
        
    }
    
    public void giveMonsterBack(Monster m){
        
    }
    
    public void initCards(){
        
    }
    
}
