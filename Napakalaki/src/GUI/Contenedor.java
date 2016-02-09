/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author elena
 */
public class Contenedor extends Container {

    // La imagen que queremos de fondo, un fichero .gif
    public ImageIcon icono;
    public Contenedor (String nombre){
        BufferedImage imagen=null;
        try {
        String ruta = "Backgrounds/"+nombre+".png";
            imagen = ImageIO.read(getClass().getResource(ruta));
        } catch (IOException ex) {
            Logger.getLogger("Error backgrounds").log(Level.SEVERE, null, ex);
        }
             
        icono = new ImageIcon(imagen);
    }
    // Redefinición del método paint()
    @Override
    public void paint(Graphics g) {       
        // Pintamos la imagen
        g.drawImage(icono.getImage(), 0, 0, this.getWidth(), this.getHeight(), this.getBackground(), this);

        // Hacemos que se pinten los botones dentro de este contenedor
        super.paint(g);
    }

}
