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
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Prueba de funcionamiento de las clases
        /*Prize prize1 = new Prize(1, 1);
        
        BadConsequence bc = new BadConsequence("Mal rollo - const 1", true);
        BadConsequence bc1 = new BadConsequence("Mal Rollo - const 2", 2, 1, 1);
        ArrayList<TreasureKind> sht1 = new ArrayList();
        ArrayList<TreasureKind> svt1 = new ArrayList();
        sht1.add(TreasureKind.ARMOR);
        sht1.add(TreasureKind.HELMET);
        svt1.add(TreasureKind.BOTHHANDS);
        BadConsequence bc2 = new BadConsequence("mal rollo - const 3", 3,svt1 , sht1);
        
        Monster mons = new Monster("Monstruo", 4, bc1, prize1);
        
        System.out.println(prize1.toString());
        System.out.println(bc.toString());
        System.out.println(bc1.toString());
        System.out.println(bc2.toString());
        System.out.println(mons.toString());
        System.out.println("fin.");*/
        // Fin de prueba
        
        ArrayList<Monster> monstruos = new ArrayList();
        ArrayList<Monster> consulta = new ArrayList();
        monstruos = loadMonster();
        
        System.out.println("Consulta monstruos que tiene un nivel de combate superior a 10.");
        consulta = combatLvlG10(monstruos);
        for(int i=0;i<consulta.size();i++){
            System.out.println(consulta.get(i).toString());
        }
        System.out.println("--------------------------------------------\n");
        System.out.println("Consulta monstruos que tengan un mal rollo que implique "
                + "sólo pérdida de niveles.");
        consulta = BadCLoselvl(monstruos);
        for(int i=0;i<consulta.size();i++){
            System.out.println(consulta.get(i).toString());
        }
        System.out.println("--------------------------------------------\n");
        System.out.println("Consulta monstruos que su buen rollo indique una "
                + "ganancia de niveles superior a 1.");
        consulta = prizeWinLvl(monstruos);
        for(int i=0;i<consulta.size();i++){
            System.out.println(consulta.get(i).toString());
        }
        System.out.println("--------------------------------------------\n");
        System.out.println("Consulta monstruos que su mal rollo suponga la"
                + " pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos");
        consulta = BadCLoseUnDeterminadoTesoro(monstruos);
        for(int i=0;i<consulta.size();i++){
            System.out.println(consulta.get(i).toString());
        }
        
        
        
    }
    
    /**
     * Consulta monstruos que tiene un nivel de combate superior a 10.
     * 
     * @return ArrayList<Monster> monstruos que cumplen la condicion
     */
    static private ArrayList<Monster> combatLvlG10(ArrayList<Monster> monstruos){
        ArrayList<Monster> resultado = new ArrayList();
        for (Monster monstruo : monstruos) {
            if (monstruo.getCombatLevel() > 10) {
                resultado.add(monstruo);
            }
        }
        return resultado;
    }
    
    
    /**
     * Consulta monstruos que tengan un mal rollo que implique sólo pérdida 
     * de niveles.
     * 
     * @return ArrayList<Monster> monstruos que cumplen la condicion
     */
    static private ArrayList<Monster> BadCLoselvl(ArrayList<Monster> monstruos){
        ArrayList<Monster> resultado = new ArrayList();
        for (Monster monstruo : monstruos) {
            if (monstruo.getBadConsequence().getLevels() > 0 && 
                    monstruo.getBadConsequence().isDeath() == false &&
                    monstruo.getBadConsequence().getNHiddenTreasures() == 0 &&
                    monstruo.getBadConsequence().getNVisibleTreasures() == 0 &&
                    monstruo.getBadConsequence().getSpecificHiddenTreasures().isEmpty() &&
                    monstruo.getBadConsequence().getSpecificVisibleTreasures().isEmpty()) {
                resultado.add(monstruo);
            }
        }
       return resultado;
    }   
    
    /**
     * Consulta monstruos que su buen rollo indique una ganancia de niveles 
     * superior a 1.
     * 
     * @return ArrayList<Monster> monstruos que cumplen la condicion
     */
    static private ArrayList<Monster> prizeWinLvl(ArrayList<Monster> monstruos){
        ArrayList<Monster> resultado = new ArrayList();
        for (Monster monstruo : monstruos) {
            if (monstruo.getLevelsGained() > 1) {
                resultado.add(monstruo);
            }
        }
        return resultado;
    }
    
    /**
     * Consulta monstruos que su mal rollo suponga la pérdida de un determinado 
     * tipo de tesoros ya sea visibles y/o ocultos
     * 
     * @return ArrayList<Monster> monstruos que cumplen la condicion
     */
    static private ArrayList<Monster> BadCLoseUnDeterminadoTesoro(ArrayList<Monster> monstruos){
        ArrayList<Monster> resultado = new ArrayList();
        for (Monster monstruo : monstruos) {
            if (!monstruo.getBadConsequence().getSpecificHiddenTreasures().isEmpty() ||
                !monstruo.getBadConsequence().getSpecificVisibleTreasures().isEmpty()) {
                resultado.add(monstruo);
            }
        }
        return resultado;
    }
    
    
    /**
     * Cargamos las cartas de monstruos
     * @return ArrayList<Monster> con todos los monstruos
     */
    static private ArrayList<Monster> loadMonster(){
    // Cartas de Monstruos
        ArrayList<Monster> monstruos = new ArrayList();
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
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.HELMET);
        badConsequence = new BadConsequence("Embobados con el lindo"
                + "primigenio te descartas de tu casco visible", 0, svt, new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.SHOE);
        badConsequence = new BadConsequence("El primordial bostezo"
                + "contagioso. Pierdes el calzado visible", 0, svt, new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        /*****************************************************/
        
        sht = new ArrayList();
        svt = new ArrayList();
        sht.add(TreasureKind.ONEHAND);
        svt.add(TreasureKind.ONEHAND);
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta"
                + " y te dejan caer en mitad del vuelo. Descarta 1 mano visible"
                + " y 1 mano oculta", 0, svt, sht);
        prize = new Prize(4,1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles" 
                , 0, (TreasureKind.values().length)+1, 0);
        prize = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.ARMOR);
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, svt, new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.ARMOR);
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                + " Descarta la armadura visible", 0, svt, new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros "
                + "visibles", 5, 3, 0);
        prize = new Prize(4,2);
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("Toses los pulmones y pierdes"
                + " 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("Estos monstruos resultan bastante "
                + "superficiales y te aburren mortalmente. Estas muerto",true);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros"
                + " ocultos", 2, 0, 2);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.ONEHAND);
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes"
                + " una mano visible", 0, svt, new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        /*****************************************************/

        badConsequence = new BadConsequence("Da mucho asquito. Pierdes "
                + "3 niveles", 3, 0, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien "
                + "mal su nombre. Estas muerto", true);
        prize = new Prize(3,1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        /*****************************************************/
        
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto.", true);
        prize = new Prize(4,1);
        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.BOTHHANDS);
        badConsequence= new BadConsequence("La quinta directiva primaria te obliga a "
                + "perder 2 niveles un tesoro 2 manos visible",2,svt,new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.HELMET);
        badConsequence= new BadConsequence("Te asusta en la noche. Pierdes un casco "
                + "visible.",0,svt,new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El espia", 5, badConsequence, prize));
        /*****************************************************/
        
        badConsequence= new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles "
                + "y 5 tesoros visibles.",2,5,0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("El Lenguas", 20, badConsequence, prize));
        /*****************************************************/
        
        svt = new ArrayList();
        svt.add(TreasureKind.ONEHAND);
        svt.add(TreasureKind.ONEHAND);
        svt.add(TreasureKind.BOTHHANDS);
        badConsequence= new BadConsequence("Te faltan manos para tanta cabeza. "
                + "Pierdes 3 niveles y tus tesoros visibles de las manos.",3,svt,new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        // Fin de cartas de monstruos
    
        return monstruos;
    }
    
}