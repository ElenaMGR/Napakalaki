/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

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
        Prize prize1 = new Prize(1, 1);
        
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
        System.out.println("fin.");
        // Fin de prueba
        
        // Cartas de Monstruos
        ArrayList<Monster> monstruos = new ArrayList();
        BadConsequence badConsequence;
        Prize prize;
        ArrayList<TreasureKind> sht = new ArrayList();
        ArrayList<TreasureKind> svt = new ArrayList();
        
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros "
                + "visibles", 5, 3, 0);
        prize = new Prize(4,2);
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        sht = new ArrayList();
        svt = new ArrayList();
        sht.add(TreasureKind.ARMOR);
        svt.add(TreasureKind.ARMOR);
        badConsequence = new BadConsequence("Pierdes tu armadura visible y "
                + "otra oculta", 0, svt, sht);
        prize = new Prize(2,1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        svt = new ArrayList();
        svt.add(TreasureKind.HELMET);
        badConsequence = new BadConsequence("Embobados con el lindo"
                + "primigenio te descartas de tu casco visible", 0, svt, null);
        prize = new Prize(1,1);
        monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        svt = new ArrayList();
        svt.add(TreasureKind.SHOES);
        badConsequence = new BadConsequence("El primordial bostezo"
                + "contagioso. Pierdes el calzado visible", 0, svt, null);
        prize = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        sht = new ArrayList();
        svt = new ArrayList();
        sht.add(TreasureKind.ONEHAND);
        svt.add(TreasureKind.ONEHAND);
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta"
                + " y te dejan caer en mitad del vuelo. Descarta 1 mano visible"
                + " y 1 mano oculta", 0, svt, sht);
        prize = new Prize(4,1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra "
                + "oculta", 0, TreasureKind.values().length, 0);
        prize = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        
        
        svt = new ArrayList();
        svt.add(TreasureKind.ARMOR);
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, svt, null);
        prize = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft", 2, badConsequence, prize));
        
        
        svt = new ArrayList();
        svt.add(TreasureKind.ARMOR);
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                + " Descarta la armadura visible", 0, svt, null);
        prize = new Prize(1,1);
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Toses los pulmones y pierdes"
                + " 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Estos monstruos resultan bastante "
                + "superficiales y te aburren mortalmente. Estas muerto",true);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros"
                + " ocultos", 2, 0, 2);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        svt = new ArrayList();
        svt.add(TreasureKind.ONEHAND);
        badConsequence = new BadConsequence("Te intentas escacear. Pierdes"
                + " una mano visible", 0, svt, null);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        

        badConsequence = new BadConsequence("Da mucho asquito. Pierdes "
                + "3 niveles", 3, 0, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien "
                + "mal su nombre. Estas muerto", true);
        prize = new Prize(3,1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("La familia te atrapa", true);
        prize = new Prize(4,1);
        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
    }
    
}
