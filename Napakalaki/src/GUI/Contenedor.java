/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author elena
 */
public class Contenedor extends Container {

    // La imagen que queremos de fondo, un fichero .gif
    public ImageIcon icono;
    public Contenedor (String nombre){
        icono = new ImageIcon("/Backgrouds/"+nombre+".png");
    }
    // Redefinición del método paint()
    public void paint(Graphics g) {
        // Borramos todo y lo pintamos del color de fondo por defecto.
        Rectangle r = g.getClipBounds();
        g.setColor(this.getBackground());
        g.fillRect(r.x, r.y, r.width, r.height);

        // Pintamos la imagen
        g.drawImage(icono.getImage(), 0, 0, this);

        // Hacemos que se pinten los botones dentro de este contenedor
        super.paint(g);
    }

}
