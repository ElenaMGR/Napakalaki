/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import GUI.PlayerView;
import java.util.ArrayList;

/**
 *
 * @author elena
 */
public class JuegoMain {
    public static void main(String[] args) {
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        Dice.createInstance(napakalakiView);
        napakalakiView.setNapakalaki(game);
        
        //Creamos los jugadores
        ArrayList<String> names;
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView,true);
        names=namesCapture.getNames();
        //Iniciamos el juego
        game.initGame(names);
        
        Treasure t = new Treasure ("Clavo de rail ferroviario",3,TreasureKind.ONEHAND);
        //TreasureView tre = new TreasureView();
        //tre.setTreasure(t);
        
        Player p = new Player("Josasdffffffffffffffffffffffffffffffffffffffffe");
        Player p2 = new Player("Elesdfsdfffffffffffffffffffffffffffffffffffffffffffffffffffna");
        p.setEnemy(p2);
        p.initTreasures();
        PlayerView pla = new PlayerView();
        pla.setPlayer(p);
        pla.setVisible(true);
        
        napakalakiView.add(pla);
        napakalakiView.repaint();
        napakalakiView.revalidate();
        //Visualiza la ventana (debe ser última línea)
        napakalakiView.setVisible(true);  
    }
    
}
