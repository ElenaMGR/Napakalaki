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
        Prize prize = new Prize(1, 1);
        
        BadConsequence bc = new BadConsequence("Mal rollo - const 1", true);
        BadConsequence bc1 = new BadConsequence("Mal Rollo - const 2", 2, 1, 1);
        ArrayList<TreasureKind> sht = new ArrayList();
        ArrayList<TreasureKind> svt = new ArrayList();
        sht.add(TreasureKind.ARMOR);
        sht.add(TreasureKind.HELMET);
        svt.add(TreasureKind.BOTHHANDS);
        BadConsequence bc2 = new BadConsequence("mal rollo - const 3", 3,svt , sht);
        
        Monster mons = new Monster("Monstruo", 4, bc1, prize);
        
        System.out.println(prize.toString());
        System.out.println(bc.toString());
        System.out.println(bc1.toString());
        System.out.println(bc2.toString());
        System.out.println(mons.toString());
        System.out.println("fin.");
        // Fin de prueba
        
        
        
    
    }
    
}
