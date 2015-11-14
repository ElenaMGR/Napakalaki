/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Collections;

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
    
    //Inicializa el mazo de cartas Tesoros (unusedTreasures)
    private void initTreasureCardDeck() {
        unusedTreasures = new ArrayList();
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
    
    //Inicializa el mazo de cartas de Mostruos (unusedMonsters)
    private void initMonsterCardDeck() {
        unusedMonsters = new ArrayList();
        BadConsequence badConsequence;
        Prize prize;
        ArrayList<TreasureKind> sht = new ArrayList();
        ArrayList<TreasureKind> svt = new ArrayList();
        
        /*****************************************************/
        sht = new ArrayList();
        svt = new ArrayList();
        sht.add(TreasureKind.ARMOR);
        svt.add(TreasureKind.ARMOR);
        badConsequence = new BadConsequence("Pierdes tu armadura visible y "
                + "otra oculta", 0, svt, sht);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.HELMET);
        badConsequence = new BadConsequence("Embobados con el lindo"
                + "primigenio te descartas de tu casco visible", 0, svt, new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.SHOE);
        badConsequence = new BadConsequence("El primordial bostezo"
                + "contagioso. Pierdes el calzado visible", 0, svt, new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        /*****************************************************/
        
        sht = new ArrayList();
        svt = new ArrayList();
        sht.add(TreasureKind.ONEHAND);
        svt.add(TreasureKind.ONEHAND);
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta"
                + " y te dejan caer en mitad del vuelo. Descarta 1 mano visible"
                + " y 1 mano oculta", 0, svt, sht);
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles" 
                , 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.ARMOR);
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, svt, new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.ARMOR);
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                + " Descarta la armadura visible", 0, svt, new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros "
                + "visibles", 5, 3, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("Toses los pulmones y pierdes"
                + " 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("Estos monstruos resultan bastante "
                + "superficiales y te aburren mortalmente. Estas muerto",true);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros"
                + " ocultos", 2, 0, 2);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.ONEHAND);
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes"
                + " una mano visible", 0, svt, new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));
        /*****************************************************/

        badConsequence = new BadConsequence("Da mucho asquito. Pierdes "
                + "3 niveles", 3, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien "
                + "mal su nombre. Estas muerto", true);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto.", true);
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.BOTHHANDS);
        badConsequence= new BadConsequence("La quinta directiva primaria te obliga a "
                + "perder 2 niveles, un tesoro 2 manos visible",2,svt,new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.HELMET);
        badConsequence= new BadConsequence("Te asusta en la noche. Pierdes un casco "
                + "visible.",0,svt,new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));
        /*****************************************************/
        
        badConsequence= new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles "
                + "y 5 tesoros visibles.",2,5,0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas", 20, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.ONEHAND);
        svt.add(TreasureKind.ONEHAND);
        svt.add(TreasureKind.BOTHHANDS);
        badConsequence= new BadConsequence("Te faltan manos para tanta cabeza. "
                + "Pierdes 3 niveles y tus tesoros visibles de las manos.",3,svt,new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        // Fin de cartas de monstruos
    }
    
    //Baraja el mazo de cartas de tesoros unusedTreasures
    private void shuffleTreasures(){
       Collections.shuffle(unusedTreasures);
    }
    
    //Baraja el mazo de cartas de monstruos unusedMonsters
    private void shuffleMonster(){
        Collections.shuffle(usedMonsters);
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
