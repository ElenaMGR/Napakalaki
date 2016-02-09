/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
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
        
        
        //Creamos los jugadores
        ArrayList<String> names;
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView,true);
        names=namesCapture.getNames();
        //Iniciamos el juego
        game.initGame(names);
        
        napakalakiView.setNapakalaki(game);
        napakalakiView.repaint();
        napakalakiView.revalidate();
        
        //Visualiza la ventana (debe ser última línea)
        napakalakiView.setVisible(true);  
        
    }
    
}
