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
        unusedTreasures = new ArrayList<Treasure>();
        unusedTreasures.add(new Treasure ("¡Sí mi amo!",4,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure ("Botas de investigación",3,TreasureKind.SHOE));
        unusedTreasures.add(new Treasure ("Capucha de Cthulhu",3,TreasureKind.HELMET));   
        unusedTreasures.add(new Treasure ("A prueba de babas",2,TreasureKind.ARMOR));   
        unusedTreasures.add(new Treasure ("Botas de lluvia ácida",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Casco minero",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure ("Ametralladora Thompson",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Camiseta de la UGR",1,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure ("Clavo de rail ferroviario",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Cuchillo de sushi arcano",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Fez alópodo",3,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure ("Hacha prehistórica",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("El aparato del Pr. Tesla",4,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure ("Gaita",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Insecticida",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Escopeta de 3 cañones",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Garabato místico",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("La rebeca metálica",2,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure ("Lanzallamas",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Necro-comicón",1,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Necronomicón",5,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Linterna a 2 manos",3,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Necro-gnomicón",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Necrotelecom",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure ("Mazo de los antiguos",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Necro-playboycón",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Porra preternatural",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Shogulador",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Varita de atizamiento",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Tentáculo de pega",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure ("Zapato deja-amigos",1,TreasureKind.SHOE));
        
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
