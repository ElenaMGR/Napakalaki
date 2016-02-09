package GUI;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elena María Gómez Ríos, Jose Luis Martínez Ortiz
 */
public class Reglas extends javax.swing.JDialog {
    int npagina;
    ArrayList<String> texto= new ArrayList();
    /**
     * Creates new form Reglas
     */
    public Reglas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setContentPane(new Contenedor("fondo_reglas"));       
        initComponents();
        
        
        jTextArea1.setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jBback.setOpaque(false);
        jBnext.setOpaque(false);
        jBback.setContentAreaFilled(false);
        jBback.setBorderPainted(false);
        jBnext.setContentAreaFilled(false);
        jBnext.setBorderPainted(false);
        
        jBback.setVisible(false);
        
        jTextArea1.setLineWrap(true);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setWrapStyleWord(true);
        
        inicializarTextos();
        jTextArea1.setText(texto.get(0));
        npagina = 1;
        
        repaint();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jBback = new javax.swing.JButton();
        jBnext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reglas.");
        setResizable(false);

        jScrollPane1.setBorder(null);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(10);
        jTextArea1.setFont(new java.awt.Font("URW Chancery L", 0, 20)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(254, 254, 254));
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        jBback.setForeground(new java.awt.Color(254, 254, 254));
        jBback.setText("<- Atras");
        jBback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbackActionPerformed(evt);
            }
        });

        jBnext.setForeground(new java.awt.Color(254, 254, 254));
        jBnext.setText("Siguiente ->");
        jBnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBback, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jBnext, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBback)
                    .addComponent(jBnext))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnextActionPerformed
        npagina++; 
        jTextArea1.setText(texto.get(npagina-1));
        if (npagina==2){
            jBback.setVisible(true);
        }else if (npagina==texto.size()){
            jBnext.setVisible(false);
        }
        jTextArea1.setCaretPosition(0);
    }//GEN-LAST:event_jBnextActionPerformed

    private void jBbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbackActionPerformed
        npagina--;
        jTextArea1.setText(texto.get(npagina-1));    
        if (npagina==1){
            jBback.setVisible(false);
        }else if (npagina==texto.size()-1){
            jBnext.setVisible(true);
        }
        jTextArea1.setCaretPosition(0);
    }//GEN-LAST:event_jBbackActionPerformed
    private void inicializarTextos(){
        texto.add("        Juego Napakalaki \n\n"
                + "   El número de jugadores es de 2 a 6.\n\n"
                + "   Al inicio del juego todos los jugadores tendrán nivel 1 y el primero en "
                + "alcanzar el nivel 10 seŕa el ganador.\n\n"
                + "   A cada jugador se le asignará al azar un archienemigo que será uno de los "
                + "otros jugadores.\n");
        texto.add("   La dinámica del juego consiste en ir combatiendo con monstruos utilizando"
                + "una serie de armas o tesoros. Dependiendo de que se gane o se pierda el combate"
                + "se irá incrementando o decrementando el nivel y ganando o perdiendo tesoros.\n\n"
                + "   Por tanto hay dos barajas de cartas, una para los monstruos contra los "
                + "que se combate y otra para los tesoros que nos sirven de ayuda en esos combates.\n\n"
                + "   Después del combate el jugador puede robarle una carta oculta a su enemigo. Esto"
                + " solo se podrá hacer una vez en toda la partida.");
        texto.add("        Tesoros\n\n"
                + "   Cada carta posee un nombre, un bonus y un tipo.\n"
                + "   El bonus aumenta el nivel de combate del jugador.\n"
                + "   Tipos de tesoros: armas de una o dos manos, casco, calzado y armadura.\n\n"
                + "   Solo se podrá tener equipado un tesoro de cada tipo, salvo para el caso de "
                + "armas. Puedes equiparte hasta dos armas de una mano. Si se tiene equipada un "
                + "arma de dos manos, no puedes equiparte de más armas.\n\n"
                + "   Se pueden tener 4 tesoros ocultos como máximo y no será posible volver"
                + "a ocultar cartas ya equipadas.");
        texto.add("        Monstruos\n\n"
                + "   Cada monstruo posee un nombre, un nivel de combate, un buen rollo y un mal rollo.\n"
                + "   El buen rollo indica el incremento de nivel y/o tesoros si se consigue vencer al "
                + "monstruo.\n"
                + "   El mal rollo indica el decremento de nivel y/o tesoros que perderá el jugador"
                + "si pierde el combate contra el monstruo.\n\n"
                + "   Existen monstruos con cualidades especiales contra jugadores sectarios.");
        texto.add("       Jugadores Sectarios\n\n"
                + "   Si un jugador pierde un combate tirará el dado para saber si se convierte"
                + "en sectario, si sale un 1 se convierte.\n\n"
                + "   Al tranformarse en sectario el jugador robará una carta de sectario que "
                + "indica el bonus de sectario, que afecta a su nivel de combate.\n\n"
                + "   Cuando un jugador roba una carta a un jugador sectario, este debe darle una "
                + "carta equipada al azar.\n\n"
                + "   Existen monstruos que incluyen un aumento o reducción del nivel de combate"
                + " cuando se enfrentan a jugadores sectarios.\n\n"
                + "   Una vez que un jugador adquiere el carácter de sectario nunca pierde esta"
                + "condición.");
        texto.add("        Desarollo del juego\n\n"
                + "   Al inicio del juego se decide al azar el jugador que comenzará la partida.\n\n"
                + "   Cada jugador lanza un dado al principio del juego o cuando se queda sin cartas"
                + " para saber cuantas cartas robará. 1 tesoro si saca un 1, 2 tesoros si saca "
                + "entre un 2 y un 5, y 3 tesoros si saca un 6.\n\n"
                + "   Un jugador podrá equiparse cartas antes de conocer al monstruo o después del "
                + "combate.");
        texto.add("        Combate\n\n"
                + "   Si el nivel de combate del monstruo es mayor o igual que el del jugador, el "
                + "jugador perderá el combate y deberá cumplir su mal rollo.\n\n"
                + "   Si por el contrario es menor, el jugador ganará el combate y obtendrá "
                + "el buen rollo de dicho muestruo.");
        texto.add("        Sobre el Juego\n\n"
                + "   Basado en el conocido juego de rol diseñado por Steve Jackson llamado"
                + " Munchkin.\n");
    }
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBback;
    private javax.swing.JButton jBnext;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
