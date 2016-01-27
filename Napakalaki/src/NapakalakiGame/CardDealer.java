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
    ArrayList<Cultist> unusedCultist;
    
    //El constructor privado asegura que no se puede instanciar
    //desde otras clases
    private CardDealer () {
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
        unusedCultist = new ArrayList();
    }
    
    public static CardDealer getInstance(){
        return instance;
    }
    
    //Métodos privados
    
    /** 
     * Inicializa el mazo de cartas Tesoros (unusedTreasures)
     */
    private void initTreasureCardDeck() {
        unusedTreasures.add(new Treasure ("¡Si mi amo!",4,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure ("Botas de investigacion",3,TreasureKind.SHOE));
        unusedTreasures.add(new Treasure ("Capucha de Cthulhu",3,TreasureKind.HELMET));   
        unusedTreasures.add(new Treasure ("A prueba de babas",2,TreasureKind.ARMOR));   
        unusedTreasures.add(new Treasure ("Botas de lluvia acida",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Casco minero",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure ("Ametralladora Thompson",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Camiseta de la UGR",1,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure ("Clavo de rail ferroviario",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Cuchillo de sushi arcano",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Fez alopodo",3,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure ("Hacha prehistorica",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("El aparato del Pr. Tesla",4,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure ("Gaita",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Insecticida",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Escopeta de 3 cañones",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Garabato mistico",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("La rebeca metalica",2,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure ("Lanzallamas",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Necro comicon",1,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Necronomicon",5,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Linterna a 2 manos",3,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Necro-gnomicon",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Necrotelecom",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure ("Mazo de los antiguos",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Necro playboycon",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Porra preternatural",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Shogulador",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure ("Varita de atizamiento",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure ("Tentaculo de pega",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure ("Zapato deja-amigos",1,TreasureKind.SHOE));
        
    }
    
    /**
     * Inicializa el mazo de cartas de Mostruos (unusedMonsters)
     */
    private void initMonsterCardDeck() {
        BadConsequence badConsequence;
        Prize prize;
        ArrayList<TreasureKind> sht = new ArrayList();
        ArrayList<TreasureKind> svt = new ArrayList();
        
        /*****************************************************/
        sht = new ArrayList();
        svt = new ArrayList();
        sht.add(TreasureKind.ARMOR);
        svt.add(TreasureKind.ARMOR);
        badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y "
                + "otra oculta", 0, svt, sht);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.HELMET);
        badConsequence = new SpecificBadConsequence("Embobados con el lindo"
                + "primigenio te descartas de tu casco visible", 0, svt, new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        /*****************************************************/
       
        svt = new ArrayList();
        svt.add(TreasureKind.SHOE);
        badConsequence = new SpecificBadConsequence("El primordial bostezo"
                + "contagioso. Pierdes el calzado visible", 0, svt, new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        /*****************************************************/
        
        sht = new ArrayList();
        svt = new ArrayList();
        sht.add(TreasureKind.ONEHAND);
        svt.add(TreasureKind.ONEHAND);
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta"
                + " y te dejan caer en mitad del vuelo. Descarta 1 mano visible"
                + " y 1 mano oculta", 0, svt, sht);
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles" 
                , 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.ARMOR);
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible", 0, svt, new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.ARMOR);
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. "
                + " Descarta la armadura visible", 0, svt, new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros "
                + "visibles", 5, 3, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new NumericBadConsequence("Toses los pulmones y pierdes"
                + " 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new DeathBadConsequence("Estos monstruos resultan bastante "
                + "superficiales y te aburren mortalmente. Estas muerto");
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros"
                + " ocultos", 2, 0, 2);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.ONEHAND);
        badConsequence = new SpecificBadConsequence("Te intentas escaquear. Pierdes"
                + " una mano visible", 0, svt, new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));
        /*****************************************************/

        badConsequence = new NumericBadConsequence("Da mucho asquito. Pierdes "
                + "3 niveles", 3, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien "
                + "mal su nombre. Estas muerto");
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new DeathBadConsequence("La familia te atrapa. Estás muerto.");
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.BOTHHANDS);
        badConsequence= new SpecificBadConsequence("La quinta directiva primaria te obliga a "
                + "perder 2 niveles, un tesoro 2 manos visible",2,svt,new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.HELMET);
        badConsequence= new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco "
                + "visible.",0,svt,new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));
        /*****************************************************/
        
        badConsequence= new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles "
                + "y 5 tesoros visibles.",2,5,0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas", 20, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.ONEHAND);
        svt.add(TreasureKind.ONEHAND);
        svt.add(TreasureKind.BOTHHANDS);
        badConsequence= new SpecificBadConsequence("Te faltan manos para tanta cabeza. "
                + "Pierdes 3 niveles y tus tesoros visibles de las manos.",3,svt,new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        /*****************************************************/
        //          MONSTRUOS PARA SECTARIOS
        svt = new ArrayList();
        svt.add(TreasureKind.ONEHAND);
        badConsequence= new SpecificBadConsequence("Pierdes 1 mano visible.",0,svt,new ArrayList());
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize,-2));
        /*****************************************************/
        
        badConsequence= new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.",0,BadConsequence.MAXTREASURES,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos Oculares",6, badConsequence, prize,2));
        /*****************************************************/
        
        badConsequence = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres.");
        prize = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran Cthulhu", 20, badConsequence, prize,4));
        /*****************************************************/
        
        badConsequence= new NumericBadConsequence("Tu gobierno te recorta 2 niveles.",2,0,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Político",8, badConsequence, prize,-2));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.HELMET);
        svt.add(TreasureKind.ARMOR);
        
        sht = new ArrayList();
        sht.add(TreasureKind.BOTHHANDS);
        sht.add(TreasureKind.ONEHAND);
        sht.add(TreasureKind.ONEHAND);
        badConsequence= new SpecificBadConsequence("Pierdes tu casco y tu armadura visible"
                + ". Pierdes tus manos ocultas.",0,svt,sht);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize,5));
        /*****************************************************/
        
        badConsequence= new NumericBadConsequence("Pierdes 2 niveles.",2,0,0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth",16, badConsequence, prize,-4));
        /*****************************************************/
        
        badConsequence= new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles.",2,0,0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth",2, badConsequence, prize,3));
        
        
        
        // Fin de cartas de monstruos
    }
    
    //Inizializa el mazo de Sectarios
    private void initCultistCardDeck(){
        unusedCultist.add(new Cultist("Sectario", 1));
        unusedCultist.add(new Cultist("Sectario", 2));
        unusedCultist.add(new Cultist("Sectario", 1));
        unusedCultist.add(new Cultist("Sectario", 2));
        unusedCultist.add(new Cultist("Sectario", 1));
        unusedCultist.add(new Cultist("Sectario", 1));
    }
    
    //Baraja el mazo de cartas de Sectarios
    private void shuffleCultists(){
        Collections.shuffle(unusedCultist);
    }
    
    
    //Baraja el mazo de cartas de tesoros unusedTreasures
    private void shuffleTreasures(){
       Collections.shuffle(unusedTreasures);
    }
    
    //Baraja el mazo de cartas de monstruos unusedMonsters
    private void shuffleMonster(){
        Collections.shuffle(unusedMonsters);
    }
    
    //Métodos públicos
    
    /**
     * Devuelve el siguiente tesoro que hay en el mazo de tesoros y lo elimina
     * de él. 
     * Si al iniciar el método el mazo estuviese vacío, pasa el mazo de decartes
     * al mazo de tesoros y lo baraja.
     */

    public Treasure nextTreasure(){
        Treasure nuevo_tesoro ;
        // Si esta vacio el mazo de tesoros.
        if(unusedTreasures.isEmpty()){
            unusedTreasures = new ArrayList(usedTreasures);
            usedTreasures.clear();
            shuffleTreasures();
        }
        nuevo_tesoro = unusedTreasures.get(unusedTreasures.size()-1);
        unusedTreasures.remove(unusedTreasures.size()-1);
        return nuevo_tesoro;
    }
    
    
    /**
     * Devuelve el siguiente monstruo que hay en el mazo de monstruos y lo elimina
     * de él. 
     * Si al iniciar el método el mazo estuviese vacío, pasa el mazo de decartes
     * al mazo de monstruos y lo baraja.
     */
    public Monster nextMonster(){
        Monster nuevo_monstruo ;
        // Si esta vacio el mazo de monstruos.
        if(unusedMonsters.isEmpty()){
            unusedMonsters = new ArrayList(usedMonsters);
            usedMonsters.clear();
            shuffleMonster();
        }
        nuevo_monstruo = unusedMonsters.get(unusedMonsters.size()-1);
        unusedMonsters.remove(unusedMonsters.size()-1);
        return nuevo_monstruo;
    }
    
    public Cultist nextCultist(){
        Cultist nuevo_cultist ;      
        nuevo_cultist = unusedCultist.get(unusedCultist.size()-1);
        unusedCultist.remove(unusedCultist.size()-1);
        return nuevo_cultist;
    }
    
    /**
     * Introduce en el mazo de descartes de tesoros (usedTreasures) el tesoro t
     * @param t tesoro que se inserta en el mazo de descartes.
     */
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    /**
     * Introduce en el mazo de descartes de monstruos (usedMonster) al monstruo m
     * @param m monstruo que se inserta en el mazo de descartes.
     */
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    /**
     * Inicializa los mazos
     */
    public void initCards(){
        initTreasureCardDeck();
        initMonsterCardDeck();
        initCultistCardDeck();
        //Barajamos los mazos de cartas
        shuffleMonster();
        shuffleTreasures();
        shuffleCultists();
        
    }
    
}
